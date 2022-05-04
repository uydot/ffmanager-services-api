package com.services.api.ffmanager.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReservaDeSectorDTO {
	
	@JsonProperty("idReservaSector")
	private int idReservaSector;//idSector
	@JsonProperty("reserva")
	private ReservasDTO reservas;//idUsuario
 
}
