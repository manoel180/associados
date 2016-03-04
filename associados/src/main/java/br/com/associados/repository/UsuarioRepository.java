package br.com.associados.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.associados.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

	Usuario getUsuarioByLogin(String login);

	Usuario getUsuarioById(Long id);

}
