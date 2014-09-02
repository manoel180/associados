package br.com.associados.model;

import java.io.Serializable;
import java.util.List;


public class Usuarios implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idusuarios;

	private Boolean ativo;

	private String login;

	private String senha;

	private List<Perfis> perfis;

	public Long getIdusuarios() {
		return this.idusuarios;
	}

	public void setIdusuarios(Long idusuarios) {
		this.idusuarios = idusuarios;
	}

	public Boolean getAtivo() {
		return this.ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Perfis> getPerfis() {
		return this.perfis;
	}

	public void setPerfis(List<Perfis> perfis) {
		this.perfis = perfis;
	}

}