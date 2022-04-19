package com.services.api.ffmanager.business;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.services.api.ffmanager.domain.entities.Cargos;
import com.services.api.ffmanager.domain.entities.ItemsDePerfiles;
import com.services.api.ffmanager.domain.entities.ItemsMenu;
import com.services.api.ffmanager.domain.entities.Perfiles;
import com.services.api.ffmanager.domain.entities.Usuarios;

public interface PerfilesServices {

	public abstract void createUsuarios(Usuarios o);
	public abstract void updateUsuarios(Usuarios o);
	public abstract void deleteUsuarios(Usuarios o);
	public abstract Optional<Usuarios> getOneUsuarios(String id);
	public Collection<Usuarios> getAllUsuarios();
	
	public abstract void createPerfiles(Perfiles o);
	public abstract void updatePerfiles(Perfiles o);
	public abstract void deletePerfiles(Perfiles o);
	public abstract Optional<Perfiles> getOnePerfiles(String id);
	public Collection<Perfiles> getAllPerfiles();
	
	public abstract void createCargos(Cargos o);
	public abstract void updateCargos(Cargos o);
	public abstract void deleteCargos(Cargos o);
	public abstract Optional<Cargos> getOneCargos(String id);
	public Collection<Cargos> getAllCargos();
	
	public abstract void createItemsDePerfiles(ItemsDePerfiles o);
	public abstract void updateItemsDePerfiles(ItemsDePerfiles o);
	public abstract void deleteItemsDePerfiles(ItemsDePerfiles o);
	public abstract Optional<ItemsDePerfiles> getOneItemsDePerfiles(String id);
	public Collection<ItemsDePerfiles> getAllItemsDePerfiles();
	
	public abstract void createItemsMenu(ItemsMenu o);
	public abstract void updateItemsMenu(ItemsMenu o);
	public abstract void deleteItemsMenu(ItemsMenu o);
	public abstract Optional<ItemsMenu> getOneItemsMenu(String id);
	public Collection<ItemsMenu> getAllItemsMenu();
	
	public Collection<ItemsDePerfiles> findByIdPerfil(@Param("idPerfil") String idPerfil);
	
	public Usuarios findUsuario(@Param("usuario") String usuario);
	
	
}
