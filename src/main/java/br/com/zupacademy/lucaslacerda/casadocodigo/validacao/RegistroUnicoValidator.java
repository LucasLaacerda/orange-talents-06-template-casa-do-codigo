package br.com.zupacademy.lucaslacerda.casadocodigo.validacao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import br.com.zupacademy.lucaslacerda.casadocodigo.model.Autor;
import br.com.zupacademy.lucaslacerda.casadocodigo.repository.AutorRepository;

public class RegistroUnicoValidator implements ConstraintValidator<RegistroUnicoValid, String> {

	
	 private String value;
	 private String tabela;
	 private String atributo;
	 
	 @Autowired
	 AutorRepository autorRepository;
	
	 @PersistenceContext
	 EntityManager em;
	 
	@Override
	 public void initialize(RegistroUnicoValid constraintAnnotation) {
	      this.value = constraintAnnotation.value();
	      this.tabela = constraintAnnotation.tabela();
	      this.atributo = constraintAnnotation.atributo();
	 }

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		
	        String jpql = "select t from "+tabela+" t where t."+atributo+" = :pValor";

	        Query query = em.createQuery(jpql);
	        query.setParameter("pValor", value);
	        List<?> resultList = query.getResultList();
		
		if(!resultList.isEmpty() || resultList.size()>0) {
			return false;
		}
		return true;
	}

}
