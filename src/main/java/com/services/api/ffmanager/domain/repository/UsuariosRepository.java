package com.services.api.ffmanager.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.services.api.ffmanager.domain.entities.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

}
