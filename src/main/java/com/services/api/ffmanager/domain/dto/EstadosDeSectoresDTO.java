package com.services.api.ffmanager.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EstadosDeSectoresDTO {
	
	@JsonProperty("idEstadoSector")
	private int idEstadoSector;
	@JsonProperty("fechaAsignado")
	private LocalDateTime fechaAsignado;
	@JsonProperty("estados")
	private EstadosDTO estados;

}
