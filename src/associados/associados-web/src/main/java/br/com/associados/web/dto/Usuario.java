package br.com.associados.web.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Usuario {
	
	@XmlElement
	private Long idusuarios;

	@XmlElement
	private byte ativo;

	@XmlElement
	private String login;

	@XmlElement
	private String senha;

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
	public byte getAtivo() {
		return ativo;
	}

	/**
	 * @param ativo the ativo to set
	 */
	public void setAtivo(byte ativo) {
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
}
