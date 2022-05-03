package com.services.api.ffmanager.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MaterialCantidadDTO {

	@JsonProperty("idMaterial")
	private String idMaterial;
	@JsonProperty("cantidad")
	private String cantidad;
	
	public String getIdMaterial() {
		return this.idMaterial;
	}
	
	public String getCantidad() {
		return this.cantidad;
	}
}
