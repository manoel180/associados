package br.com.associados.model;

import java.io.Serializable;
import java.util.List;


public class FuncoesEclesiasticas implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idfuncoesEclesiasticas;

	private String descricacao;

	private List<Associados> associados;

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

	public List<Associados> getAssociados() {
		return this.associados;
	}

	public void setAssociados(List<Associados> associados) {
		this.associados = associados;
	}

}