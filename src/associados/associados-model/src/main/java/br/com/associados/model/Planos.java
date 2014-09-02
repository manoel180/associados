package br.com.associados.model;

import java.io.Serializable;


public class Planos implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idplanos;
	
	private Byte ativo;

	private String description;


	public int getIdplanos() {
		return this.idplanos;
	}

	public void setIdplanos(int idplanos) {
		this.idplanos = idplanos;
	}

	public Byte getAtivo() {
		return this.ativo;
	}

	public void setAtivo(Byte ativo) {
		this.ativo = ativo;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}