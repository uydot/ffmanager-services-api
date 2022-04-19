package com.services.api.ffmanager.domain.dto;

import java.util.Collection;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.services.api.ffmanager.domain.entities.ItemsDePerfiles;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class PerfilesConItemsDTO {

	@JsonProperty("idPerfil")
	private int idPerfil;
	@JsonProperty("nombre")
	private String nombre;
	@JsonProperty("esAdmin")
	private boolean esAdmin;
	@JsonProperty("itemsDelPerfil")
	private Collection<ItemsDePerfilesDTO> itemsDePerfiles;

	public void setItemsDePerfiles(Collection<ItemsDePerfilesDTO> itemsDePerfiles) {
		this.itemsDePerfiles = itemsDePerfiles;
	}
}
