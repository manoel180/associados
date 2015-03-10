package br.com.associados.dao;

import br.com.associados.model.Usuario;

public interface UsuarioDao extends GenericDao<Usuario>{

	Usuario getUsuarioById(Long id);

	Usuario getUsuarioByLogin(String login);

}
