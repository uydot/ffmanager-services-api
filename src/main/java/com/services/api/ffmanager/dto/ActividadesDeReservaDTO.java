package com.services.api.ffmanager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ActividadesDeReservaDTO {

	@JsonProperty("idActividadReserva")
	private int idActividadReserva;
	@JsonProperty("duracion")
	private int duracion;
	@JsonProperty("actividades")
	private ActividadesDTO actividades;
}
