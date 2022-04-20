package com.services.api.ffmanager.business;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.services.api.ffmanager.domain.entities.Actividades;
import com.services.api.ffmanager.domain.entities.Estados;
import com.services.api.ffmanager.domain.entities.Materiales;
import com.services.api.ffmanager.domain.repository.ActividadesRepository;
import com.services.api.ffmanager.domain.repository.EstadosRepository;
import com.services.api.ffmanager.domain.repository.MaterialesRepository;

@Service
public class GeneralServicesImpl implements GeneralServices{

	protected final EstadosRepository estadosRepository;
	protected final ActividadesRepository actividadesRepository;
	protected final MaterialesRepository materialesRepository;
	
	@Autowired
	public GeneralServicesImpl(EstadosRepository estadosRepository, 
			ActividadesRepository actividadesRepository, MaterialesRepository materialesRepository) {
		this.actividadesRepository = actividadesRepository;
		this.estadosRepository = estadosRepository;
		this.materialesRepository = materialesRepository;
	}
	
	@Override
	public void createEstados(Estados o) {
		estadosRepository.save(o);
	}

	@Override
	public void updateEstados(Estados o) {
		estadosRepository.save(o);
		
	}

	@Override
	public void deleteEstados(Estados o) {
		estadosRepository.delete(o);
		
	}

	@Override
	public Optional<Estados> getOneEstado(String id) {
		return estadosRepository.findById(Integer.parseInt(id));
	}

	@Override
	public Collection<Estados> getAllEstados() {
		return estadosRepository.findAll();
	}

	@Override
	public void createActividades(Actividades o) {
		actividadesRepository.save(o);
		
	}

	@Override
	public void updateActividades(Actividades o) {
		actividadesRepository.save(o);
		
	}

	@Override
	public void deleteActividades(Actividades o) {
		actividadesRepository.delete(o);
		
	}

	@Override
	public Optional<Actividades> getOneActividades(String id) {
		return actividadesRepository.findById(Integer.parseInt(id));
	}

	@Override
	public Collection<Actividades> getAllActividades() {
		return actividadesRepository.findAll();
	}

	@Override
	public void createMateriales(Materiales o) {
		materialesRepository.save(o);
		
	}

	@Override
	public void updateMateriales(Materiales o) {
		materialesRepository.save(o);
		
	}

	@Override
	public void deleteMateriales(Materiales o) {
		materialesRepository.delete(o);
		
	}

	@Override
	public Optional<Materiales> getOneMateriales(String id) {
		return materialesRepository.findById(Integer.parseInt(id));
	}

	@Override
	public Collection<Materiales> getAllMateriales() {
		return materialesRepository.findAll();
	}

}
