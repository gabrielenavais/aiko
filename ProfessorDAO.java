package br.com.aiko.dao;

import javax.persistence.EntityManager;

import br.com.aiko.modelo.Professor;

public class ProfessorDAO {
public static void remove(Professor professor){
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		
		em.remove(em.merge(professor));
		
		em.getTransaction().commit();
		
		em.close();
	}
	
	
	public static void atualiza(Professor professor){
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.merge(professor);
		
		em.getTransaction().commit();
		em.close();
	}
	

}
