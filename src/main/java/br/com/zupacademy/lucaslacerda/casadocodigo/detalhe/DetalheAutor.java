package br.com.zupacademy.lucaslacerda.casadocodigo.detalhe;

import br.com.zupacademy.lucaslacerda.casadocodigo.autor.Autor;

public class DetalheAutor {

	private String nome;
	private String descricao;
	
	
	public DetalheAutor(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public DetalheAutor(Autor autor) {
		this.nome = autor.getNome();
		this.descricao = autor.getDescricao();
	}

	//Apenas getters
	public String getNome() {
		return nome;
	}
	public String getDescricao() {
		return descricao;
	}
	
	
	
}
