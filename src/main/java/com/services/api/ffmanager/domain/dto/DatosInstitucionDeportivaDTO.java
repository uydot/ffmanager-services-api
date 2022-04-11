package com.services.api.ffmanager.domain.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.services.api.ffmanager.domain.entities.Complejos;

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
	@JsonProperty("complejos")
	private Set<ComplejosDTO> complejos;
	

}
