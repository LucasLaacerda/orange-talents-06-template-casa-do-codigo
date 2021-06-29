package br.com.zupacademy.lucaslacerda.casadocodigo.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AutorForm {
	
	@NotNull @NotEmpty
	private String nome;
	@NotBlank @NotNull @Email
	private String email;
	@NotBlank @NotNull @Size(min = 1, max = 400)
	private String descricao;
	
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
