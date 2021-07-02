package br.com.zupacademy.lucaslacerda.casadocodigo.livro;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.Lob;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zupacademy.lucaslacerda.casadocodigo.autor.Autor;
import br.com.zupacademy.lucaslacerda.casadocodigo.categoria.Categoria;
import br.com.zupacademy.lucaslacerda.casadocodigo.validacao.RegistroUnicoValid;
import br.com.zupacademy.lucaslacerda.casadocodigo.validacao.VerificaIdValid;

public class LivroForm {

	@NotBlank
	@RegistroUnicoValid(message = "Titulo informado ja foi cadastrado",entidade = Livro.class,atributo="titulo")
	private String titulo;
	
	@NotBlank
	@Size(max=500,message = "Num.Maximo de caracteres: 500")
	private String resumo;
	
	@Lob
	private String sumario;
	
	@NotNull 
	@Min(value=20,message = "Preco minimo: 20")
	private Double preco;
	
	@NotNull 
	@Min(value=100,message = "Numero mininmo de paginas: 100")
	private Integer numPaginas;
	
	@NotBlank 
	@RegistroUnicoValid(message = "Isbn informado ja foi cadastrado",entidade = Livro.class,atributo="isbn")//@ISBN 
	private String isbn;
	
	@Future(message = "A data de publicação deve ser futura") 
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dataPublicacao;
	
	@NotNull 
	@VerificaIdValid(message = "Categoria inexistente",entidade = Categoria.class,campoId = "id")
	private Long categoriaId;
	
	@NotNull 
	@VerificaIdValid(message = "Autor inexistente",entidade = Autor.class,campoId = "id")
	private Long autorId;
	
	public LivroForm() {
		
	}
	
	public LivroForm(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
			@NotNull @Min(20) Double preco, @NotNull @Min(100) Integer numPaginas, @NotBlank String isbn,
			@FutureOrPresent LocalDate dataPublicacao, @NotNull Long categoriaId, @NotNull Long autorId) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numPaginas = numPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categoriaId = categoriaId;
		this.autorId = autorId;
	}
	
	
	public Livro toModel(EntityManager m) {
		
		return new Livro(titulo, resumo, sumario, preco, 
					    numPaginas,isbn, dataPublicacao, 
					    m.find(Categoria.class, categoriaId),
					    m.find(Autor.class, autorId));
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

	public Long getCategoriaId() {
		return categoriaId;
	}

	public Long getAutorId() {
		return autorId;
	}

	
	
	
	
}
