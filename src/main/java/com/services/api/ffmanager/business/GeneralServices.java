package com.services.api.ffmanager.business;

import java.util.Collection;
import java.util.Optional;

import com.services.api.ffmanager.domain.entities.Actividades;
import com.services.api.ffmanager.domain.entities.Estados;
import com.services.api.ffmanager.domain.entities.EstadosDeSectores;
import com.services.api.ffmanager.domain.entities.Materiales;

public interface GeneralServices {

	public abstract void createEstados(Estados o);
	public abstract void updateEstados(Estados o);
	public abstract void deleteEstados(Estados o);
	public abstract Optional<Estados> getOneEstado(String id);
	public abstract Collection<Estados> getAllEstados();
	
	public abstract void createActividades(Actividades o);
	public abstract void updateActividades(Actividades o);
	public abstract void deleteActividades(Actividades o);
	public abstract Optional<Actividades> getOneActividades(String id);
	public abstract Collection<Actividades> getAllActividades();
	
	public abstract void createMateriales(Materiales o);
	public abstract void updateMateriales(Materiales o);
	public abstract void deleteMateriales(Materiales o);
	public abstract Optional<Materiales> getOneMateriales(String id);
	public abstract Collection<Materiales> getAllMateriales();
	
	
	public abstract void setEstadoDeSector(EstadosDeSectores s);
	
}
