package com.services.api.ffmanager.business;

import java.util.Collection;

import com.services.api.ffmanager.domain.entities.Areas;
import com.services.api.ffmanager.domain.entities.Complejos;
import com.services.api.ffmanager.domain.entities.DatosInstitucionDeportiva;
import com.services.api.ffmanager.domain.entities.Sectores;
import com.services.api.ffmanager.domain.entities.TiposAreas;

public interface InstitucionalServices {
	
	public abstract void createDatosInstitucionDeportiva(DatosInstitucionDeportiva o);
	public abstract void updateDatosInstitucionDeportiva(DatosInstitucionDeportiva o);
	public abstract void deleteDatosInstitucionDeportiva(DatosInstitucionDeportiva o);
	public Collection<DatosInstitucionDeportiva> getDatosInstitucionDeportiva();
	
	public abstract void createComplejos(Complejos o);
	public abstract void updateComplejos(Complejos o);
	public abstract void deleteComplejos(Complejos o);
	public Collection<Complejos> getComplejos();
	
	public abstract void createAreas(Areas o);
	public abstract void updateAreas(Areas o);
	public abstract void deleteAreas(Areas o);
	public Collection<Areas> getAreas();
	
	public abstract void createTiposAreas(TiposAreas o);
	public abstract void updateTiposAreas(TiposAreas o);
	public abstract void deleteTiposAreas(TiposAreas o);
	public Collection<TiposAreas> getTiposAreas();
	
	public abstract void createSectores(Sectores o);
	public abstract void updateSectores(Sectores o);
	public abstract void deleteSectores(Sectores o);
	public Collection<Sectores> getSectores();
	
}
