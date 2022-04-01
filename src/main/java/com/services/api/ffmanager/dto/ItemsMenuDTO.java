package com.services.api.ffmanager.dto;

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
	@JsonProperty("itemsMenuHijos")
	private Set<ItemsMenuDTO> itemsMenuHijos;
}
