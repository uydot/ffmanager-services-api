package com.services.api.ffmanager.business;

import java.time.Clock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.services.api.ffmanager.domain.entities.Reservas;
import com.services.api.ffmanager.domain.entities.Sectores;
import com.services.api.ffmanager.domain.repository.ReservasRepository;
import com.services.api.ffmanager.domain.repository.SectoresRepository;

@Service
public class ReservasServicesImpl implements ReservasServices{

	
	SectoresRepository sectoresRepository;
	ReservasRepository reservasRepository;
	
	@Autowired
	public ReservasServicesImpl(SectoresRepository sectoresRepository, ReservasRepository reservasRepository){
		this.reservasRepository = reservasRepository;
		this.sectoresRepository = sectoresRepository;
	}
	
	@Override
	public Collection<Sectores> getAllSectoresDisponibles(Date fechaDesde,
			Date fechaHasta) {
		List<Object[]> listResult = (List<Object[]>) reservasRepository.getAllSectoresDisponibles(fechaDesde, fechaHasta);
		List<Sectores> sectores = new ArrayList<Sectores>();
		Sectores s;
		for (Object[] o : listResult) {
			s = new Sectores();
			s.setIdSector((Integer)o[0]);
			s.setNombre((String)o[1]);
			s.setObservaciones((String)o[2]);
			s.setTamano((Double)o[3]);
			s.setEsSectorGolero((Boolean)o[5]);
			s.setNumeroSector((Integer)o[6]);
			sectores.add(s);	
		}
		return sectores;
	}

	@Override
	public void seleccionarSectores(Collection<Reservas> reservas) {
		// TODO Auto-generated method stub
		
	}

}
