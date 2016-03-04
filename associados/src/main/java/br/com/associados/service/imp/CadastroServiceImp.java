package br.com.associados.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.associados.entities.Associado;
import br.com.associados.entities.Boleto;
import br.com.associados.entities.Cidade;
import br.com.associados.entities.Estado;
import br.com.associados.entities.Funcionalidade;
import br.com.associados.entities.FuncoesEclesiastica;
import br.com.associados.entities.Lote;
import br.com.associados.entities.Perfil;
import br.com.associados.entities.Plano;
import br.com.associados.entities.Usuario;
import br.com.associados.repository.AssociadoRepository;
import br.com.associados.repository.BoletoRepository;
import br.com.associados.repository.CidadeRepository;
import br.com.associados.repository.EstadoRepository;
import br.com.associados.repository.FuncaoEclesiasticaRepository;
import br.com.associados.repository.FuncionalidadeRepository;
import br.com.associados.repository.LoteRepository;
import br.com.associados.repository.PerfilRepository;
import br.com.associados.repository.PlanoRepository;
import br.com.associados.repository.UsuarioRepository;
import br.com.associados.service.CadastroService;

@Service
@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
public class CadastroServiceImp implements CadastroService{

	@Autowired
	PlanoRepository planoRepository;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	AssociadoRepository associadoRepository;

	@Autowired
	FuncaoEclesiasticaRepository funcaoEclesiasticaRepository;

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	PerfilRepository perfilRepository;
	
	@Autowired
	FuncionalidadeRepository funcionalidadeRepository; 
	
	@Autowired
	BoletoRepository boletoRepository; 
	
	@Autowired
	LoteRepository loteRepository; 
	/**
	 * Associados
	 */
	@Override
	public void salvarAssociado(Associado associado) {
		associadoRepository.save(associado);
	}
	
	@Override
	public void deleteAssociado(Associado associado) {
		associadoRepository.delete(associado.getId());
	}
	
	
	/**
	 * Funcao Eclesiastica
	 */
	@Override
	public List<FuncoesEclesiastica> listAllFuncaoEclesiastica() {
		return (List<FuncoesEclesiastica>) funcaoEclesiasticaRepository.findAll();
	}
	
	/**
	 * Usuario
	 */
	@Override
	public void salvarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	@Override
	public void deleteUsuario(Usuario usuario) {
		usuarioRepository.delete(usuario.getId());
	}
	
	@Override
	public List<Usuario> listAllUsuarios() {
		return (List<Usuario>) usuarioRepository.findAll();
	}
	
	@Override
	public Usuario getUsuarioById(Long id) {
		return usuarioRepository.findOne(id);
	}
	@Override
	public Usuario getUsuarioByLogin(String login) {
		return usuarioRepository.getUsuarioByLogin(login);
	}
	
	
	/**
	 * Planos
	 */
	@Override
	public void salvarPlano(Plano plano) {
		planoRepository.save(plano);
	}
	
	@Override
	public void deletePlano(Plano plano) {
		planoRepository.delete(plano.getId());
	}
	@Override
	public List<Plano> listAllPlanos(){
		return (List<Plano>) planoRepository.findAll();
	}
	
	/**
	 * Perfis
	 */
	@Override
	@Transactional
	public void salvarPerfil(Perfil perfil) {
	 	perfilRepository.save(perfil);
	    
	}
	@Override
	public List<?> listAllPerfis() {
	    return (List<?>) perfilRepository.findAll();
	}
	
	/**
	 * Funcionalidades
	 */
	@Transactional(readOnly=true)
	@Override
	public List<Funcionalidade> listAllFuncionalidades() {
	    return (List<Funcionalidade>) funcionalidadeRepository.findAll();
	}
	
	/**
	 * Configuracao Boleto
	 * @return 
	 */
	@Override
	public void salvarBoleto(Boleto boleto) {
	     boletoRepository.save(boleto);
	}
	
	/**
	 * Estados
	 */
	@Override
	public List<Estado> listAllEstados() {
	    return (List<Estado>) estadoRepository.findAll();
	}

	/**
	 * Cidades
	 */
	@Transactional(readOnly=true)
	@Override
	public List<Cidade> listAllCidadeByEstado(Estado estado) {
	    return cidadeRepository.findByEstado(estado);
	}
	
	@Override
	public void salvarLote(Lote lote) {
	    loteRepository.save(lote);
	}
	
}
