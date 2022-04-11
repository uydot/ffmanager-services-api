package com.services.api.ffmanager.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.services.api.ffmanager.business.InstitucionalServices;
import com.services.api.ffmanager.domain.dto.AreasDTO;
import com.services.api.ffmanager.domain.dto.ComplejosDTO;
import com.services.api.ffmanager.domain.dto.DatosInstitucionDeportivaDTO;
import com.services.api.ffmanager.domain.dto.SectoresDTO;
import com.services.api.ffmanager.domain.dto.TiposAreasDTO;
import com.services.api.ffmanager.domain.entities.Areas;
import com.services.api.ffmanager.domain.entities.Complejos;
import com.services.api.ffmanager.domain.entities.DatosInstitucionDeportiva;
import com.services.api.ffmanager.domain.entities.Sectores;
import com.services.api.ffmanager.domain.entities.TiposAreas;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@RestController
@Slf4j
@RequestMapping(value = "/api-services", produces = MediaType.APPLICATION_JSON_VALUE)
public class FFManagerController {

	@Autowired
	private final ModelMapper mapper;
	@Autowired
	private InstitucionalServices institucionalServices;

	@Autowired
	public FFManagerController(ModelMapper mapper, InstitucionalServices institucionalServices) {
		this.institucionalServices = institucionalServices;
		this.mapper = mapper;
	}

	/**
	 * Rest para Datos Institucion Deportiva
	 */

	@GetMapping(value = "/instituciones-deportivas/get-all")
	public ResponseEntity<Object> getAllInstitucionesDeportivas() {

		Collection<DatosInstitucionDeportiva> datos = institucionalServices.getAllDatosInstitucionDeportiva();
		List<DatosInstitucionDeportivaDTO> listaDatosDTO = new ArrayList<DatosInstitucionDeportivaDTO>();
		for (DatosInstitucionDeportiva datosInstitucionDeportiva : datos) {
			DatosInstitucionDeportivaDTO datosDTO = mapper.map(datosInstitucionDeportiva,
					DatosInstitucionDeportivaDTO.class);
			listaDatosDTO.add(datosDTO);
		}
		return new ResponseEntity<>(listaDatosDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/instituciones-deportivas/get-one/{id}")
	public ResponseEntity<Object> getOneInstitucionesDeportivas(@PathVariable("id") String id) {
		var val = institucionalServices.getOneDatosInstitucionDeportiva(id);
		return new ResponseEntity<>(val.isPresent() ? mapper.map(val.get(), DatosInstitucionDeportivaDTO.class) : null,
				val.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@PostMapping(value = "/instituciones-deportivas/create")
	public ResponseEntity<Object> createDatosInstitucionDeportiva(@RequestBody DatosInstitucionDeportivaDTO dto) {
		institucionalServices.createDatosInstitucionDeportiva(mapper.map(dto, DatosInstitucionDeportiva.class));
		return new ResponseEntity<>("Institucion Deportiva is updated successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/instituciones-deportivas/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateDatosInstitucionDeportiva(@PathVariable("id") String id,
			@RequestBody DatosInstitucionDeportivaDTO dto) {

		institucionalServices.updateDatosInstitucionDeportiva(mapper.map(dto, DatosInstitucionDeportiva.class));
		return new ResponseEntity<>("Institucion Deportiva is updated successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/instituciones-deportivas/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteDatosInstitucionDeportiva(@PathVariable("id") String id) {
		var val = institucionalServices.getOneDatosInstitucionDeportiva(id);
		if (val.isPresent()) {
			institucionalServices.deleteDatosInstitucionDeportiva(val.get());
			return new ResponseEntity<>("Datos Institucion Deportiva is deleted successsfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Datos Institucion Deportiva is not deleted", HttpStatus.NOT_FOUND);
		}

	}

	/**
	 * REST para Complejos Deportivos
	 */

	@RequestMapping(value = "/complejos/get-all", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllComplejos() {
		Collection<Complejos> datos = institucionalServices.getAllComplejos();
		List<ComplejosDTO> listaDatosDTO = new ArrayList<ComplejosDTO>();
		for (Complejos complejo : datos) {
			ComplejosDTO datosDTO = mapper.map(complejo, ComplejosDTO.class);

			var val = institucionalServices.getOneDatosInstitucionDeportiva(
					"" + complejo.getDatosInstitucionDeportiva().getIdDatosInstitucionDeportiva());
			DatosInstitucionDeportivaDTO diDTO = val.isPresent()
					? mapper.map(val.get(), DatosInstitucionDeportivaDTO.class)
					: null;
			datosDTO.setDatosInstitucionDeportivaDTO(diDTO);

			listaDatosDTO.add(datosDTO);
		}
		return new ResponseEntity<>(listaDatosDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/complejos/get-one/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getOneComplejps(@PathVariable("id") String id) {
		var val = institucionalServices.getOneComplejos(id);
		if (val.isPresent()) {
			ComplejosDTO cDTO = mapper.map(val.get(), ComplejosDTO.class);

			var val2 = institucionalServices.getOneDatosInstitucionDeportiva(
					"" + val.get().getDatosInstitucionDeportiva().getIdDatosInstitucionDeportiva());
			DatosInstitucionDeportivaDTO diDTO = val2.isPresent()
					? mapper.map(val2.get(), DatosInstitucionDeportivaDTO.class)
					: null;
			cDTO.setDatosInstitucionDeportivaDTO(diDTO);
			return new ResponseEntity<>(cDTO, HttpStatus.OK);

		}

		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/complejos/create", method = RequestMethod.POST)
	public ResponseEntity<Object> createComplejos(@RequestBody ComplejosDTO dto) {

		institucionalServices.createComplejos(mapper.map(dto, Complejos.class));
		return new ResponseEntity<>("Complejo is updated successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/complejos/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateComplejos(@PathVariable("id") String id, @RequestBody ComplejosDTO dto) {

		institucionalServices.updateComplejos(mapper.map(dto, Complejos.class));
		return new ResponseEntity<>("Complejo is updated successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/complejos/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteComplejos(@PathVariable("id") String id) {
		var val = institucionalServices.getOneComplejos(id);
		if (val.isPresent()) {
			institucionalServices.deleteComplejos(val.get());
			return new ResponseEntity<>("Complejo is deleted successsfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Complejo is not deleted", HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * REST para Areas Deportivas
	 */

	@RequestMapping(value = "/areas/get-all", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllAreas() {
		
		Collection<Areas> datos = institucionalServices.getAllAreas();
		List<AreasDTO> listaDatosDTO = new ArrayList<AreasDTO>();
		for (Areas area : datos) {
			AreasDTO datosDTO = mapper.map(area, AreasDTO.class);

			var val = institucionalServices.getOneComplejos("" + area.getComplejos().getIdComplejo());
			ComplejosDTO diDTO = val.isPresent() ? mapper.map(val.get(), ComplejosDTO.class) : null;
			datosDTO.setComplejosDTO(diDTO);

			listaDatosDTO.add(datosDTO);
		}
		return new ResponseEntity<>(listaDatosDTO, HttpStatus.OK);

	}

	@RequestMapping(value = "/areas/get-one/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getOneAreas(@PathVariable("id") String id) {
		
		var val = institucionalServices.getOneAreas(id);
		if (val.isPresent()) {
			AreasDTO aDTO = mapper.map(val.get(), AreasDTO.class);

			var val2 = institucionalServices.getOneComplejos(
					"" + val.get().getComplejos().getIdComplejo());
			ComplejosDTO cDTO = val2.isPresent()
					? mapper.map(val2.get(), ComplejosDTO.class)
					: null;
			aDTO.setComplejosDTO(cDTO);
			
			return new ResponseEntity<>(aDTO, HttpStatus.OK);

		}

		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/areas/create", method = RequestMethod.POST)
	public ResponseEntity<Object> createAreas(@RequestBody AreasDTO dto) {

		institucionalServices.createAreas(mapper.map(dto, Areas.class));
		return new ResponseEntity<>("Area is updated successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/areas/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateAreas(@PathVariable("id") String id, @RequestBody AreasDTO dto) {

		institucionalServices.updateAreas(mapper.map(dto, Areas.class));
		return new ResponseEntity<>("Area is updated successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/areas/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteAreas(@PathVariable("id") String id) {

		var val = institucionalServices.getOneAreas(id);
		if (val.isPresent()) {
			institucionalServices.deleteAreas(val.get());
			return new ResponseEntity<>("Area is deleted successsfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Area is not deleted", HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * REST para Tipos de Areas Deportivas
	 */

	@RequestMapping(value = "/tipos-areas/get-all", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllTiposAreas() {
		Collection<TiposAreas> datos = institucionalServices.getAllTiposAreas();
		List<TiposAreasDTO> listaDatosDTO = new ArrayList<TiposAreasDTO>();
		for (TiposAreas tipoArea : datos) {
			TiposAreasDTO datosDTO = mapper.map(tipoArea, TiposAreasDTO.class);
			listaDatosDTO.add(datosDTO);
		}
		return new ResponseEntity<>(listaDatosDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/tipos-areas/get-one/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getOneTiposAreas(@PathVariable("id") String id) {
		var val = institucionalServices.getOneTiposAreas(id);
		return new ResponseEntity<>(val.isPresent() ? mapper.map(val.get(), TiposAreasDTO.class) : null,
				val.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/tipos-areas/create", method = RequestMethod.POST)
	public ResponseEntity<Object> createTiposAreas(@RequestBody TiposAreasDTO dto) {

		institucionalServices.createTiposAreas(mapper.map(dto, TiposAreas.class));
		return new ResponseEntity<>("Tipo Area is updated successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/tipos-areas/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateTiposAreas(@PathVariable("id") String id, @RequestBody TiposAreasDTO dto) {

		institucionalServices.updateTiposAreas(mapper.map(dto, TiposAreas.class));
		return new ResponseEntity<>("Tipo Area is updated successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/tipos-areas/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteTiposAreas(@PathVariable("id") String id) {

		var val = institucionalServices.getOneTiposAreas(id);
		if (val.isPresent()) {
			institucionalServices.deleteTiposAreas(val.get());
			return new ResponseEntity<>("Tipo Area is deleted successsfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Tipo Area is not deleted", HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * REST para Sectores Deportivos
	 */

	@RequestMapping(value = "/sectores/get-all", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllSectores() {
		
		
		Collection<Sectores> datos = institucionalServices.getAllSectores();
		List<SectoresDTO> listaDatosDTO = new ArrayList<SectoresDTO>();
		for (Sectores sector : datos) {
			SectoresDTO datosDTO = mapper.map(sector, SectoresDTO.class);
			
			var val = institucionalServices.getOneAreas("" + sector.getAreas().getIdArea());
			AreasDTO diDTO = val.isPresent() ? mapper.map(val.get(), AreasDTO.class) : null;
			datosDTO.setAreasDTO(diDTO);
			
			listaDatosDTO.add(datosDTO);
		}
		return new ResponseEntity<>(listaDatosDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/sectores/get-one/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getOneSectores(@PathVariable("id") String id) {

		
		var val = institucionalServices.getOneSectores(id);
		if (val.isPresent()) {
			SectoresDTO sDTO = mapper.map(val.get(), SectoresDTO.class);

			var val2 = institucionalServices.getOneAreas(
					"" + val.get().getAreas().getIdArea());
			AreasDTO aDTO = val2.isPresent()
					? mapper.map(val2.get(), AreasDTO.class)
					: null;
			sDTO.setAreasDTO(aDTO);
			return new ResponseEntity<>(sDTO, HttpStatus.OK);

		}

		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		
		
	}

	@RequestMapping(value = "/sectores/create", method = RequestMethod.POST)
	public ResponseEntity<Object> createSectores(@RequestBody SectoresDTO dto) {

		institucionalServices.createSectores(mapper.map(dto, Sectores.class));
		return new ResponseEntity<>("Sector is updated successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/sectores/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateSectores(@PathVariable("id") String id, @RequestBody SectoresDTO dto) {

		institucionalServices.updateSectores(mapper.map(dto, Sectores.class));
		return new ResponseEntity<>("Sector is updated successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/sectores/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteSectores(@PathVariable("id") String id) {

		var val = institucionalServices.getOneSectores(id);
		if (val.isPresent()) {
			institucionalServices.deleteSectores(val.get());
			return new ResponseEntity<>("Sector is deleted successsfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Sector is not deleted", HttpStatus.NOT_FOUND);
		}
	}

}
