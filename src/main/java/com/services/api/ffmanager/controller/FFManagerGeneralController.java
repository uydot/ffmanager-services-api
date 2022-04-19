package com.services.api.ffmanager.controller;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.services.api.ffmanager.business.GeneralServices;
import com.services.api.ffmanager.domain.dto.ActividadesDTO;
import com.services.api.ffmanager.domain.dto.EstadosDTO;
import com.services.api.ffmanager.domain.dto.MaterialesDTO;
import com.services.api.ffmanager.domain.entities.Actividades;
import com.services.api.ffmanager.domain.entities.Estados;
import com.services.api.ffmanager.domain.entities.Materiales;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@RestController("general-services")
@Slf4j
@RequestMapping(value = "/api-services/general-services", produces = MediaType.APPLICATION_JSON_VALUE)
public class FFManagerGeneralController {

	@Autowired
	private final ModelMapper mapper;
	@Autowired
	private GeneralServices generalServices;

	@Autowired
	public FFManagerGeneralController(ModelMapper mapper, GeneralServices generalServices) {
		this.generalServices = generalServices;
		this.mapper = mapper;
	}

	
	
	/**
	 * Rest para Materiales
	 */

	@GetMapping(value = "/materiales/get-all")
	public ResponseEntity<Object> getAllMateriales() {

		Collection<Materiales> datos = generalServices.getAllMateriales();
		List<MaterialesDTO> listaDatosDTO = new ArrayList<MaterialesDTO>();
		for (Materiales dato : datos) {
			MaterialesDTO datoDTO = mapper.map(dato,
					MaterialesDTO.class);
			listaDatosDTO.add(datoDTO);
		}
		return new ResponseEntity<>(listaDatosDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/materiales/get-one/{id}")
	public ResponseEntity<Object> getOneMateriales(@PathVariable("id") String id) {
		var val = generalServices.getOneMateriales(id);
		return new ResponseEntity<>(val.isPresent() ? mapper.map(val.get(), MaterialesDTO.class) : null,
				val.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@PostMapping(value = "/materiales/create")
	public ResponseEntity<Object> createMateriales(@RequestBody MaterialesDTO dto) {
		generalServices.createMateriales(mapper.map(dto, Materiales.class));
		return new ResponseEntity<>("Materiales is created successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/materiales/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateMateriales(@PathVariable("id") String id,
			@RequestBody MaterialesDTO dto) {

		generalServices.updateMateriales(mapper.map(dto, Materiales.class));
		return new ResponseEntity<>("Materiales is updated successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/materiales/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteMateriales(@PathVariable("id") String id) {
		var val = generalServices.getOneMateriales(id);
		if (val.isPresent()) {
			generalServices.deleteMateriales(val.get());
			return new ResponseEntity<>("Materiales is deleted successsfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Materiales is not deleted", HttpStatus.NOT_FOUND);
		}

	}

	/**
	 * Rest para Actividades
	 */

	@GetMapping(value = "/actividades/get-all")
	public ResponseEntity<Object> getAllActividades() {

		Collection<Actividades> datos = generalServices.getAllActividades();
		List<ActividadesDTO> listaDatosDTO = new ArrayList<ActividadesDTO>();
		for (Actividades dato : datos) {
			ActividadesDTO datoDTO = mapper.map(dato,
					ActividadesDTO.class);
			listaDatosDTO.add(datoDTO);
		}
		return new ResponseEntity<>(listaDatosDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/actividades/get-one/{id}")
	public ResponseEntity<Object> getOneActividades(@PathVariable("id") String id) {
		var val = generalServices.getOneActividades(id);
		return new ResponseEntity<>(val.isPresent() ? mapper.map(val.get(), ActividadesDTO.class) : null,
				val.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@PostMapping(value = "/actividades/create")
	public ResponseEntity<Object> createActividades(@RequestBody ActividadesDTO dto) {
		generalServices.createActividades(mapper.map(dto, Actividades.class));
		return new ResponseEntity<>("Actividades is created successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/actividades/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateActividades(@PathVariable("id") String id,
			@RequestBody ActividadesDTO dto) {

		generalServices.updateActividades(mapper.map(dto, Actividades.class));
		return new ResponseEntity<>("Actividades is updated successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/actividades/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteActividades(@PathVariable("id") String id) {
		var val = generalServices.getOneActividades(id);
		if (val.isPresent()) {
			generalServices.deleteActividades(val.get());
			return new ResponseEntity<>("Actividades is deleted successsfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Actividades is not deleted", HttpStatus.NOT_FOUND);
		}

	}
	
	/**
	 * Rest para Estados
	 */

	@GetMapping(value = "/estados/get-all")
	public ResponseEntity<Object> getAllEstados() {

		Collection<Estados> datos = generalServices.getAllEstados();
		List<EstadosDTO> listaDatosDTO = new ArrayList<EstadosDTO>();
		for (Estados dato : datos) {
			EstadosDTO datoDTO = mapper.map(dato,
					EstadosDTO.class);
			listaDatosDTO.add(datoDTO);
		}
		return new ResponseEntity<>(listaDatosDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/estados/get-one/{id}")
	public ResponseEntity<Object> getOneEstados(@PathVariable("id") String id) {
		var val = generalServices.getOneEstado(id);
		return new ResponseEntity<>(val.isPresent() ? mapper.map(val.get(), EstadosDTO.class) : null,
				val.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@PostMapping(value = "/estados/create")
	public ResponseEntity<Object> createEstados(@RequestBody EstadosDTO dto) {
		generalServices.createEstados(mapper.map(dto, Estados.class));
		return new ResponseEntity<>("Estados is created successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/estados/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateEstados(@PathVariable("id") String id,
			@RequestBody EstadosDTO dto) {

		generalServices.updateEstados(mapper.map(dto, Estados.class));
		return new ResponseEntity<>("Estados is updated successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/estados/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteEstados(@PathVariable("id") String id) {
		var val = generalServices.getOneEstado(id);
		if (val.isPresent()) {
			generalServices.deleteEstados(val.get());
			return new ResponseEntity<>("Estados is deleted successsfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Estados is not deleted", HttpStatus.NOT_FOUND);
		}

	}
	


}
