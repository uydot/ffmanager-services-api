package com.services.api.ffmanager.domain.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class ItemsMenuDTO {

	@JsonProperty("idItemMenu")
	private int idItemMenu;
	@JsonProperty("nombre")
	private String nombre;
	@JsonProperty("link")
	private String link;
	@JsonProperty("esHoja")
	private boolean esHoja;
	@JsonProperty("esRaiz")
	private boolean esRaiz;
	@JsonProperty("idItemMenuPadre")
	private String idItemMenuPadre;
	@JsonProperty("itemsMenuHijos")
	private Set<ItemsMenuDTO> itemsMenuHijos;
	
	public String getIdItemMenuPadre() {
		return idItemMenuPadre;
	}
	
	public void setIdItemMenuPadre(String id) {
		this.idItemMenuPadre = id;
	}
	
	public void setItemsMenuHijos(Set<ItemsMenuDTO> itemsMenuHijos) {
		this.itemsMenuHijos = itemsMenuHijos;
	}

	public int getIdItemMenu() {
		return idItemMenu;
	}

	public void setIdItemMenu(int idItemMenu) {
		this.idItemMenu = idItemMenu;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public boolean isEsHoja() {
		return esHoja;
	}

	public void setEsHoja(boolean esHoja) {
		this.esHoja = esHoja;
	}

	public boolean isEsRaiz() {
		return esRaiz;
	}

	public void setEsRaiz(boolean esRaiz) {
		this.esRaiz = esRaiz;
	}

	public Set<ItemsMenuDTO> getItemsMenuHijos() {
		return itemsMenuHijos;
	}
	
	
}
