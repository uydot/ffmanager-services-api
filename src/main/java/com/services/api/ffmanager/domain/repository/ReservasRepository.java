package com.services.api.ffmanager.domain.repository;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.services.api.ffmanager.domain.entities.Reservas;
import com.services.api.ffmanager.domain.entities.Sectores;

public interface ReservasRepository extends JpaRepository<Reservas, Integer> {

	@Query(value = "select s.id_sector, s.nombre, s.observaciones, s.tamaño, s.fk_id_area, s.es_sector_golero, s.numero_sector FROM sectores s WHERE s.id_sector NOT IN (select s.id_sector FROM sectores s , reserva_de_sector rds , "
			+ "reservas r WHERE s.id_sector = rds.fk_id_sector AND rds.fk_id_reserva = r.id_reserva "
			+ "AND r.fecha_desde >= :fechaDesde AND r.fecha_hasta <= :fechaHasta ) " , nativeQuery=true)
	public Collection<Object[]> getAllSectoresDisponibles(@Param("fechaDesde") Date fechaDesde, @Param("fechaHasta") Date fechaHasta);
}
