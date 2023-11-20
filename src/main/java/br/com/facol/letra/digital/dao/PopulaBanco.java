package br.com.facol.letra.digital.dao;

import javax.persistence.EntityManager;

import br.com.facol.letra.digital.model.Livro;

public class PopulaBanco {
	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();

		Livro casmurro = new Livro("978-8-52-504464-8", "Dom Casmurro", "Geral", 500);
		Livro memorias = new Livro("978-8-50-815415-9", "Memorias Postumas de Bras Cubas", "Geral", 500);
		Livro quincas = new Livro("978-8-50-804084-1", "Quincas Borba", "Geral", 500);

		em.persist(casmurro);
		em.persist(memorias);
		em.persist(quincas);

		em.getTransaction().commit();
		em.close();

	}

}
