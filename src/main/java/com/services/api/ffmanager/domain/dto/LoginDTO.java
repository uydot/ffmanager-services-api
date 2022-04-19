package com.services.api.ffmanager.domain.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginDTO {

	@JsonProperty("idUsuario")
	private String idUsuario;
	@JsonProperty("usuario")
	private String usuario;
	@JsonProperty("password")
	private String password;
	@JsonProperty("items-menu")
	private List<ItemsMenuDTO> menuCompletoDTO;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setMenuCompletoDTO(List<ItemsMenuDTO> l) {
		this.menuCompletoDTO = l;
	}

	public List<ItemsMenuDTO> getMenuCompletoDTO(){
		return this.menuCompletoDTO;
	}
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	
}
