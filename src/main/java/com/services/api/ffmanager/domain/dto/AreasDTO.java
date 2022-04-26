package com.services.api.ffmanager.domain.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class AreasDTO {

	@JsonProperty("idArea")
	private int idArea;
	@JsonProperty("nombre")
	private String nombre;
	@JsonProperty("observaciones")
	private String observaciones;
	@JsonProperty("tiposAreas")
	private TiposAreasDTO tiposAreas;
	//@JsonBackReference
	@JsonProperty("complejos")
	private ComplejosDTO complejosDTO;
	//@JsonManagedReference
	@JsonProperty("sectores")
	private Set<SectoresDTO> sectores;
	
	public void setComplejosDTO(ComplejosDTO dto) {
		this.complejosDTO = dto;
	}
}
