package com.services.api.ffmanager.domain.dto;

import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UsuariosDTO {

	@JsonProperty("idUsuario")
	private int idUsuario;
	@JsonProperty("usuario")
	private String usuario;
	@JsonProperty("password")
	private String password;
	@JsonProperty("fechaCreacion")
	private LocalDateTime fechaCreacion;
	@JsonProperty("nombre")
	private String nombre;
	@JsonProperty("apellido")
	private String apellido;
	@JsonProperty("email")
	private String email;
	@JsonProperty("telefono")
	private long telefono;
	@JsonProperty("reservas")
	private Set<ReservasDTO> reservas;
	@JsonProperty("cargos")
	private CargosDTO cargos;
	@JsonProperty("perfiles")
	private PerfilesDTO perfiles;
}
