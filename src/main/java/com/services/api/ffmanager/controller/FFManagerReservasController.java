package com.services.api.ffmanager.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.services.api.ffmanager.business.GeneralServices;
import com.services.api.ffmanager.business.InstitucionalServices;
import com.services.api.ffmanager.business.PerfilesServices;
import com.services.api.ffmanager.business.ReservasServices;
import com.services.api.ffmanager.domain.dto.ItemsMenuDTO;
import com.services.api.ffmanager.domain.dto.LoginDTO;
import com.services.api.ffmanager.domain.dto.MaterialCantidadDTO;
import com.services.api.ffmanager.domain.dto.ReservaDeSectorDTO;
import com.services.api.ffmanager.domain.dto.ReservasDTO;
import com.services.api.ffmanager.domain.dto.SectoresDTO;
import com.services.api.ffmanager.domain.dto.UsuariosDTO;
import com.services.api.ffmanager.domain.entities.Actividades;
import com.services.api.ffmanager.domain.entities.ActividadesDeReserva;
import com.services.api.ffmanager.domain.entities.Materiales;
import com.services.api.ffmanager.domain.entities.MaterialesDeReserva;
import com.services.api.ffmanager.domain.entities.Reservas;
import com.services.api.ffmanager.domain.entities.Sectores;
import com.services.api.ffmanager.domain.entities.Usuarios;
import com.services.api.ffmanager.utils.Utilities;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@RestController("reservas-services")
@Slf4j
@RequestMapping(value = "/api-services/reservas-services", produces = MediaType.APPLICATION_JSON_VALUE)
public class FFManagerReservasController {
	
	@Autowired
	private final ModelMapper mapper;
	@Autowired
	private ReservasServices reservasServices;
	@Autowired
	private GeneralServices generalServices;
	@Autowired
	private InstitucionalServices institucionalServices;
	@Autowired
	private PerfilesServices perfilesServices;

	@Autowired
	public FFManagerReservasController(ModelMapper mapper, ReservasServices reservasService,
			GeneralServices generalServices, InstitucionalServices institucionalServices,
			PerfilesServices perfilesServices) {
		this.mapper = mapper;
		this.reservasServices = reservasService;
		this.generalServices = generalServices;
		this.institucionalServices = institucionalServices;
		this.perfilesServices = perfilesServices;
	}
	
	
	@GetMapping(value = "/reservas/get-all-sectores-disponibles/{fechaDesde}/{fechaHasta}")
	public ResponseEntity<Object> getAllSectoresDisponibles(@PathVariable("fechaDesde") String fechaDesde, @PathVariable("fechaHasta") String fechaHasta) {

		Collection<Sectores> datos = null;
		try {
			datos = reservasServices.getAllSectoresDisponibles(Utilities.getDateTimeFromString(fechaDesde), Utilities.getDateTimeFromString(fechaHasta));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<SectoresDTO> listaDatosDTO = new ArrayList<SectoresDTO>();
		for (Sectores dato : datos) {
			SectoresDTO datoDTO = mapper.map(dato,
					SectoresDTO.class);
			listaDatosDTO.add(datoDTO);
		}
		return new ResponseEntity<>(listaDatosDTO, HttpStatus.OK);
	}
	

	@PostMapping(value = "/reservas/reservar")
	public ResponseEntity<Object> reservar(@RequestBody ReservaDeSectorDTO dto) {
		
		//Busco el sector
		var sector = institucionalServices.getOneSectores(dto.getIdSector());
		
		//Busco el usuario que se le asigna la reserva
		var usuario = perfilesServices.getOneUsuarios(dto.getUsuarioDeReserva());		
		
		Reservas reserva = new Reservas();
		reserva.setFechaDesde(Utilities.getLocalDateTimeFromString(dto.getFechaHoraDesde()));
		reserva.setFechaHasta(Utilities.getLocalDateTimeFromString(dto.getFechaHoraHasta()));
		reserva.setUsuarios(usuario.get());
		
		reservasServices.createReserva(reserva);
		
		
	
		//Busco los materiales y guardo los materiales de la reserva con su cantidad
		MaterialesDeReserva mdr;
		if(dto.getMaterilesDeReserva() != null) {
			for (int i = 0; i < dto.getMaterilesDeReserva().length; i++) {
				var material = generalServices.getOneMateriales(((MaterialCantidadDTO)dto.getMaterilesDeReserva()[i]).getIdMaterial());
				mdr = new MaterialesDeReserva();
				mdr.setMateriales(material.get());
				mdr.setReservas(reserva);
				mdr.setCantidad(Integer.parseInt(((MaterialCantidadDTO)dto.getMaterilesDeReserva()[i]).getCantidad()));
				reservasServices.createMaterialesDeReserva(mdr);
			}
		}
		
		//Busco las actividades y las cargo en una lista
		ActividadesDeReserva adr;
		if(dto.getActividadesDeReserva() != null) {
			for (int i = 0; i < dto.getActividadesDeReserva().length; i++) {
				var actividad = generalServices.getOneActividades(dto.getActividadesDeReserva()[i]);
				adr = new ActividadesDeReserva();
				adr.setActividades(actividad.get());
				adr.setReservas(reserva);
				reservasServices.createActividadesDeReserva(adr);
			}
		}
		

		
			return new ResponseEntity<>(mapper.map(reserva, ReservasDTO.class), HttpStatus.OK);
		
		
	}

}
