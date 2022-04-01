package com.services.api.ffmanager.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TiposAreasDTO {
	
	@JsonProperty("idTipoArea")
	private int idTipoArea;
	@JsonProperty("nombre")
	private String nombre;
	@JsonProperty("descripcion")
	private String descripcion;
	@JsonProperty("esTechada")
	private boolean esTechada;
	@JsonProperty("observaciones")
	private String observaciones;
	@JsonProperty("esCompuesta")
	private boolean esCompuesta;

}
