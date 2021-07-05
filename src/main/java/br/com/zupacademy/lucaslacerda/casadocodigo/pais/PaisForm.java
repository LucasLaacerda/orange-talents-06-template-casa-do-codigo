package br.com.zupacademy.lucaslacerda.casadocodigo.pais;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import br.com.zupacademy.lucaslacerda.casadocodigo.validacao.RegistroUnicoValid;

public class PaisForm {

	@NotBlank
	@RegistroUnicoValid(message = "Pais informado ja foi cadastrado",entidade = Pais.class,atributo="nome")
	private String nome;

	public PaisForm() {
		
	}
	
	public PaisForm(@NotBlank String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public Pais toModel(@Valid PaisForm form) {
		return new Pais(form.getNome());
	}
	
	
	
	
}
