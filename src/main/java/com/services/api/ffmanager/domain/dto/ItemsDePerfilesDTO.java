package com.services.api.ffmanager.domain.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ItemsDePerfilesDTO {

	@JsonProperty("idItemPerfil")
	private int idItemPerfil;
	@JsonProperty("itemsMenu")
	private ItemsMenuDTO itemsMenu;
}
