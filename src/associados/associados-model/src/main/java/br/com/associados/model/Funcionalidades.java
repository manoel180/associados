package br.com.associados.model;

import java.io.Serializable;
import java.util.List;

public class Funcionalidades implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	private String nome;

	private List<Perfis> perfis;

	public Funcionalidades() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Perfis> getPerfis() {
		return this.perfis;
	}

	public void setPerfis(List<Perfis> perfis) {
		this.perfis = perfis;
	}

}