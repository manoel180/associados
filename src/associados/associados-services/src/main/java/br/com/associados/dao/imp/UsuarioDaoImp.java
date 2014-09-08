package br.com.associados.dao.imp;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.associados.dao.UsuarioDao;
import br.com.associados.model.Usuario;

@Repository
public class UsuarioDaoImp extends GenericDaoImp<Usuario> implements UsuarioDao {

	@Override
	public Usuario getUsuarioById(Long id) {
		return em.find(Usuario.class, id);
	}
	
	@Override
	public Usuario getUsuarioByLogin(String login) {
		 Query query = this.em
	                .createQuery("FROM Usuario where login = ?1");
		 query.setParameter(1, login);
		return (Usuario) query.getSingleResult();
	}
}
