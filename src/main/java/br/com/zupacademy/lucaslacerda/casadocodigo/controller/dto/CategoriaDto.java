package br.com.zupacademy.lucaslacerda.casadocodigo.controller.dto;

import javax.validation.constraints.NotBlank;


public class CategoriaDto {
	@NotBlank
	private String nome;

	
	
	public CategoriaDto(@NotBlank String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	
	
	
}
