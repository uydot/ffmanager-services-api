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
		usuariosRepository.save(o);
		
	}

	@Override
	public void updateUsuarios(Usuarios o) {
		usuariosRepository.save(o);
		
	}

	@Override
	public void deleteUsuarios(Usuarios o) {
		usuariosRepository.delete(o);
		
	}

	@Override
	public Optional<Usuarios> getOneUsuarios(String id) {
		return usuariosRepository.findById(Integer.parseInt(id));
	}

	@Override
	public Collection<Usuarios> getAllUsuarios() {
		return usuariosRepository.findAll();
	}

	@Override
	public void createPerfiles(Perfiles o) {
		perfilesRepository.save(o);
		
	}

	@Override
	public void updatePerfiles(Perfiles o) {
		perfilesRepository.save(o);
		
	}

	@Override
	public void deletePerfiles(Perfiles o) {
		perfilesRepository.delete(o);
		
	}

	@Override
	public Optional<Perfiles> getOnePerfiles(String id) {
		return perfilesRepository.findById(Integer.parseInt(id));
	}

	@Override
	public Collection<Perfiles> getAllPerfiles() {
		return perfilesRepository.findAll();
	}

	@Override
	public void createCargos(Cargos o) {
		cargosRepository.save(o);
		
	}

	@Override
	public void updateCargos(Cargos o) {
		cargosRepository.save(o);
		
	}

	@Override
	public void deleteCargos(Cargos o) {
		cargosRepository.delete(o);
		
	}

	@Override
	public Optional<Cargos> getOneCargos(String id) {
		return cargosRepository.findById(Integer.parseInt(id));
	}

	@Override
	public Collection<Cargos> getAllCargos() {
		return cargosRepository.findAll();
	}

	@Override
	public void createItemsDePerfiles(ItemsDePerfiles o) {
		itemsDePerfilesRepository.save(o);
		
	}

	@Override
	public void updateItemsDePerfiles(ItemsDePerfiles o) {
		itemsDePerfilesRepository.save(o);
		
	}

	@Override
	public void deleteItemsDePerfiles(ItemsDePerfiles o) {
		itemsDePerfilesRepository.delete(o);
		
	}

	@Override
	public Optional<ItemsDePerfiles> getOneItemsDePerfiles(String id) {
		return itemsDePerfilesRepository.findById(Integer.parseInt(id));
	}

	@Override
	public Collection<ItemsDePerfiles> getAllItemsDePerfiles() {
		return itemsDePerfilesRepository.findAll();
	}

	@Override
	public void createItemsMenu(ItemsMenu o) {
		itemsMenuRepository.save(o);
		
	}

	@Override
	public void updateItemsMenu(ItemsMenu o) {
		itemsMenuRepository.save(o);
		
	}

	@Override
	public void deleteItemsMenu(ItemsMenu o) {
		itemsMenuRepository.delete(o);
		
	}

	@Override
	public Optional<ItemsMenu> getOneItemsMenu(String id) {
		return itemsMenuRepository.findById(Integer.parseInt(id));
	}

	@Override
	public Collection<ItemsMenu> getAllItemsMenu() {
		return itemsMenuRepository.findAll();
	}


	@Override
	public Collection<ItemsDePerfiles> findByIdPerfil(String idPerfil) {
		return itemsDePerfilesRepository.findByIdPerfil(Integer.parseInt(idPerfil));
	}


	@Override
	public Usuarios findUsuario(String usuario) {
		return usuariosRepository.findUsuario(usuario);
	}




}
