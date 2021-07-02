package br.com.zupacademy.lucaslacerda.casadocodigo.livro;

import org.springframework.data.domain.Page;

public class LivroDto {
	
	private Long id;
	private String nome;
	
	
	public LivroDto(Livro livro) {
		this.id = livro.getId();
		this.nome = livro.getTitulo();
	}
	
	
	
	public Long getId() {
		return id;
	}



	public String getNome() {
		return nome;
	}



	public static Page<LivroDto> toModel(Page<Livro> livros) {
		return livros.map(LivroDto::new);
	}
}
