package com.services.api.ffmanager.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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
import com.services.api.ffmanager.domain.dto.AreasSimpleDTO;
import com.services.api.ffmanager.domain.dto.EstadosDeSectoresSimpleDTO;
import com.services.api.ffmanager.domain.dto.MaterialCantidadDTO;
import com.services.api.ffmanager.domain.dto.ReservaDeSectorTransferDTO;
import com.services.api.ffmanager.domain.dto.ReservasDTO;
import com.services.api.ffmanager.domain.dto.ResultadoBusquedaSectoresDTO;
import com.services.api.ffmanager.domain.dto.SectoresDTO;
import com.services.api.ffmanager.domain.dto.SectoresSimpleDTO;
import com.services.api.ffmanager.domain.entities.ActividadesDeReserva;
import com.services.api.ffmanager.domain.entities.Areas;
import com.services.api.ffmanager.domain.entities.MaterialesDeReserva;
import com.services.api.ffmanager.domain.entities.ReservaDeSector;
import com.services.api.ffmanager.domain.entities.Reservas;
import com.services.api.ffmanager.domain.entities.Sectores;
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

	@GetMapping(value = "/reservas/get-all-sectores-disponibles/{idArea}/{fechaDesde}/{fechaHasta}")
	public ResponseEntity<Object> getAllSectoresDisponibles(@PathVariable("idArea") String idArea,
			@PathVariable("fechaDesde") String fechaDesde, @PathVariable("fechaHasta") String fechaHasta) {

		HashMap<String, List<Sectores>> datos = null;
		try {
			datos = reservasServices.getAllSectoresDisponibles(Integer.parseInt(idArea),
					Utilities.getDateTimeFromString(fechaDesde), Utilities.getDateTimeFromString(fechaHasta));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<SectoresSimpleDTO> listaDatosLibresDTO = new ArrayList<SectoresSimpleDTO>();
		List<SectoresSimpleDTO> listaDatosOcupadosDTO = new ArrayList<SectoresSimpleDTO>();
		
		List<SectoresSimpleDTO> listaDatosDTO = new ArrayList<SectoresSimpleDTO>();
		
		for (Sectores dato : datos.get(ReservasServices._libres)) {
			SectoresSimpleDTO datoDTO = mapper.map(dato, SectoresSimpleDTO.class);
			listaDatosLibresDTO.add(datoDTO);
			
			//agrego para devolver una sola lista
			listaDatosDTO.add(datoDTO);
		}
		
		for (Sectores dato : datos.get(ReservasServices._ocupados)) {
			SectoresSimpleDTO datoDTO = mapper.map(dato, SectoresSimpleDTO.class);
			listaDatosOcupadosDTO.add(datoDTO);
			
			//agrego para devolver una sola lista
			
			listaDatosDTO.add(datoDTO);
		}
		
		ResultadoBusquedaSectoresDTO resultDTO = new ResultadoBusquedaSectoresDTO();
		resultDTO.setListaDatosLibresDTO(listaDatosLibresDTO);
		resultDTO.setListaDatosOcupadosDTO(listaDatosOcupadosDTO);
		
		return new ResponseEntity<>(listaDatosDTO, HttpStatus.OK);
	}

	@PostMapping(value = "/reservas/reservar")
	public ResponseEntity<Object> reservar(@RequestBody ReservaDeSectorTransferDTO dto) {

		// Busco el sector
		var sector = institucionalServices.getOneSectores(dto.getIdSector());

		// Busco el usuario que se le asigna la reserva
		var usuario = perfilesServices.getOneUsuarios(dto.getUsuarioDeReserva());

		Reservas reserva = new Reservas();
		reserva.setFechaDesde(Utilities.getLocalDateTimeFromString(dto.getFechaHoraDesde()));
		reserva.setFechaHasta(Utilities.getLocalDateTimeFromString(dto.getFechaHoraHasta()));
		reserva.setUsuarios(usuario.get());

		reservasServices.createReserva(reserva);

		// Busco los materiales y guardo los materiales de la reserva con su cantidad
		MaterialesDeReserva mdr;
		if (dto.getMaterilesDeReserva() != null) {
			for (int i = 0; i < dto.getMaterilesDeReserva().length; i++) {
				var material = generalServices
						.getOneMateriales(((MaterialCantidadDTO) dto.getMaterilesDeReserva()[i]).getIdMaterial());
				mdr = new MaterialesDeReserva();
				mdr.setMateriales(material.get());
				mdr.setReservas(reserva);
				mdr.setCantidad(Integer.parseInt(((MaterialCantidadDTO) dto.getMaterilesDeReserva()[i]).getCantidad()));
				reservasServices.createMaterialesDeReserva(mdr);
			}
		}

		// Busco las actividades y las cargo en una lista
		ActividadesDeReserva adr;
		if (dto.getActividadesDeReserva() != null) {
			for (int i = 0; i < dto.getActividadesDeReserva().length; i++) {
				var actividad = generalServices.getOneActividades(dto.getActividadesDeReserva()[i]);
				adr = new ActividadesDeReserva();
				adr.setActividades(actividad.get());
				adr.setReservas(reserva);
				reservasServices.createActividadesDeReserva(adr);
			}
		}

		// Genero la reserva del sector
		ReservaDeSector rds = new ReservaDeSector();
		rds.setReservas(reserva);
		rds.setSectores(sector.get());
		reservasServices.createReservaDeSector(rds);

		return new ResponseEntity<>(mapper.map(reserva, ReservasDTO.class), HttpStatus.OK);

	}


	@PostMapping(value = "/reservas/set-sector-estado")
	public ResponseEntity<Object> setSectorEstado(@RequestBody EstadosDeSectoresSimpleDTO dto) {
		reservasServices.setEstadoSector(Integer.parseInt(dto.getSector()), Integer.parseInt(dto.getEstado()));
		return new ResponseEntity<>("Estado del sector is created successsfully", HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/reservas/get-all-areas-disponibles/{idComplejo}/{fechaDesde}/{fechaHasta}")
	public ResponseEntity<Object> getAllAreasDisponibles(@PathVariable("idComplejo") String idComplejo,
			@PathVariable("fechaDesde") String fechaDesde, @PathVariable("fechaHasta") String fechaHasta) {
		
		HashMap<String, Areas> hashAreas;
		List<AreasSimpleDTO> listaAreas = new ArrayList<AreasSimpleDTO>();
		try {
			hashAreas = reservasServices.getAllAreasDisponibles(Integer.parseInt(idComplejo), 
						Utilities.getDateTimeFromString(fechaDesde), Utilities.getDateTimeFromString(fechaHasta));
			
			AreasSimpleDTO areaSimple = null;
			if(hashAreas != null) {
				for (String key : hashAreas.keySet()) {   
					areaSimple = new AreasSimpleDTO();
			        areaSimple.setDescripcion(key);
			        areaSimple.setIdArea(""+hashAreas.get(key).getIdArea());
			        areaSimple.setNombre(hashAreas.get(key).getNombre());
			        listaAreas.add(areaSimple);
			    }
			}
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(listaAreas, HttpStatus.OK);
	}
	
}
