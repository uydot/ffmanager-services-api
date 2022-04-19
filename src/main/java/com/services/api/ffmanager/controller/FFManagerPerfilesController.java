package com.services.api.ffmanager.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.services.api.ffmanager.business.PerfilesServices;
import com.services.api.ffmanager.domain.dto.CargosDTO;
import com.services.api.ffmanager.domain.dto.ItemsDePerfilesDTO;
import com.services.api.ffmanager.domain.dto.ItemsMenuDTO;
import com.services.api.ffmanager.domain.dto.ItemsMenuRootDTO;
import com.services.api.ffmanager.domain.dto.LoginDTO;
import com.services.api.ffmanager.domain.dto.PerfilesConItemsDTO;
import com.services.api.ffmanager.domain.dto.PerfilesDTO;
import com.services.api.ffmanager.domain.dto.UsuariosDTO;
import com.services.api.ffmanager.domain.entities.Cargos;
import com.services.api.ffmanager.domain.entities.ItemsDePerfiles;
import com.services.api.ffmanager.domain.entities.ItemsMenu;
import com.services.api.ffmanager.domain.entities.Perfiles;
import com.services.api.ffmanager.domain.entities.Usuarios;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@RestController("perfiles-services")
@Slf4j
@RequestMapping(value = "/api-services/perfiles-services", produces = MediaType.APPLICATION_JSON_VALUE)
public class FFManagerPerfilesController {

	@Autowired
	private final ModelMapper mapper;
	@Autowired
	private PerfilesServices perfilesServices;

	@Autowired
	public FFManagerPerfilesController(ModelMapper mapper, PerfilesServices perfilesServices) {
		this.perfilesServices = perfilesServices;
		this.mapper = mapper;
	}

	
	//Logim
	
	@PostMapping(value = "/usuarios/login")
	public ResponseEntity<Object> loginUsuarios(@RequestBody LoginDTO dto) {
		
		var usu = perfilesServices.findUsuario(dto.getUsuario());
		if(usu != null && usu.getPassword().equals(dto.getPassword())) {
			List<ItemsMenuDTO> menuCompletoDTO = findAllItemsByPerfil(""+usu.getPerfiles().getIdPerfil());
			dto.setMenuCompletoDTO(menuCompletoDTO);
			dto.setIdUsuario(""+usu.getIdUsuario());
			return new ResponseEntity<>(dto, HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Usuario is not authorized", HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Rest para Usuarios
	 */

	@GetMapping(value = "/usuarios/get-all")
	public ResponseEntity<Object> getAllUsuarios() {

		Collection<Usuarios> datos = perfilesServices.getAllUsuarios();
		List<UsuariosDTO> listaDatosDTO = new ArrayList<UsuariosDTO>();
		for (Usuarios dato : datos) {
			UsuariosDTO datoDTO = mapper.map(dato,
					UsuariosDTO.class);
			listaDatosDTO.add(datoDTO);
		}
		return new ResponseEntity<>(listaDatosDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/usuarios/get-one/{id}")
	public ResponseEntity<Object> getOneUsuarios(@PathVariable("id") String id) {
		var val = perfilesServices.getOneUsuarios(id);
		return new ResponseEntity<>(val.isPresent() ? mapper.map(val.get(), UsuariosDTO.class) : null,
				val.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@PostMapping(value = "/usuarios/create")
	public ResponseEntity<Object> createUsuarios(@RequestBody UsuariosDTO dto) {
		perfilesServices.createUsuarios(mapper.map(dto, Usuarios.class));
		return new ResponseEntity<>("Usuario is created successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/usuarios/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateUsuarios(@PathVariable("id") String id,
			@RequestBody UsuariosDTO dto) {

		perfilesServices.updateUsuarios(mapper.map(dto, Usuarios.class));
		return new ResponseEntity<>("Usuario is updated successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/usuarios/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteUsuarios(@PathVariable("id") String id) {
		var val = perfilesServices.getOneUsuarios(id);
		if (val.isPresent()) {
			perfilesServices.deleteUsuarios(val.get());
			return new ResponseEntity<>("Usuario is deleted successsfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Usuario is not deleted", HttpStatus.NOT_FOUND);
		}

	}

	/**
	 * REST para Perfiles
	 */

	@RequestMapping(value = "/perfiles/get-all", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllPerfiles() {
		Collection<Perfiles> datos = perfilesServices.getAllPerfiles();
		List<PerfilesDTO> listaDatosDTO = new ArrayList<PerfilesDTO>();
		for (Perfiles dato : datos) {
			PerfilesDTO datoDTO = mapper.map(dato, PerfilesDTO.class);

			listaDatosDTO.add(datoDTO);
		}
		return new ResponseEntity<>(listaDatosDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/perfiles/get-one/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getOnePerfiles(@PathVariable("id") String id) {
		var val = perfilesServices.getOnePerfiles(id);
		if (val.isPresent()) {
			PerfilesConItemsDTO cDTO = mapper.map(val.get(), PerfilesConItemsDTO.class);
			
			var itemsDePerfil = perfilesServices.findByIdPerfil(id);
			List<ItemsDePerfilesDTO> itemsDTO = new ArrayList<ItemsDePerfilesDTO>();
			for (Iterator iterator = itemsDePerfil.iterator(); iterator.hasNext();) {
				ItemsDePerfiles itemsDePerfiles = (ItemsDePerfiles) iterator.next();
				itemsDTO.add(mapper.map(itemsDePerfiles, ItemsDePerfilesDTO.class));
			}
			cDTO.setItemsDePerfiles(itemsDTO);
			
			return new ResponseEntity<>(cDTO, HttpStatus.OK);

		}

		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/perfiles/create", method = RequestMethod.POST)
	public ResponseEntity<Object> createPerfiles(@RequestBody PerfilesDTO dto) {

		perfilesServices.createPerfiles(mapper.map(dto, Perfiles.class));
		return new ResponseEntity<>("Perfil is created successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/perfiles/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updatePerfiles(@PathVariable("id") String id, @RequestBody PerfilesDTO dto) {

		perfilesServices.updatePerfiles(mapper.map(dto, Perfiles.class));
		return new ResponseEntity<>("Perfil is updated successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/perfiles/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deletePerfiles(@PathVariable("id") String id) {
		var val = perfilesServices.getOnePerfiles(id);
		if (val.isPresent()) {
			perfilesServices.deletePerfiles(val.get());
			return new ResponseEntity<>("Perfil is deleted successsfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Perfil is not deleted", HttpStatus.NOT_FOUND);
		}
	}
	
	
	/**
	 * REST para ItemsMenu
	 */

	@RequestMapping(value = "/items-menu/get-all-roots", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllItemsMenuRaiz() {
		Collection<ItemsMenu> datos = perfilesServices.getAllItemsMenu();
		List<ItemsMenuDTO> listaDatosDTO = new ArrayList<ItemsMenuDTO>();
		
		for (ItemsMenu dato : datos) {
			if(dato.isEsRaiz()) {
				ItemsMenuDTO datoDTO = mapper.map(dato, ItemsMenuDTO.class);
					
				listaDatosDTO.add(datoDTO);
			}
			
		}
		return new ResponseEntity<>(listaDatosDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/items-menu/get-roots-without-child", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllItemsMenuRaizSinHijos() {
		Collection<ItemsMenu> datos = perfilesServices.getAllItemsMenu();
		List<ItemsMenuRootDTO> listaDatosDTO = new ArrayList<ItemsMenuRootDTO>();
		
		for (ItemsMenu dato : datos) {
			if(dato.isEsRaiz()) {
				ItemsMenuRootDTO datoDTO = mapper.map(dato, ItemsMenuRootDTO.class);
					
				listaDatosDTO.add(datoDTO);
			}
			
		}
		return new ResponseEntity<>(listaDatosDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/items-menu/get-all", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllItemsMenu() {
		Collection<ItemsMenu> datos = perfilesServices.getAllItemsMenu();
		List<ItemsMenuDTO> listaDatosDTO = new ArrayList<ItemsMenuDTO>();
		
		for (ItemsMenu dato : datos) {
			ItemsMenuDTO datoDTO = mapper.map(dato, ItemsMenuDTO.class);
			//datoDTO.setIdItemMenuPadre(""+dato.getItemsMenu().getIdItemMenu());
			
			listaDatosDTO.add(datoDTO);
		}
		return new ResponseEntity<>(listaDatosDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/items-menu/get-by-perfil/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getItemsMenuByIdPerfil(@PathVariable("id") String id) {
		List<ItemsMenuDTO> menuCompletoDTO = findAllItemsByPerfil(id);
		
		if(menuCompletoDTO != null) {		
			return new ResponseEntity<>(menuCompletoDTO, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	private List<ItemsMenuDTO> findAllItemsByPerfil(String idPerfil){
		//Busco todos los Items de un Perfil
				var val = perfilesServices.findByIdPerfil(idPerfil);
				
				if(!val.isEmpty()) {
				//List<Set<ItemsMenuDTO> > menuCompletoDTO = new ArrayList<Set<ItemsMenuDTO> >();
				List<ItemsMenuDTO> menuCompletoDTO = new ArrayList<ItemsMenuDTO>();
				
				for (ItemsDePerfiles itemDePerfil : val) {
					Set<ItemsMenuDTO> listaItemsMenuDTO = new HashSet<ItemsMenuDTO>();
					
					//Obtengo el Objeto Item de Menu Raiz 
					var itemRaiz = perfilesServices.getOneItemsMenu(""+itemDePerfil.getItemsMenu().getIdItemMenu());
					ItemsMenuDTO itemRaizDTO = new ItemsMenuDTO();
					itemRaizDTO.setEsHoja(itemRaiz.get().isEsHoja());
					itemRaizDTO.setEsRaiz(itemRaiz.get().isEsRaiz());
					itemRaizDTO.setIdItemMenu(itemRaiz.get().getIdItemMenu());
					itemRaizDTO.setLink(itemRaiz.get().getLink());
					itemRaizDTO.setNombre(itemRaiz.get().getNombre());
					//ItemsMenuDTO itemRaizDTO = mapper.map(itemRaiz, ItemsMenuDTO.class);
					//listaItemsMenuDTO.add(mapper.map(itemRaiz, ItemsMenuDTO.class));
					
					
					//Itero por los Item de Menu Hijos
					for(ItemsMenu itemDeMenu : ((ItemsMenu)itemRaiz.get()).getItemsMenuHijos()) {
						ItemsMenuDTO itemDeMenuDTO = mapper.map(itemDeMenu, ItemsMenuDTO.class);
						//itemDeMenuDTO.setIdItemMenuPadre(""+itemRaiz.get().getItemsMenu().getIdItemMenu());
						listaItemsMenuDTO.add(itemDeMenuDTO);
					}
					
					itemRaizDTO.setItemsMenuHijos(listaItemsMenuDTO);
					
					//menuCompletoDTO.add(listaItemsMenuDTO);
					menuCompletoDTO.add(itemRaizDTO);
					
				}
					return menuCompletoDTO;
				}else {
					return null;
				}
	}


	@RequestMapping(value = "/items-menu/create", method = RequestMethod.POST)
	public ResponseEntity<Object> createItemsMenu(@RequestBody ItemsMenuDTO dto) {

		if(!dto.isEsRaiz()) {
			var val = perfilesServices.getOneItemsMenu(dto.getIdItemMenuPadre());
			if(val.isPresent()) {
				ItemsMenu item = mapper.map(dto, ItemsMenu.class);
				item.setItemsMenu(val.get());
				perfilesServices.createItemsMenu(item);
				return new ResponseEntity<>("ItemsMenu is created successsfully", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("ItemsMenuPadre not exist", HttpStatus.NOT_FOUND);
			}
		}else {
			ItemsMenu item = mapper.map(dto, ItemsMenu.class);
			perfilesServices.createItemsMenu(item);
			return new ResponseEntity<>("ItemsMenu is created successsfully", HttpStatus.OK);
		}
		
	}
	
	@RequestMapping(value = "/items-menu/get-one/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getOneItemsMenu(@PathVariable("id") String id) {
		var val = perfilesServices.getOneItemsMenu(id);
		if (val.isPresent()) {
			ItemsMenuDTO cDTO = mapper.map(val.get(), ItemsMenuDTO.class);
			if(val.get().getItemsMenu() != null)//Si el item no es raiz seteo el padre
				cDTO.setIdItemMenuPadre(""+val.get().getItemsMenu().getIdItemMenu());
			setIdPadre(cDTO);
			return new ResponseEntity<>(cDTO, HttpStatus.OK);

		}

		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	private void setIdPadre(ItemsMenuDTO cDTO) {
		int idPadre = cDTO.getIdItemMenu();
		for (ItemsMenuDTO itemDTO : cDTO.getItemsMenuHijos()) {
			itemDTO.setIdItemMenuPadre(""+idPadre);
			//idPadre = itemDTO.getIdItemMenu();
			setIdPadre(itemDTO);
		}
	}

	@RequestMapping(value = "/items-menu/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateItemsMenu(@PathVariable("id") String id, @RequestBody ItemsMenuDTO dto) {

		var val = perfilesServices.getOneItemsMenu(id);
		if (val.isPresent()) {
			
			if(dto.getIdItemMenuPadre()!= null && //Si viene un idPadre en el objeto lo busco y lo seteo
					dto.getIdItemMenuPadre() != "" ) {
				
				ItemsMenu item = mapper.map(dto, ItemsMenu.class);
				item.setIdItemMenu(val.get().getIdItemMenu());
				var itemPadre = perfilesServices.getOneItemsMenu(dto.getIdItemMenuPadre());//busco el item padre
				item.setItemsMenu(itemPadre.get());
				
				perfilesServices.updateItemsMenu(item);
				return new ResponseEntity<>("ItemsMenu is updated successsfully", HttpStatus.OK);
				
			}else if(dto.getIdItemMenuPadre()== null || //Si NO viene un idPadre en el objeto el nodo, busco  el que tenia y lo seteo
					dto.getIdItemMenuPadre() == "" ) {
				
				ItemsMenu item = mapper.map(dto, ItemsMenu.class);
				item.setIdItemMenu(val.get().getIdItemMenu());
				item.setItemsMenu(val.get().getItemsMenu());
				
				perfilesServices.updateItemsMenu(item);
				return new ResponseEntity<>("ItemsMenu is updated successsfully", HttpStatus.OK);
				
					
				}
			

		}
		
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

		
		
	}

	@RequestMapping(value = "/items-menu/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteItemsMenu(@PathVariable("id") String id) {
		var val = perfilesServices.getOneItemsMenu(id);
		if (val.isPresent()) {
			perfilesServices.deleteItemsMenu(val.get());
			return new ResponseEntity<>("ItemsMenu is deleted successsfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("ItemsMenu is not deleted", HttpStatus.NOT_FOUND);
		}
	}

	
	/**
	 * Rest para Cargos
	 */

	@GetMapping(value = "/cargos/get-all")
	public ResponseEntity<Object> getAllCargos() {

		Collection<Cargos> datos = perfilesServices.getAllCargos();
		List<CargosDTO> listaDatosDTO = new ArrayList<CargosDTO>();
		for (Cargos dato : datos) {
			CargosDTO datoDTO = mapper.map(dato,
					CargosDTO.class);
			listaDatosDTO.add(datoDTO);
		}
		return new ResponseEntity<>(listaDatosDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/cargos/get-one/{id}")
	public ResponseEntity<Object> getOneCargos(@PathVariable("id") String id) {
		var val = perfilesServices.getOneCargos(id);
		return new ResponseEntity<>(val.isPresent() ? mapper.map(val.get(), CargosDTO.class) : null,
				val.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@PostMapping(value = "/cargos/create")
	public ResponseEntity<Object> createCargos(@RequestBody CargosDTO dto) {
		Cargos c = mapper.map(dto, Cargos.class);
		perfilesServices.createCargos(mapper.map(dto, Cargos.class));
		return new ResponseEntity<>("Cargo is created successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/cargos/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateCargos(@PathVariable("id") String id,
			@RequestBody CargosDTO dto) {
		var val = perfilesServices.getOneCargos(id);
		if(val.isPresent()) {
			Cargos cargoUpdate = mapper.map(dto, Cargos.class);
			cargoUpdate.setIdCargo(val.get().getIdCargo());
			perfilesServices.updateCargos(cargoUpdate);
			return new ResponseEntity<>("Cargo is updated successsfully", HttpStatus.OK);
		}
		return new ResponseEntity<>("Cargo is not updated", HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/cargos/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteCargos(@PathVariable("id") String id) {
		var val = perfilesServices.getOneCargos(id);
		if (val.isPresent()) {
			perfilesServices.deleteCargos(val.get());
			return new ResponseEntity<>("Cargo is deleted successsfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Cargo is not deleted", HttpStatus.NOT_FOUND);
		}

	}

	//Rest para Items de Perfil
	
	@RequestMapping(value = "/items-de-perfil/create", method = RequestMethod.POST)
	public ResponseEntity<Object> createItemsDePerfiles(@RequestBody ItemsDePerfilesDTO dto) {
		
		var itemMenu = perfilesServices.getOneItemsMenu(dto.getIdItemMenu());
		var perfil = perfilesServices.getOnePerfiles(dto.getIdPerfil());
		if(itemMenu.isPresent() && perfil.isPresent()) {
			
			ItemsDePerfiles itemDePerfil = new ItemsDePerfiles();
			itemDePerfil.setItemsMenu(itemMenu.get());
			itemDePerfil.setPerfiles(perfil.get());
			
			perfilesServices.createItemsDePerfiles(itemDePerfil);
			
			return new ResponseEntity<>("Item de Perfil is created successsfully", HttpStatus.OK);
		}
		return new ResponseEntity<>("Item de Perfil is not created", HttpStatus.NOT_FOUND);
		
	}
	
	@RequestMapping(value = "/items-de-perfil/create-plus", method = RequestMethod.POST)
	public ResponseEntity<Object> createItemsDePerfilesPlus(@RequestBody ItemsDePerfilesDTO[] dtos) {
		
		
		for (int i = 0; i < dtos.length; i++) {
			
			var itemMenu = perfilesServices.getOneItemsMenu(dtos[i].getIdItemMenu());
			var perfil = perfilesServices.getOnePerfiles(dtos[i].getIdPerfil());
			
			if(itemMenu.isPresent() && perfil.isPresent()) {
				
				ItemsDePerfiles itemDePerfil = new ItemsDePerfiles();
				itemDePerfil.setItemsMenu(itemMenu.get());
				itemDePerfil.setPerfiles(perfil.get());
				
				perfilesServices.createItemsDePerfiles(itemDePerfil);

			}else {
				return new ResponseEntity<>("Item de Perfil is not created", HttpStatus.NOT_FOUND);
			}
			
		}	
		
		
		return new ResponseEntity<>("Item de Perfil is created successsfully", HttpStatus.OK);
		
	}

	@RequestMapping(value = "/items-de-perfil/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateItemsDePerfiles(@PathVariable("id") String id, @RequestBody ItemsDePerfilesDTO dto) {

		var itemDePerfil = perfilesServices.getOneItemsDePerfiles(id);
		var itemMenu = perfilesServices.getOneItemsMenu(dto.getIdItemMenu());
		var perfil = perfilesServices.getOnePerfiles(dto.getIdPerfil());
		if(itemDePerfil.isPresent() && itemMenu.isPresent() && perfil.isPresent()) {
			
			
			itemDePerfil.get().setItemsMenu(itemMenu.get());
			itemDePerfil.get().setPerfiles(perfil.get());
			
			perfilesServices.updateItemsDePerfiles(itemDePerfil.get());
			
			return new ResponseEntity<>("Item de Perfil is updated successsfully", HttpStatus.OK);
		}
		return new ResponseEntity<>("Item de Perfil is not updated", HttpStatus.NOT_FOUND);
		
	}

	@RequestMapping(value = "/items-de-perfil/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteItemsDePerfiles(@PathVariable("id") String id) {
		var val = perfilesServices.getOneItemsDePerfiles(id);
		if (val.isPresent()) {
			perfilesServices.deleteItemsDePerfiles(val.get());
			return new ResponseEntity<>("Item de Perfil is deleted successsfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Item de Perfil is not deleted", HttpStatus.NOT_FOUND);
		}
	}


}
