package br.com.zupacademy.lucaslacerda.casadocodigo.estado;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.lucaslacerda.casadocodigo.pais.Pais;
import br.com.zupacademy.lucaslacerda.casadocodigo.validacao.RegistroUnicoValid;
import br.com.zupacademy.lucaslacerda.casadocodigo.validacao.VerificaIdValid;


public class EstadoForm {
	
	@NotBlank
	private String nome;
	
	@NotNull @VerificaIdValid(message = "Pais inexistente",entidade=Pais.class,campoId = "id")
	private Long pais;

	
	public EstadoForm() {
		
	}
	public EstadoForm(@NotBlank String nome, @NotNull Long pais) {
		super();
		this.nome = nome;
		this.pais = pais;
	}
	
	public String getNome() {
		return nome;
	}
	public Long getPais() {
		return pais;
	}
	public Estado toModel(@Valid EstadoForm form,EntityManager m) {
		return new Estado(form.getNome(), m.find(Pais.class, form.getPais()));
	}
	
	
	
	
}
