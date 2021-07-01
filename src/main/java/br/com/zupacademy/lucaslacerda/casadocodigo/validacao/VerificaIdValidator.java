package br.com.zupacademy.lucaslacerda.casadocodigo.validacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class VerificaIdValidator implements ConstraintValidator<VerificaIdValid, Object> {

	 private String atributo;
	 private Class<?> entidade;
	 
	
	 @PersistenceContext
	 EntityManager em;
	 
	@Override
	 public void initialize(VerificaIdValid constraintAnnotation) {	
		  atributo = constraintAnnotation.campoId();
	      entidade = constraintAnnotation.entidade();
	 }

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		
	        Query query = em.createQuery("select t from "+this.entidade.getName()+" t where t."+atributo+" = :pValor");
	        query.setParameter("pValor", value);
	        List<?> resultList = query.getResultList();
		
		return (resultList.size()>0);
	}
}
