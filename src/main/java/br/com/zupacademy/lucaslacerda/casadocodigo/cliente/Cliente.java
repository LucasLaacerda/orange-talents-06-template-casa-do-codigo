package br.com.zupacademy.lucaslacerda.casadocodigo.cliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.lucaslacerda.casadocodigo.estado.Estado;
import br.com.zupacademy.lucaslacerda.casadocodigo.pais.Pais;

@Entity
public class Cliente {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull @Email
	@Column(nullable=false)
	private String email;
	
	@NotNull @Column(nullable=false)
	private String nome;
	
	@NotNull @Column(nullable=false)
	private String sobrenome;
	
	@NotNull @Column(nullable=false)
	private String documento;
	
	@NotNull @Column(nullable=false)
	private String endereco;
	
	@NotNull @Column(nullable=false)
	private String complemento;
	
	@NotNull @Column(nullable=false)
	private String cidade;
	
	@ManyToOne
	private Pais pais;
	
	@ManyToOne
	private Estado estado;
	
	@NotNull @Column(nullable=false)
	private String telefone;
	
	@NotNull @Column(nullable=false)
	private String cep;
	
	public Cliente() {
		
	}
	
	public Cliente(@NotNull @Email String email, @NotNull String nome, @NotNull String sobrenome,
			@NotNull String documento, @NotNull String endereco, @NotNull String complemento, @NotNull String cidade,
			@NotNull Pais pais,@NotNull String telefone, @NotNull String cep) {
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

	public Long getId() {
		return id;
	}

	public void setEstado(Estado estado) throws Throwable {
		this.estado = estado;
		if(!estado.getPais().getId().equals(this.pais.getId())) throw new Exception("Estado não é do pais informado");
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

	public Pais getPais() {
		return pais;
	}

	public Estado getEstado() {
		return estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}
	
	
}
