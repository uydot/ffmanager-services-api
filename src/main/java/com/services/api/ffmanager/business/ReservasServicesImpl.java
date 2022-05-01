package com.services.api.ffmanager.business;

import java.time.Clock;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.services.api.ffmanager.domain.entities.Reservas;
import com.services.api.ffmanager.domain.entities.Sectores;
import com.services.api.ffmanager.domain.repository.SectoresRepository;

@Service
public class ReservasServicesImpl implements ReservasServices{

	@Autowired
	SectoresRepository sectoresRepository;
	
	@Override
	public Collection<Sectores> getSectoresDisponibles(Clock horaDesde, Clock horaHasta, Date fechaDesde,
			Date fechaHasta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void seleccionarSectores(Collection<Reservas> reservas) {
		// TODO Auto-generated method stub
		
	}

}
