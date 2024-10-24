package br.com.aiko.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.aiko.modelo.Aluno;
import br.com.aiko.modelo.Curso;

public class AlunoDAO {
	
	public static void remove(Aluno aluno){
		
		removerCursos(aluno);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		
		em.remove(em.merge(aluno));
		
		em.getTransaction().commit();
		
		em.close();
	}
	
	public static void removerCursos(Aluno aluno){
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		try{
			for(Curso curso : aluno.getCursos()){
				curso.getAlunos().remove(aluno);
				
				em.merge(curso);
			}
			aluno.getCursos().clear();
			
			em.merge(aluno);
			
			em.getTransaction().commit();
			
		}catch(Exception e){}
		
		em.close();
		
	}
	
	public static void atualiza(Aluno aluno){
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.merge(aluno);
		
		em.getTransaction().commit();
		em.close();
	}
	
	public static Aluno pesquisa(String nome) {
		EntityManager em = new JPAUtil().getEntityManager();
		String jpql = "from Aluno where nome like :nome";
		
		TypedQuery<Aluno> query = em.createQuery(jpql, Aluno.class);
		
		query.setParameter("nome", nome + "%");
		
		return (Aluno) query.getResultList();
		
	}
	

}
