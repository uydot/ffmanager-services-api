package com.services.api.ffmanager.domain.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.services.api.ffmanager.domain.entities.ItemsDePerfiles;

public interface ItemsDePerfilesRepository extends JpaRepository<ItemsDePerfiles, Integer> {
	
	@Query(value = "SELECT * FROM items_de_perfiles WHERE fk_id_perfil = :idPerfil" , nativeQuery=true)
	public Collection<ItemsDePerfiles> findByIdPerfil(@Param("idPerfil") int idPerfil);

}
