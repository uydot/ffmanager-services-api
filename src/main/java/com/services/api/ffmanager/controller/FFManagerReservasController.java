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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.services.api.ffmanager.business.ReservasServices;
import com.services.api.ffmanager.domain.dto.SectoresDTO;
import com.services.api.ffmanager.domain.dto.UsuariosDTO;
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
	
	public FFManagerReservasController(ModelMapper mapper, ReservasServices reservasService) {
		this.mapper = mapper;
		this.reservasServices = reservasService;
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


}
