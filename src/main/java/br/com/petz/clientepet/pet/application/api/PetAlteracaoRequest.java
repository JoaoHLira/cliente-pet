package br.com.petz.clientepet.pet.application.api;

import java.time.LocalDate;

import br.com.petz.clientepet.pet.Porte;
import br.com.petz.clientepet.pet.SexoPet;
import br.com.petz.clientepet.pet.TipoPet;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class PetAlteracaoRequest {

	@NotBlank
	private String nomePet;
	private Porte porte;
	@NotNull
	private TipoPet tipo;
	private String microchip;
	@NotBlank
	private String raca;
	@NotNull
	private SexoPet sexo;
	private String pelagemCor;
	@NotNull
	private LocalDate dataNascimento;
	private String rga;
	private Integer peso;
}
