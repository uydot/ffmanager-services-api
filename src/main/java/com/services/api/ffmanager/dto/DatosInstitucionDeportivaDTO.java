package com.services.api.ffmanager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DatosInstitucionDeportivaDTO {

	@JsonProperty("idDatosInstitucionDeportiva")
	private int idDatosInstitucionDeportiva;
	@JsonProperty("nombre")
	private String nombre;
	@JsonProperty("observaciones")
	private String observaciones;
	@JsonProperty("direccion")
	private String direccion;
	@JsonProperty("telefonoContacto")
	private String telefonoContacto;

}
