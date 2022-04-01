package com.services.api.ffmanager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MaterialesDeReservaDTO {

	@JsonProperty("idMaterialReserva")
	private int idMaterialReserva;
	@JsonProperty("cantidad")
	private int cantidad;
	@JsonProperty("materiales")
	private MaterialesDTO materiales;
}
