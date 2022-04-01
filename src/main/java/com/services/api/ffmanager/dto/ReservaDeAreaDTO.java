package com.services.api.ffmanager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReservaDeAreaDTO {

	@JsonProperty("idReservaArea")
	private int idReservaArea;
	@JsonProperty("reservas")
	private ReservasDTO reservas;
}
