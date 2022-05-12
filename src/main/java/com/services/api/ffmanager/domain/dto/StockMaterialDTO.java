package com.services.api.ffmanager.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class StockMaterialDTO {
	
	@JsonProperty("stock")
	private Integer stock;
	@JsonProperty("nombre")
	private String nombre;
	@JsonProperty("idMaterial")
	private Integer idMaterial;
	
}
