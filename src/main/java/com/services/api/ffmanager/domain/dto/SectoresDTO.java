package com.services.api.ffmanager.domain.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Data
@NoArgsConstructor
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
	private Double tamano;
	@JsonProperty("esSectorGolero")
	private Boolean esSectorGolero;
	@JsonProperty("numeroSector")
	private Integer numeroSector;
	//@JsonBackReference
	@JsonProperty("areas")
	private AreasDTO areasDTO;
	//@JsonProperty("estadosDeSectores")
	//private Set<EstadosDeSectoresDTO> estadosDeSectores;
	//@JsonProperty("reservaDeSector")
	//private Set<ReservaDeSectorDTO> reservaDeSector;
	
	public void setAreasDTO(AreasDTO a) {
		this.areasDTO = a;
	}
}
