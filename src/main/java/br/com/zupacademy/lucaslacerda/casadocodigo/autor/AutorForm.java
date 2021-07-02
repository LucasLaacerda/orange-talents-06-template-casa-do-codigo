package br.com.zupacademy.lucaslacerda.casadocodigo.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zupacademy.lucaslacerda.casadocodigo.validacao.RegistroUnicoValid;

public class AutorForm {
	
	@NotBlank
	private String nome;
	@NotBlank @Email @RegistroUnicoValid(message="Email informado ja foi cadastrado",entidade = Autor.class,atributo = "email")
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
	
	public Autor toModel(AutorForm form) {
		return new Autor(form);
	}
}
