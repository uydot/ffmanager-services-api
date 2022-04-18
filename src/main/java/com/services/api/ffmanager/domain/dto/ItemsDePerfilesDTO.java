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
	@JsonProperty("idItemDeMenu")
	private String idItemMenu;
	@JsonProperty("idPerfil")
	private String idPerfil;
	
	
	public String getIdItemMenu() {
		return idItemMenu;
	}
	public void setIdItemMenu(String idItemMenu) {
		this.idItemMenu = idItemMenu;
	}
	public String getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(String idPerfil) {
		this.idPerfil = idPerfil;
	}
	
	
}
