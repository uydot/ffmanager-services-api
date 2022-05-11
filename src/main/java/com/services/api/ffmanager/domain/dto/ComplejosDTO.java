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

@AllArgsConstructor
@Data
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ComplejosDTO {

	@JsonProperty("idComplejo")
	private int idComplejo;
	@JsonProperty("nombre")
	private String nombre;
	@JsonProperty("direccion")
	private String direccion;
	@JsonProperty("telefonoContacto")
	private String telefonoContacto;
	//@JsonBackReference
	@JsonProperty("datosInstitucionDeportiva")
	private DatosInstitucionDeportivaDTO datosInstitucionDeportivaDTO;
	//@JsonManagedReference
	//@JsonProperty("areas")
	//private Set<AreasDTO> areas;
	
	public void setDatosInstitucionDeportivaDTO(DatosInstitucionDeportivaDTO dto) {
		this.datosInstitucionDeportivaDTO = dto;
	}
}
