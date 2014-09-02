package br.com.associados.web.dto;

import java.util.List;

public class Usuario{
	
	private Long idusuarios;

	private Boolean ativo;

	private String login;

	private String senha;
	
	private List<Perfil> perfis;

	/**
	 * @return the idusuarios
	 */
	public Long getIdusuarios() {
		return idusuarios;
	}

	/**
	 * @param idusuarios the idusuarios to set
	 */
	public void setIdusuarios(Long idusuarios) {
		this.idusuarios = idusuarios;
	}

	/**
	 * @return the ativo
	 */
	public Boolean getAtivo() {
		return ativo;
	}

	/**
	 * @param ativo the ativo to set
	 */
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}
}
