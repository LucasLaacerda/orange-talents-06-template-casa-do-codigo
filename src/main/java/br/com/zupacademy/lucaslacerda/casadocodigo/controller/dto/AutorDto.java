package br.com.zupacademy.lucaslacerda.casadocodigo.controller.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zupacademy.lucaslacerda.casadocodigo.model.Autor;

public class AutorDto {
	
	@NotNull @NotEmpty
	private String nome;
	@NotBlank @NotNull @Email
	private String email;
	@NotBlank @NotNull @Size(min = 1, max = 400)
	private String descricao;
	
	public AutorDto(Autor autor) {
		this.nome = autor.getNome();
		this.email = autor.getEmail();
		this.descricao = autor.getDescricao();
	}
	//Apenas getters
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public String getDescricao() {
		return descricao;
	}
	
	
}
