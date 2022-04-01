package com.services.api.ffmanager.domain.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SectoresDTO {

	@JsonProperty("idSector")
	private int idSector;
	@JsonProperty("nombre")
	private String nombre;
	@JsonProperty("observaciones")
	private String observaciones;
	@JsonProperty("tamano")
	private double tamano;
	@JsonProperty("esSectorGolero")
	private boolean esSectorGolero;
	@JsonProperty("numeroSector")
	private int numeroSector;
	@JsonProperty("estadosDeSectores")
	private Set<EstadosDeSectoresDTO> estadosDeSectores;
	@JsonProperty("reservaDeSector")
	private Set<ReservaDeSectorDTO> reservaDeSector;
}
