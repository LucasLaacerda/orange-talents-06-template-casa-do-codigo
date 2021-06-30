package br.com.zupacademy.lucaslacerda.casadocodigo.controller.form;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.lucaslacerda.casadocodigo.model.Categoria;
import br.com.zupacademy.lucaslacerda.casadocodigo.validacao.RegistroUnicoValid;

public class CategoriaForm {
	
	@NotBlank @RegistroUnicoValid(message="Nome informado ja foi cadastrado",tabela = "Categoria",atributo = "nome")
	private String nome;

	
	public CategoriaForm() {
		
	}
	public CategoriaForm(@NotBlank String nome) {
		this.nome = nome;
	}

	//Apenas getters
	public String getNome() {
		return nome;
	}
	
	public Categoria toModel(CategoriaForm form) {
		return new Categoria(form.getNome());
	}
}
