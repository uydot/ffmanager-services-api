package com.services.api.ffmanager.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AreasSimpleDTO {

	@JsonProperty("descripcion")
	private String descripcion;
	@JsonProperty("idArea")
	private String idArea;
	@JsonProperty("nombre")
	private String nombre;
	
}
