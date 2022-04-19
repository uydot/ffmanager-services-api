package com.services.api.ffmanager.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class ItemsMenuRootDTO {

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
	
}
