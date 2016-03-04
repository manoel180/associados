package br.com.associados.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.associados.entities.Cidade;
import br.com.associados.entities.Estado;

public interface CidadeRepository extends CrudRepository<Cidade, Long>{

	public List<Cidade> findByEstado(Estado estado);

}
