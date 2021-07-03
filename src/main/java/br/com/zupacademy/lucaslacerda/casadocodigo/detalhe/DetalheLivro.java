package br.com.zupacademy.lucaslacerda.casadocodigo.detalhe;

import java.time.LocalDate;

import br.com.zupacademy.lucaslacerda.casadocodigo.livro.Livro;

public class DetalheLivro {

	private String titulo;
	private String resumo;
	private String sumario;
	private Double preco;
	private Integer numPaginas;
	private String isbn;
	private LocalDate dataPublicacao;
	private DetalheAutor autor;
	

	
	public DetalheLivro(Livro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario(); 
		this.preco = livro.getPreco();						
		this.numPaginas = livro.getNumPaginas(); 
		this.isbn = livro.getIsbn(); 
		this.dataPublicacao = livro.getDataPublicacao();
		this.autor = new DetalheAutor(livro.getAutor());
	}



	//Apenas getters
	public String getTitulo() {
		return titulo;
	}


	public String getResumo() {
		return resumo;
	}


	public String getSumario() {
		return sumario;
	}


	public Double getPreco() {
		return preco;
	}


	public Integer getNumPaginas() {
		return numPaginas;
	}


	public String getIsbn() {
		return isbn;
	}


	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}



	public DetalheAutor getAutor() {
		return autor;
	}


	
	
	
	
}
