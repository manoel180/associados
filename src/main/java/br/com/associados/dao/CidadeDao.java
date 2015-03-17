package br.com.associados.dao;

import java.util.List;

import br.com.associados.model.Cidade;

public interface CidadeDao extends GenericDao<Cidade>{

    List<Cidade> listCidadeByEstado(Integer id);

}
