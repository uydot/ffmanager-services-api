package com.services.api.ffmanager.domain.repository;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.services.api.ffmanager.domain.entities.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {

	@Query(value = "SELECT * FROM usuarios WHERE usuario like :usuario" , nativeQuery=true)
	public Usuarios findUsuario(@Param("usuario") String usuario);
	
	@Query(value = "SELECT usuarios.* FROM usuarios u, reservas r WHERE u.id_usuario = r.fk_id_usuario AND r.fecha_desde <= :fechaDesde AND r.fecha_hasta >= :fechaHasta ", nativeQuery=true)
	public Set<Usuarios> getAllUsuariosConReservas(@Param("fechaDesde") LocalDateTime fechaDesde, @Param("fechaHasta") LocalDateTime fechaHasta);
	
	
}
