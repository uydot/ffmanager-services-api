package com.services.api.ffmanager.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReservaDeSectorTransferDTO {
	
	@JsonProperty("idArea")
	private String idArea;
	@JsonProperty("idSector")
	private String idSector;//idSector
	@JsonProperty("fechaHoraDesde")
	private String fechaHoraDesde;//Formato aaaa-MM-dd HH:MM:SS
	@JsonProperty("fechaHoraHasta")
	private String fechaHoraHasta;//Formato aaaa-MM-dd HH:MM:SS
	@JsonProperty("materilesDeReserva")
	private MaterialCantidadDTO[] materilesDeReserva;//Lista de idMateriales
	@JsonProperty("actividadesDeReserva")
	private String[] actividadesDeReserva;//Lista de idActividades
	@JsonProperty("usuarioDeReserva")
	private String usuarioDeReserva;//idUsuario
 
}
