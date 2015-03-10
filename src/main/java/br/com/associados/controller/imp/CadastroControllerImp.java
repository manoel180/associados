package br.com.associados.controller.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.associados.controller.CadastroController;
import br.com.associados.dao.AssociadoDao;
import br.com.associados.dao.FuncaoEclesiasticaDao;
import br.com.associados.dao.PlanoDao;
import br.com.associados.dao.UsuarioDao;
import br.com.associados.model.Associado;
import br.com.associados.model.FuncoesEclesiastica;
import br.com.associados.model.Plano;
import br.com.associados.model.Usuario;

@Service
public class CadastroControllerImp implements CadastroController {

	@Autowired
	PlanoDao planoDao;
	
	@Autowired
	AssociadoDao associadoDao;

	@Autowired
	FuncaoEclesiasticaDao funcaoEclesiasticaDao;

	@Autowired
	UsuarioDao usuarioDao;
	
	/**
	 * Associados
	 */
	@Override
	public void salvarAssociado(Associado associado) {
		associadoDao.save(associado);
	}
	@Override
	public void editarAssociado(Associado associado) {
		associadoDao.update(associado);
	}
	@Override
	public void deleteAssociado(Associado associado) {
		associadoDao.delete(associado.getIdassociados());
	}
	
	
	/**
	 * Funcao Eclesiastica
	 */
	@Override
	public List<FuncoesEclesiastica> listAllFuncaoEclesiastica() {
		return funcaoEclesiasticaDao.listAll();
	}
	
	/**
	 * Usuario
	 */
	@Override
	public void salvarUsuario(Usuario usuario) {
		usuarioDao.save(usuario);
	}
	@Override
	public void editarUsuario(Usuario usuario) {
		usuarioDao.update(usuario);
	}
	@Override
	public void deleteUsuario(Usuario usuario) {
		usuarioDao.delete(usuario.getIdusuarios());
	}
	
	@Override
	public List<Usuario> listAllUsuarios() {
		return usuarioDao.listAll();
	}
	
	@Override
	public Usuario getUsuarioById(Long id) {
		return usuarioDao.getUsuarioById(id);
	}
	@Override
	public Usuario getUsuarioByLogin(String login) {
		return usuarioDao.getUsuarioByLogin(login);
	}
	
	
	/**
	 * Planos
	 */
	@Override
	public void salvarPlano(Plano plano) {
		planoDao.save(plano);
	}
	@Override
	public void editarPlano(Plano plano) {
		planoDao.update(plano);
	}
	@Override
	public void deletePlano(Plano plano) {
		planoDao.delete(plano.getIdplanos());
	}
	@Override
	public List<Plano> listAllPlanos(){
		return planoDao.listAll();
	}
	
}
