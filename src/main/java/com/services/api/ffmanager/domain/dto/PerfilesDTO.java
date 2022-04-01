package com.services.api.ffmanager.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class PerfilesDTO {

	@JsonProperty("idPerfil")
	private int idPerfil;
	@JsonProperty("nombre")
	private String nombre;
	@JsonProperty("esAdmin")
	private boolean esAdmin;
	@JsonProperty("itemsDePerfiles")
	private Set<ItemsDePerfilesDTO> itemsDePerfiles;
	
}
