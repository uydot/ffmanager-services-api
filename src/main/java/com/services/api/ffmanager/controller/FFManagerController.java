package com.services.api.ffmanager.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.services.api.ffmanager.business.InstitucionalServices;
import com.services.api.ffmanager.domain.dto.DatosInstitucionDeportivaDTO;
import com.services.api.ffmanager.domain.entities.DatosInstitucionDeportiva;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(value = "/ffmanager/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class FFManagerController {

	@Autowired
	ModelMapper mapper;
	@Autowired
	InstitucionalServices institucionalServices;
	
	@RequestMapping(value = "/instituciones-deportivas/get-all")
	   public ResponseEntity<Object> getAllInstitucionesDeportivas() {
	      return new ResponseEntity<>(institucionalServices.getAllDatosInstitucionDeportiva(), HttpStatus.OK);
	   }
	
	@RequestMapping(value = "/instituciones-deportivas/get-one/{id}")
	   public ResponseEntity<Object> getOneInstitucionesDeportivas(@PathVariable("id") String id) {
		var val = institucionalServices.getOneDatosInstitucionDeportiva(id);
	      return new ResponseEntity<>(val.isPresent() ? val : null, val.isPresent() ? HttpStatus.OK:HttpStatus.NOT_FOUND);
	   }
	
	@RequestMapping(value = "/instituciones-deportivas/create", method = RequestMethod.POST)
	   public ResponseEntity<Object> 
	      crateDatosInstitucionDeportiva(@RequestBody DatosInstitucionDeportivaDTO dto) {
	      
		  institucionalServices.createDatosInstitucionDeportiva(mapper.map(dto, DatosInstitucionDeportiva.class));
	      return new ResponseEntity<>("Institucion Deportiva is updated successsfully", HttpStatus.OK);
	   }
	   
	@RequestMapping(value = "/instituciones-deportivas/update/{id}", method = RequestMethod.PUT)
	   public ResponseEntity<Object> 
	      updateDatosInstitucionDeportiva(@PathVariable("id") String id, @RequestBody DatosInstitucionDeportivaDTO dto) {
	      
		  institucionalServices.updateDatosInstitucionDeportiva(mapper.map(dto, DatosInstitucionDeportiva.class));
	      return new ResponseEntity<>("Institucion Deportiva is updated successsfully", HttpStatus.OK);
	   }
	
}
