package com.services.api.ffmanager.business;

import java.time.Clock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.services.api.ffmanager.domain.entities.ActividadesDeReserva;
import com.services.api.ffmanager.domain.entities.MaterialesDeReserva;
import com.services.api.ffmanager.domain.entities.ReservaDeSector;
import com.services.api.ffmanager.domain.entities.Reservas;
import com.services.api.ffmanager.domain.entities.Sectores;
import com.services.api.ffmanager.domain.repository.ActividadesDeReservaRepository;
import com.services.api.ffmanager.domain.repository.MaterialesDeReservaRepository;
import com.services.api.ffmanager.domain.repository.ReservaDeSectorRepository;
import com.services.api.ffmanager.domain.repository.ReservasRepository;
import com.services.api.ffmanager.domain.repository.SectoresRepository;

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
	public Collection<Sectores> getAllSectoresDisponibles(Date fechaDesde, Date fechaHasta) {
		List<Object[]> listResult = (List<Object[]>) reservasRepository.getAllSectoresDisponibles(fechaDesde,
				fechaHasta);
		List<Sectores> sectores = new ArrayList<Sectores>();
		Sectores s;
		for (Object[] o : listResult) {
			s = new Sectores();
			s.setIdSector((Integer) o[0]);
			s.setNombre((String) o[1]);
			s.setObservaciones((String) o[2]);
			s.setTamano((Double) o[3]);
			s.setEsSectorGolero((Boolean) o[5]);
			s.setNumeroSector((Integer) o[6]);
			sectores.add(s);
		}
		return sectores;
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
