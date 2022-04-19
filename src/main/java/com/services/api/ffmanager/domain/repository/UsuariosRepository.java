package com.services.api.ffmanager.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.services.api.ffmanager.domain.entities.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {

	@Query(value = "SELECT * FROM usuarios WHERE usuario like :usuario" , nativeQuery=true)
	public Usuarios findUsuario(@Param("usuario") String usuario);
}
