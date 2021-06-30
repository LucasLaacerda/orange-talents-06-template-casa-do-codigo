package br.com.zupacademy.lucaslacerda.casadocodigo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import br.com.zupacademy.lucaslacerda.casadocodigo.controller.form.CategoriaForm;

@Entity
public class Categoria {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	
	public Categoria() {
	}
	public Categoria(@NotBlank String nome) {
		this.nome = nome;
	}
	
	//Apenas get nome
	public String getNome() {
		return nome;
	}
		
	
	
	
}
