package com.services.api.ffmanager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReservaDeSectorDTO {
	
	@JsonProperty("idReservaSector")
	private int idReservaSector;
	@JsonProperty("reservas")
	private ReservasDTO reservas;

}
