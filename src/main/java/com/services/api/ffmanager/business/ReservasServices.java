package com.services.api.ffmanager.business;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.services.api.ffmanager.domain.dto.StockMaterialDTO;
import com.services.api.ffmanager.domain.entities.ActividadesDeReserva;
import com.services.api.ffmanager.domain.entities.Areas;
import com.services.api.ffmanager.domain.entities.Estados;
import com.services.api.ffmanager.domain.entities.MaterialesDeReserva;
import com.services.api.ffmanager.domain.entities.ReservaDeSector;
import com.services.api.ffmanager.domain.entities.Reservas;
import com.services.api.ffmanager.domain.entities.Sectores;
import com.services.api.ffmanager.domain.entities.Usuarios;

public interface ReservasServices {

	public static String _libres = "sectores_libres";
	public static String _ocupados = "sectores_ocupados";
	public static String _colorDisponible = "#008000";
	public static String _colorOcupado = "";
	public static String _colorInhabilitado = "";
	
	public abstract HashMap<String, List<Sectores>> getAllSectoresDisponibles(Integer idArea, LocalDateTime fechaDesde, LocalDateTime fechaHasta);
	
	public abstract void seleccionarSectores(Collection<Reservas> reservas);
	
	public abstract void createReservaDeSector(ReservaDeSector reserva);
	
	public abstract Reservas  createReserva(Reservas reserva);
	
	public abstract void createMaterialesDeReserva(MaterialesDeReserva materiales);
	
	public abstract void createActividadesDeReserva(ActividadesDeReserva materiales);
	
	public abstract void setEstadoSector(Integer sector, Integer estado);
	
	public abstract HashMap<String, Areas> getAllAreasDisponibles(Integer idComplejo, LocalDateTime fechaDesde, LocalDateTime fechaHasta);
	
	public abstract HashMap<String, String> getUsoDeHorasDeAreaSimple(Integer idArea, LocalDateTime fecha, String[] horas);
	
	public abstract  List<StockMaterialDTO> getStockMaterialesPorReserva(LocalDateTime fechaDesde,LocalDateTime fechaHasta);
	
	public abstract Estados getEstadoReservado();
	
	public abstract Set<Usuarios> geAlltUsuariosConReserva(LocalDateTime fechaDesde, LocalDateTime fechaHasta);
	
	public abstract boolean deleteReserva(Reservas reserva);
	
	public abstract Optional<Reservas> getReserva(Integer idReserva);
}
