package com.services.api.ffmanager.business;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.services.api.ffmanager.domain.entities.ActividadesDeReserva;
import com.services.api.ffmanager.domain.entities.Estados;
import com.services.api.ffmanager.domain.entities.MaterialesDeReserva;
import com.services.api.ffmanager.domain.entities.ReservaDeSector;
import com.services.api.ffmanager.domain.entities.Reservas;
import com.services.api.ffmanager.domain.entities.Sectores;

public interface ReservasServices {

	public static String _libres = "sectores_libres";
	public static String _ocupados = "sectores_ocupados";
	
	public abstract HashMap<String, List<Sectores>> getAllSectoresDisponibles(Integer idArea, LocalDateTime fechaDesde, LocalDateTime fechaHasta);
	
	public abstract void seleccionarSectores(Collection<Reservas> reservas);
	
	public abstract void createReservaDeSector(ReservaDeSector reserva);
	
	public abstract Reservas  createReserva(Reservas reserva);
	
	public abstract void createMaterialesDeReserva(MaterialesDeReserva materiales);
	
	public abstract void createActividadesDeReserva(ActividadesDeReserva materiales);
	
	public abstract void setEstadoSector(Integer sector, Integer estado);
	
	
	
}
