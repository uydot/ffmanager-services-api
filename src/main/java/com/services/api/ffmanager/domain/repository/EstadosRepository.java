package com.services.api.ffmanager.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.services.api.ffmanager.domain.entities.Estados;

public interface EstadosRepository extends JpaRepository<Estados, Integer> {

	@Query(value = "SELECT * FROM estados WHERE indica_reserva = 1" , nativeQuery=true)
	public Estados getEstadoReservado();
}
