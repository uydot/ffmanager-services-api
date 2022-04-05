package com.services.api.ffmanager.business;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.services.api.ffmanager.domain.entities.Areas;
import com.services.api.ffmanager.domain.entities.Complejos;
import com.services.api.ffmanager.domain.entities.DatosInstitucionDeportiva;
import com.services.api.ffmanager.domain.entities.Sectores;
import com.services.api.ffmanager.domain.entities.TiposAreas;
import com.services.api.ffmanager.domain.repository.AreasRepository;
import com.services.api.ffmanager.domain.repository.ComplejosRepository;
import com.services.api.ffmanager.domain.repository.DatosInstitucionDeportivaRepository;
import com.services.api.ffmanager.domain.repository.SectoresRepository;
import com.services.api.ffmanager.domain.repository.TiposAreasRepository;

public class InstitucionalServicesImpl implements InstitucionalServices {

	protected final DatosInstitucionDeportivaRepository datosInstitucionDeportivaRepository;
	protected final ComplejosRepository complejosRepository;
	protected final AreasRepository areasRepository;
	protected final TiposAreasRepository tiposAreasRepository;
	protected final SectoresRepository sectoresRepository;
	
	
	@Autowired
	public InstitucionalServicesImpl(TiposAreasRepository tiposAreasRepository, DatosInstitucionDeportivaRepository datosInstitucionDeportivaRepository,
			AreasRepository areasRepository, ComplejosRepository complejosRepository, SectoresRepository sectoresRepository) {
		this.datosInstitucionDeportivaRepository = datosInstitucionDeportivaRepository;
		this.complejosRepository = complejosRepository;
		this.areasRepository = areasRepository;
		this.tiposAreasRepository = tiposAreasRepository;
		this.sectoresRepository = sectoresRepository;
		
	}
	
	/**
	 * Servicios relativos al manejo de Datos de la Institucion Deportiva
	 */
	@Override
	public void createDatosInstitucionDeportiva(DatosInstitucionDeportiva o) {
		datosInstitucionDeportivaRepository.save(o);

	}

	@Override
	public void updateDatosInstitucionDeportiva(DatosInstitucionDeportiva o) {
		datosInstitucionDeportivaRepository.save(o);

	}

	@Override
	public void deleteDatosInstitucionDeportiva(DatosInstitucionDeportiva o) {
		datosInstitucionDeportivaRepository.delete(o);

	}
	
	@Override
	public Optional<DatosInstitucionDeportiva> getOneDatosInstitucionDeportiva(String id) {
		return datosInstitucionDeportivaRepository.findById(Long.parseLong(id));
		
	}

	@Override
	public Collection<DatosInstitucionDeportiva> getAllDatosInstitucionDeportiva() {
		return datosInstitucionDeportivaRepository.findAll();
	}
	
	/**
	 * Servicios relativos al manejo de Complejos Deportivos
	 */
	@Override
	public void createComplejos(Complejos o) {
		complejosRepository.save(o);

	}

	@Override
	public void updateComplejos(Complejos o) {
		complejosRepository.save(o);

	}

	@Override
	public void deleteComplejos(Complejos o) {
		complejosRepository.delete(o);

	}

	@Override
	public Collection<Complejos> getComplejos() {
		return complejosRepository.findAll();
	
	}

	/**
	 * Servicios relativos al manejo de las Areas de los Complejos Deportivos
	 */
	@Override
	public void createAreas(Areas o) {
		areasRepository.save(o);

	}

	@Override
	public void updateAreas(Areas o) {
		areasRepository.save(o);

	}

	@Override
	public void deleteAreas(Areas o) {
		areasRepository.delete(o);

	}

	@Override
	public Collection<Areas> getAreas() {
		return areasRepository.findAll();
	}

	/**
	 * Servicios relativos al manejo de los Tipos de Areas
	 */
	@Override
	public void createTiposAreas(TiposAreas o) {
		tiposAreasRepository.save(o);

	}

	@Override
	public void updateTiposAreas(TiposAreas o) {
		tiposAreasRepository.save(o);

	}

	@Override
	public void deleteTiposAreas(TiposAreas o) {
		tiposAreasRepository.delete(o);

	}

	@Override
	public Collection<TiposAreas> getTiposAreas() {
		return tiposAreasRepository.findAll();
	}

	/**
	 * Servicios relativos al manejo de los Sectores de las Areas
	 */
	@Override
	public void createSectores(Sectores o) {
		sectoresRepository.save(o);

	}

	@Override
	public void updateSectores(Sectores o) {
		sectoresRepository.save(o);

	}

	@Override
	public void deleteSectores(Sectores o) {
		sectoresRepository.delete(o);

	}

	@Override
	public Collection<Sectores> getSectores() {
		return sectoresRepository.findAll();
	}

}
