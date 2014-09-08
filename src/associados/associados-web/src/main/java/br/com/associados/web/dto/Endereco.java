package br.com.associados.web.dto;

import java.io.Serializable;


public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	public Endereco() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

}