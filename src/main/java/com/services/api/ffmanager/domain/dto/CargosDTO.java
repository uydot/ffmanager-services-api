package com.services.api.ffmanager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CargosDTO {

	@JsonProperty("idCargo")
	private int idCargo;
	@JsonProperty("nombre")
	private String nombre;
	
}
