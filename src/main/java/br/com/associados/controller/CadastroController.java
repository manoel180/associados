package br.com.associados.controller;

import java.util.List;

import br.com.associados.model.Associado;
import br.com.associados.model.Boleto;
import br.com.associados.model.Cidade;
import br.com.associados.model.Estado;
import br.com.associados.model.Funcionalidade;
import br.com.associados.model.FuncoesEclesiastica;
import br.com.associados.model.Lote;
import br.com.associados.model.Perfil;
import br.com.associados.model.Plano;
import br.com.associados.model.Usuario;

public interface CadastroController {


	void salvarAssociado(Associado associado);

	void editarAssociado(Associado associado);

	void deleteAssociado(Associado associado);

	void salvarPlano(Plano plano);
	
	public List<Plano> listAllPlanos();

	void editarPlano(Plano plano);

	void deletePlano(Plano plano);

	void deleteUsuario(Usuario usuario);

	void editarUsuario(Usuario usuario);

	void salvarUsuario(Usuario usuario);

	List<Usuario> listAllUsuarios();

	Usuario getUsuarioById(Long id);

	Usuario getUsuarioByLogin(String login);

	List<FuncoesEclesiastica> listAllFuncaoEclesiastica();

	List<?> listAllPerfis();

	List<Funcionalidade> listAllFuncionalidades();

	void salvarPerfil(Perfil perfil);

	void salvarBoleto(Boleto boleto);

	List<Estado> listAllEstados();


	List<Cidade> listAllCidadeByEstado(Integer id);
	
	void salvarLote(Lote lote);


}
