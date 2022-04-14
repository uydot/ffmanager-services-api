package com.services.api.ffmanager.business;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.services.api.ffmanager.domain.entities.Cargos;
import com.services.api.ffmanager.domain.entities.ItemsDePerfiles;
import com.services.api.ffmanager.domain.entities.ItemsMenu;
import com.services.api.ffmanager.domain.entities.Perfiles;
import com.services.api.ffmanager.domain.entities.Usuarios;
import com.services.api.ffmanager.domain.repository.CargosRepository;
import com.services.api.ffmanager.domain.repository.ItemsDePerfilesRepository;
import com.services.api.ffmanager.domain.repository.ItemsMenuRepository;
import com.services.api.ffmanager.domain.repository.PerfilesRepository;
import com.services.api.ffmanager.domain.repository.UsuariosRepository;

@Service
public class PerfilesServicesImpl implements PerfilesServices{
	
	protected final UsuariosRepository usuariosRepository;
	protected final PerfilesRepository perfilesRepository;
	protected final CargosRepository cargosRepository;
	protected final ItemsDePerfilesRepository itemsDePerfilesRepository;
	protected final ItemsMenuRepository itemsMenuRepository;
	
	@Autowired
	public PerfilesServicesImpl(UsuariosRepository usuariosRepository, PerfilesRepository perfilesRepository,
			CargosRepository cargosRepository, ItemsDePerfilesRepository itemsDePerfilesRepository, ItemsMenuRepository itemsMenuRepository) {
		this.usuariosRepository = usuariosRepository;
		this.perfilesRepository = perfilesRepository;
		this.cargosRepository = cargosRepository;
		this.itemsDePerfilesRepository = itemsDePerfilesRepository;
		this.itemsMenuRepository = itemsMenuRepository;
	}
	

	@Override
	public void createUsuarios(Usuarios o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUsuarios(Usuarios o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUsuarios(Usuarios o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Usuarios> getOneUsuarios(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Usuarios> getAllUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createPerfiles(Perfiles o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePerfiles(Perfiles o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePerfiles(Perfiles o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Perfiles> getOnePerfiles(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Perfiles> getAllPerfiles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createCargos(Cargos o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCargos(Cargos o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCargos(Cargos o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Cargos> getOneCargos(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Cargos> getAllCargos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createItemsDePerfiles(ItemsDePerfiles o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateItemsDePerfiles(ItemsDePerfiles o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteItemsDePerfiles(ItemsDePerfiles o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<ItemsDePerfiles> getOneItemsDePerfiles(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<ItemsDePerfiles> getAllItemsDePerfiles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createItemsMenu(ItemsMenu o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateItemsMenu(ItemsMenu o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteItemsMenu(ItemsMenu o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<ItemsMenu> getOneItemsMenu(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<ItemsMenu> getAllItemsMenu() {
		// TODO Auto-generated method stub
		return null;
	}

}
