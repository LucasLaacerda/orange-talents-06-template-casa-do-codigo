package br.com.zupacademy.lucaslacerda.casadocodigo.livro;

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

import br.com.zupacademy.lucaslacerda.casadocodigo.autor.Autor;
import br.com.zupacademy.lucaslacerda.casadocodigo.categoria.Categoria;

@Entity
public class Livro {
	
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank 
	//@Column(nullable = false,unique = true) Mysql nao ta conseguindo inserir a chave
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
	//@Column(nullable = false,unique = true)
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

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}
	
	
	
	
		
}
