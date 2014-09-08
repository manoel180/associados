package br.com.associados.web.dto;

import java.io.Serializable;
import java.util.List;


public class Funcionalidade implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private String nome;

	private List<Perfil> perfis;

	public Funcionalidade() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Perfil> getPerfis() {
		return this.perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

}