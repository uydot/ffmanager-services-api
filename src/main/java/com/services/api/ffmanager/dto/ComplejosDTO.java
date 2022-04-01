package com.services.api.ffmanager.dto;

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
	@JsonProperty("datosInstitucionDeportivaDTO")
	private DatosInstitucionDeportivaDTO datosInstitucionDeportivaDTO;
}
