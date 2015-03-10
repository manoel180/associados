package br.com.associados.dao;

import java.util.List;

import br.com.associados.model.Perfil;

public interface PerfilDao extends GenericDao<Perfil>{
	@Override
	public List<Perfil> listAll() ;
}
