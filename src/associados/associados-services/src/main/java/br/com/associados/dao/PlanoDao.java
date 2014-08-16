package br.com.associados.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.associados.model.Plano;

@Repository
public class PlanoDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void save(Plano plano) {
		entityManager.persist(plano);
	}

	@SuppressWarnings("unchecked")
	public List<Plano> list() {
		return entityManager.createQuery("select p from Plano p")
				.getResultList();
	}

}
