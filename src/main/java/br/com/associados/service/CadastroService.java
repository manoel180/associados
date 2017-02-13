package br.com.associados.service;

import java.util.List;

import br.com.associados.entities.Associado;
import br.com.associados.entities.Boleto;
import br.com.associados.entities.Cidade;
import br.com.associados.entities.DadosBoleto;
import br.com.associados.entities.Estado;
import br.com.associados.entities.Funcionalidade;
import br.com.associados.entities.FuncoesEclesiastica;
import br.com.associados.entities.Lote;
import br.com.associados.entities.Perfil;
import br.com.associados.entities.Plano;
import br.com.associados.entities.Usuario;

public interface CadastroService {


	void salvarAssociado(Associado associado);


	void deleteAssociado(Associado associado);

	void salvarPlano(Plano plano);
	
	public List<Plano> listAllPlanos();


	void deletePlano(Plano plano);

	void deleteUsuario(Usuario usuario);

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

	List<Cidade> listAllCidadeByEstado(Estado estado);

	void salvarLote(Lote lote);

	void salvarDadosBoleto(DadosBoleto dadosBoleto);

	DadosBoleto getDadosBoleto();


}
