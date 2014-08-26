package br.com.associados.dao.imp;

import org.springframework.stereotype.Repository;

import br.com.associados.dao.UsuarioDao;
import br.com.associados.model.Usuario;

@Repository
public class UsuarioDaoImp extends GenericDaoImp<Usuario> implements UsuarioDao {

	@Override
	public Usuario getUsuarioById(Long id) {
		
		
    return em.find(Usuario.class, id);
	}
	
}
