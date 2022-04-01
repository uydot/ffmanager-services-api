package com.services.api.ffmanager.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EstadosDTO {
	
	@JsonProperty("idEstado")
	private int idEstado;
	@JsonProperty("nombre")
	private String nombre;
	@JsonProperty("observaciones")
	private String observaciones;
	@JsonProperty("permiteUsar")
	private boolean permiteUsar;

}
