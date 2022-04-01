package com.services.api.ffmanager.domain.dto;

import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReservasDTO {

	@JsonProperty("idReserva")
	private int idReserva;
	@JsonProperty("fechaDesde")
	private LocalDateTime fechaDesde;
	@JsonProperty("fechaHasta")
	private LocalDateTime fechaHasta;
	@JsonProperty("actividadesDeReserva")
	private Set<ActividadesDeReservaDTO> actividadesDeReserva;
	@JsonProperty("materialesDeReserva")
	private Set<MaterialesDeReservaDTO> materialesDeReserva;
	@JsonProperty("usuarios")
	private UsuariosDTO usuarios;
}
