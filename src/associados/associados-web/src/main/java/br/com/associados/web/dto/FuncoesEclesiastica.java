package br.com.associados.web.dto;

import java.io.Serializable;
import java.util.List;


public class FuncoesEclesiastica implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idfuncoesEclesiasticas;

	private String descricacao;

	private List<Associado> associados;

	public FuncoesEclesiastica() {
	}

	public int getIdfuncoesEclesiasticas() {
		return this.idfuncoesEclesiasticas;
	}

	public void setIdfuncoesEclesiasticas(int idfuncoesEclesiasticas) {
		this.idfuncoesEclesiasticas = idfuncoesEclesiasticas;
	}

	public String getDescricacao() {
		return this.descricacao;
	}

	public void setDescricacao(String descricacao) {
		this.descricacao = descricacao;
	}

	public List<Associado> getAssociados() {
		return this.associados;
	}

	public void setAssociados(List<Associado> associados) {
		this.associados = associados;
	}

	public Associado addAssociado(Associado associado) {
		getAssociados().add(associado);
		associado.setFuncoesEclesiastica(this);

		return associado;
	}

	public Associado removeAssociado(Associado associado) {
		getAssociados().remove(associado);
		associado.setFuncoesEclesiastica(null);

		return associado;
	}

}