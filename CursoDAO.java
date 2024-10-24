package br.com.aiko.dao;

import javax.persistence.EntityManager;

import br.com.aiko.modelo.Curso;

public class CursoDAO {

	public static void remove(Curso curso) {

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		em.remove(em.merge(curso));

		em.getTransaction().commit();

		em.close();
	}

	public void atualiza(Curso curso) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		em.merge(curso);

		em.getTransaction().commit();
		em.close();
	}

}
