package com.services.api.ffmanager.domain.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AreasDisponiblesPorComplejoDTO {

	@JsonProperty("listaAreas")
	List<AreasSimpleDTO> listaAreas;
}
