package com.services.api.ffmanager.domain.repository;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.services.api.ffmanager.domain.dto.SectoresDisponiblesDTO;
import com.services.api.ffmanager.domain.entities.Reservas;

public interface ReservasRepository extends JpaRepository<Reservas, Integer> {

	@Query(value = "select * FROM ffmanager.sectores s WHERE s.id_sector NOT IN (select * FROM ffmanager.sectores s , ffmanager.reserva_de_sector rds , ffmanager.reservas r WHERE s.id_sector = rds.fk_id_sector AND rds.fk_id_reserva = r.id_reserva AND r.fecha_desde >= :fechaDesde AND r.fecha_hasta <= :fechaHasta ) " , nativeQuery=true)
	public Collection<SectoresDisponiblesDTO> getAllSectoresDisponibles(@Param("fechaDesde") Date fechaDesde, @Param("fechaHasta") Date fechaHasta);
}
