package br.com.zupacademy.lucaslacerda.casadocodigo.autor;

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
	private LocalDateTime dataRegistro = LocalDateTime.now();
	
	
	public Autor() {
	}
	
	public Autor(@NotBlank String nome, @NotBlank @Email String email,
			@NotBlank @Size(min = 1, max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor(@Valid AutorForm form) {
		this.nome = form.getNome();
		this.email = form.getEmail();
		this.descricao = form.getDescricao();
	}

	
	
}
