package com.services.api.ffmanager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MaterialesDTO {

	@JsonProperty("idMaterial")
	private int idMaterial;
	@JsonProperty("nombre")
	private String nombre;
	@JsonProperty("stock")
	private int stock;
	@JsonProperty("idItemMenu")
	private int maximoPorDia;
	@JsonProperty("idItemMenu")
	private String observaciones;
}
