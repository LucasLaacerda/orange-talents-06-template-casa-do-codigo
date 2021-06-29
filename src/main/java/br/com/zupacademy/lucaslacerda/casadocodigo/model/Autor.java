package br.com.zupacademy.lucaslacerda.casadocodigo.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import br.com.zupacademy.lucaslacerda.casadocodigo.controller.form.AutorForm;
import br.com.zupacademy.lucaslacerda.casadocodigo.validacao.EmailJaRegistradoValid;

@Entity
public class Autor {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank @NotNull
	private String nome;
	@NotBlank @NotNull @Email
	private String email;
	@NotBlank @NotNull @Size(min = 1, max = 400)
	private String descricao;
	@NotNull
	LocalDateTime dataRegistro = LocalDateTime.now();
	
	
	public Autor() {
	}
	
	public Autor(Long id, @NotBlank String nome, @NotBlank @Email String email,
			@NotBlank @Size(min = 1, max = 400) String descricao, LocalDateTime dataRegistro) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		this.dataRegistro = dataRegistro;
	}

	public Autor(@Valid AutorForm form) {
		this.nome = form.getNome();
		this.email = form.getEmail();
		this.descricao = form.getDescricao();
	}

	//Apenas getters de nome, email e descricao
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
