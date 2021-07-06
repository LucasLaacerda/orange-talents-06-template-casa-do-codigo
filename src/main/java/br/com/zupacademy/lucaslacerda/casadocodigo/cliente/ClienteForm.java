package br.com.zupacademy.lucaslacerda.casadocodigo.cliente;


import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.lucaslacerda.casadocodigo.autor.Autor;
import br.com.zupacademy.lucaslacerda.casadocodigo.categoria.Categoria;
import br.com.zupacademy.lucaslacerda.casadocodigo.estado.Estado;
import br.com.zupacademy.lucaslacerda.casadocodigo.livro.Livro;
import br.com.zupacademy.lucaslacerda.casadocodigo.pais.Pais;
import br.com.zupacademy.lucaslacerda.casadocodigo.validacao.RegistroUnicoValid;
import br.com.zupacademy.lucaslacerda.casadocodigo.validacao.VerificaIdValid;

public class ClienteForm {
	
	
	@NotBlank @Email
	@RegistroUnicoValid(message="Email ja cadastrado",entidade=Cliente.class,atributo="email")
	private String email;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String sobrenome;
	
	@NotBlank
	@RegistroUnicoValid(message="Documento ja cadastrado",entidade=Cliente.class,atributo="documento")
	private String documento;
	
	@NotBlank
	private String endereco;
	
	@NotBlank
	private String complemento;
	
	@NotBlank
	private String cidade;
	
	@NotNull @VerificaIdValid(message = "Pais inexistente",entidade=Pais.class,campoId = "id")
	private Long pais;
	
	@VerificaIdValid(message = "Estado inexistente",entidade=Estado.class,campoId = "id")
	private Long estado;
	
	@NotBlank
	private String telefone;
	
	@NotNull @NotBlank
	private String cep;
	
	public ClienteForm() {
		
	}
	
	public ClienteForm(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotNull Long pais, @NotBlank String telefone,
			@NotNull @NotBlank String cep) {
		super();
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.telefone = telefone;
		this.cep = cep;
	}
	
	
   public Cliente toModel(EntityManager m) throws Throwable {
				
		Cliente cliente = new Cliente(email, nome, sobrenome, documento, endereco, 
							complemento, cidade, m.find(Pais.class,pais), telefone, cep);
		if(estado!=null) cliente.setEstado(m.find(Estado.class,estado));
		
		return cliente;
	}

public String getEmail() {
	return email;
}

public String getNome() {
	return nome;
}

public String getSobrenome() {
	return sobrenome;
}

public String getDocumento() {
	return documento;
}

public String getEndereco() {
	return endereco;
}

public String getComplemento() {
	return complemento;
}

public String getCidade() {
	return cidade;
}

public Long getPais() {
	return pais;
}

public Long getEstado() {
	return estado;
}

public String getTelefone() {
	return telefone;
}

public String getCep() {
	return cep;
}
	



}
