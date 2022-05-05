package com.services.api.ffmanager.business;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.services.api.ffmanager.domain.entities.ActividadesDeReserva;
import com.services.api.ffmanager.domain.entities.EstadosDeSectores;
import com.services.api.ffmanager.domain.entities.MaterialesDeReserva;
import com.services.api.ffmanager.domain.entities.ReservaDeSector;
import com.services.api.ffmanager.domain.entities.Reservas;
import com.services.api.ffmanager.domain.entities.Sectores;
import com.services.api.ffmanager.domain.repository.ActividadesDeReservaRepository;
import com.services.api.ffmanager.domain.repository.MaterialesDeReservaRepository;
import com.services.api.ffmanager.domain.repository.ReservaDeSectorRepository;
import com.services.api.ffmanager.domain.repository.ReservasRepository;
import com.services.api.ffmanager.domain.repository.SectoresRepository;
import com.services.api.ffmanager.utils.Utilities;

@Service
public class ReservasServicesImpl implements ReservasServices {

	SectoresRepository sectoresRepository;
	ReservasRepository reservasRepository;
	ReservaDeSectorRepository reservaDeSectorRepository;
	MaterialesDeReservaRepository materialesDeReservaRepository;
	ActividadesDeReservaRepository actividadesDeReservaRepository;

	@Autowired
	public ReservasServicesImpl(SectoresRepository sectoresRepository, ReservasRepository reservasRepository,
			ReservaDeSectorRepository reservaDeSectorRepository,
			MaterialesDeReservaRepository materialesDeReservaRepository,
			ActividadesDeReservaRepository actividadesDeReservaRepository) {
		this.reservasRepository = reservasRepository;
		this.sectoresRepository = sectoresRepository;
		this.reservaDeSectorRepository = reservaDeSectorRepository;
		this.materialesDeReservaRepository = materialesDeReservaRepository;
		this.actividadesDeReservaRepository = actividadesDeReservaRepository;
	}

	@Override
	public HashMap<String, List<Sectores>> getAllSectoresDisponibles(Integer idArea, LocalDateTime fechaDesde, LocalDateTime fechaHasta) {
		Collection<Sectores> listResult = (Collection<Sectores>) reservasRepository.getAllSectoresDisponibles(idArea);
		Collection<Sectores> sectores = new ArrayList<Sectores>();
		for (Sectores o : listResult) {
			Set<EstadosDeSectores> ultimoEstadoEnLista = new LinkedHashSet<EstadosDeSectores>();
			EstadosDeSectores ultimoEstado = getUltimoEstado(o.getEstadosDeSectores());
			ultimoEstadoEnLista.add(ultimoEstado);
			o.setEstadosDeSectores(ultimoEstadoEnLista);
			sectores.add(o);		
		}
			
		return getSectoresReservados(sectores, fechaDesde, fechaHasta);
	}

	//Devuelve el estado ultimo del sector
	private EstadosDeSectores getUltimoEstado(Collection<EstadosDeSectores> estados) {
		if(estados != null && !estados.isEmpty()) {
			EstadosDeSectores result = estados.iterator().next();//Me quedo con el primer estado
			for (EstadosDeSectores estadosDeSectores : estados) {	
				if(Utilities.compareLocalDateTime(estadosDeSectores.getFechaAsignado() , result.getFechaAsignado()) > 0 ) {//Comparo las fechas, y me quedo con el mas nuevo
					result = estadosDeSectores;
				}
			}
			return result;
		}
		return null;		
	}
	
	
	private HashMap<String, List<Sectores>>  getSectoresReservados(Collection<Sectores> sectores, LocalDateTime fechaDesde, LocalDateTime fechaHasta){
		HashMap<String, List<Sectores>> hashResultado = new HashMap<String, List<Sectores>>();
		List<Sectores> sectoresOcupados = new ArrayList<Sectores>();
		List<Sectores> sectoresLibres = new ArrayList<Sectores>();
		for (Sectores s : sectores) {
			Integer id = reservasRepository.isOcupado(s.getIdSector(), fechaDesde, fechaHasta);
			if(id != null) {//Si devuelve el id del sector, entonces en ese rango de horas el sector esta ocupado
				sectoresOcupados.add(s);
			}else {
				sectoresLibres.add(s);
			}
		}
		hashResultado.put(_libres, sectoresLibres);
		hashResultado.put(_ocupados, sectoresOcupados);
		
		return hashResultado;
	}
	
	
	@Override
	public void seleccionarSectores(Collection<Reservas> reservas) {
		// TODO Auto-generated method stub
	}

	@Override
	public void createReservaDeSector(ReservaDeSector reserva) {
		reservaDeSectorRepository.save(reserva);
	}

	@Override
	public Reservas createReserva(Reservas reserva) {
		return reservasRepository.save(reserva);
	}

	@Override
	public void createMaterialesDeReserva(MaterialesDeReserva materiales) {
		materialesDeReservaRepository.save(materiales);
	}

	@Override
	public void createActividadesDeReserva(ActividadesDeReserva actividades) {
		actividadesDeReservaRepository.save(actividades);
	}

}
