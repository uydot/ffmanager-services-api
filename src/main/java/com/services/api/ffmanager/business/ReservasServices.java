package com.services.api.ffmanager.business;

import java.time.LocalDateTime;
import java.util.Collection;

import com.services.api.ffmanager.domain.entities.ActividadesDeReserva;
import com.services.api.ffmanager.domain.entities.MaterialesDeReserva;
import com.services.api.ffmanager.domain.entities.ReservaDeSector;
import com.services.api.ffmanager.domain.entities.Reservas;
import com.services.api.ffmanager.domain.entities.Sectores;

public interface ReservasServices {

	public abstract Collection<Sectores> getAllSectoresDisponibles(Integer idArea, LocalDateTime fechaDesde, LocalDateTime fechaHasta);
	
	public abstract void seleccionarSectores(Collection<Reservas> reservas);
	
	public abstract void createReservaDeSector(ReservaDeSector reserva);
	
	public abstract Reservas  createReserva(Reservas reserva);
	
	public abstract void createMaterialesDeReserva(MaterialesDeReserva materiales);
	
	public abstract void createActividadesDeReserva(ActividadesDeReserva materiales);
	
}
