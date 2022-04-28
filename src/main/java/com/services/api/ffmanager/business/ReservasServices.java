package com.services.api.ffmanager.business;

import java.util.Collection;
import java.util.Date;

import com.services.api.ffmanager.domain.entities.Reservas;
import com.services.api.ffmanager.domain.entities.Sectores;

public interface ReservasServices {

	public abstract Collection<Sectores> sectoresDisponibles(java.time.Clock horaDesde, java.time.Clock horaHasta, Date fechaDesde, Date fechaHasta	);
	public abstract void seleccionarSectores(Collection<Reservas> reservas);
	
}
