package br.com.zupacademy.lucaslacerda.casadocodigo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Livro {
	
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank 
	private String titulo;
	
	@NotBlank @Size(max=500)
	@Column(nullable = false,length = 500)
	private String resumo;
	
	@Lob
	private String sumario; 
	
	@NotNull @Min(20)
	@Column(nullable = false)
	private Double preco;
	@NotNull @Min(100)
	@Column(nullable = false) 
	private Integer numPaginas;
	
	@NotBlank 
	@Column(nullable = false)
	private String isbn;
	
	@Future @JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dataPublicacao;
	
	@ManyToOne @NotNull
	private Categoria categoria;
	@ManyToOne @NotNull
	private Autor autor;
	
	@Deprecated
	public Livro() {
		
	}
	
	public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
			@NotNull @Min(20) Double preco, @NotNull @Min(100) Integer numPaginas, @NotBlank String isbn,
			@FutureOrPresent LocalDate dataPublicacao, @NotNull Categoria categoria, @NotNull Autor autor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numPaginas = numPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categoria = categoria;
		this.autor = autor;
	}
	
	
	
	
		
}
