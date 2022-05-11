package com.services.api.ffmanager.domain.repository;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.services.api.ffmanager.domain.entities.MaterialesDeReserva;
import com.services.api.ffmanager.domain.entities.Reservas;
import com.services.api.ffmanager.domain.entities.Sectores;

public interface ReservasRepository extends JpaRepository<Reservas, Integer> {

	/**
	 * Esta consulta devuelve todos los sectores que no tienen reserva entra las fechas pasadas por parametro y ademas no estan en un estado que no permita utilizarlas
	 * @param fechaDesde
	 * @param fechaHasta
	 * @return
	 */
	//@Query(value = "select s.id_sector, s.nombre, s.observaciones, s.tamaño, s.fk_id_area, s.es_sector_golero, s.numero_sector FROM sectores s, areas a WHERE s.fk_id_area = a.id_area AND a.id_area = :idArea " , nativeQuery=true)
	@Query("select s from sectores s where s.areas.idArea = :idArea")
	public Set<Sectores> getAllSectoresDisponibles(@Param("idArea") Integer idArea);
	
	@Query(value = "select r.id_reserva from ffmanager.reservas r, ffmanager.reserva_de_sector rds, ffmanager.sectores s where r.id_reserva = rds.fk_id_reserva and rds.fk_id_sector = s.id_sector and s.id_sector = :idSector and r.fecha_desde < :fechaHasta and r.fecha_hasta > :fechaDesde", nativeQuery=true)
	public Integer isOcupado(@Param("idSector")Integer idSector, @Param("fechaDesde") LocalDateTime fechaDesde, @Param("fechaHasta") LocalDateTime fechaHasta);
	
	
	@Query( value = "select m.id_material , m.stock , mdr.cantidad from ffmanager.materiales m , ffmanager.materiales_de_reserva mdr , ffmanager.reservas r where r.fecha_desde <= :fechaDesde and r.fecha_hasta >= :fechaHasta and r.id_reserva = mdr.fk_id_reserva and mdr.fk_id_material  = m.id_material", nativeQuery=true)
	public  Collection<Object> getMaterialesDeReserva(@Param("fechaDesde") LocalDateTime fechaDesde, @Param("fechaHasta") LocalDateTime fechaHasta);
}
