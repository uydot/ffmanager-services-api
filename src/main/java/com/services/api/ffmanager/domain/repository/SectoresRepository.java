package com.services.api.ffmanager.domain.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.services.api.ffmanager.domain.entities.Sectores;

public interface SectoresRepository extends JpaRepository<Sectores, Integer> {

	@Query(value = "SELECT * FROM sectores WHERE fk_id_area = :idArea" , nativeQuery=true)
	public Collection<Sectores> findAllSectoresByIdArea(@Param("idArea") int idArea);
	
	@Query("select s from sectores s where s.areas.idArea = :idArea")
	public Sectores getOneSectorByIdArea(@Param("idArea") Integer idArea);
}
