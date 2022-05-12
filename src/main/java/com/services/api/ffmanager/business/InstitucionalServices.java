package com.services.api.ffmanager.business;

import java.util.Collection;
import java.util.Optional;

import com.services.api.ffmanager.domain.entities.Areas;
import com.services.api.ffmanager.domain.entities.Complejos;
import com.services.api.ffmanager.domain.entities.DatosInstitucionDeportiva;
import com.services.api.ffmanager.domain.entities.Sectores;
import com.services.api.ffmanager.domain.entities.TiposAreas;

public interface InstitucionalServices {
	
	public abstract void createDatosInstitucionDeportiva(DatosInstitucionDeportiva o);
	public abstract void updateDatosInstitucionDeportiva(DatosInstitucionDeportiva o);
	public abstract void deleteDatosInstitucionDeportiva(DatosInstitucionDeportiva o);
	public abstract Optional<DatosInstitucionDeportiva> getOneDatosInstitucionDeportiva(String id);
	public Collection<DatosInstitucionDeportiva> getAllDatosInstitucionDeportiva();
	
	public abstract void createComplejos(Complejos o);
	public abstract void updateComplejos(Complejos o);
	public abstract void deleteComplejos(Complejos o);
	public abstract Optional<Complejos> getOneComplejos(String id);
	public Collection<Complejos> getAllComplejos();
	
	public abstract void createAreas(Areas o);
	public abstract void updateAreas(Areas o);
	public abstract void deleteAreas(Areas o);
	public abstract Optional<Areas> getOneAreas(String id);
	public Collection<Areas> getAllAreas();
	
	public abstract void createTiposAreas(TiposAreas o);
	public abstract void updateTiposAreas(TiposAreas o);
	public abstract void deleteTiposAreas(TiposAreas o);
	public abstract Optional<TiposAreas> getOneTiposAreas(String id);
	public Collection<TiposAreas> getAllTiposAreas();
	
	public abstract void createSectores(Sectores o);
	public abstract void updateSectores(Sectores o);
	public abstract void deleteSectores(Sectores o);
	public abstract Optional<Sectores> getOneSectores(String id);
	public Collection<Sectores> getAllSectores();
	public Collection<Sectores> getAllSectoresByIdArea(int idArea);
	
}
