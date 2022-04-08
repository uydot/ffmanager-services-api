package com.services.api.ffmanager.domain.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AreasDTO {

	@JsonProperty("idArea")
	private int idArea;
	@JsonProperty("nombre")
	private String nombre;
	@JsonProperty("observaciones")
	private String observaciones;
	@JsonProperty("tiposAreasDTO")
	private TiposAreasDTO tiposAreasDTO;
//	@JsonProperty("complejosDTO")
//	private ComplejosDTO complejos;
	@JsonProperty("sectores")
	private Set<SectoresDTO> sectores;
}
