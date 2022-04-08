package com.services.api.ffmanager.domain.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
//	@JsonProperty("datosInstitucionDeportiva")
//	private DatosInstitucionDeportivaDTO datosInstitucionDeportivaDTO;
	@JsonProperty("areas")
	private Set<AreasDTO> areas;
}
