package com.services.api.ffmanager.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EstadosDeSectoresSimpleDTO {
	
	
	@JsonProperty("id-estado")
	private String estado;
	@JsonProperty("id-sector")
	private String sector;

}
