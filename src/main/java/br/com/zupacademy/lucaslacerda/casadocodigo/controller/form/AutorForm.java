package br.com.zupacademy.lucaslacerda.casadocodigo.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zupacademy.lucaslacerda.casadocodigo.validacao.EmailJaRegistradoValid;

public class AutorForm {
	
	@NotBlank
	private String nome;
	@NotBlank @Email @EmailJaRegistradoValid(message="Email informado ja foi cadastrado")
	private String email;
	@NotBlank @Size(min = 1, max = 400)
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
