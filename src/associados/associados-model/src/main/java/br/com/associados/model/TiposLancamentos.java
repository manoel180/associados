package br.com.associados.model;

import java.io.Serializable;


public class TiposLancamentos implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idtiposLancamentos;

	private String descricao;

	public int getIdtiposLancamentos() {
		return this.idtiposLancamentos;
	}

	public void setIdtiposLancamentos(int idtiposLancamentos) {
		this.idtiposLancamentos = idtiposLancamentos;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}