package br.com.associados.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@XmlRootElement(name="user")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@XmlElement
	private Long idusuarios;

	@XmlElement
	private byte ativo;

	@XmlElement
	private String login;

	@XmlElement
	private String senha;

	//bi-directional many-to-many association to Perfil
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		name="perfis_has_usuarios"
		, joinColumns={
			@JoinColumn(name="usuarios_idusuarios")
			}
		, inverseJoinColumns={
			@JoinColumn(name="perfis_id")
			}
		)
	private List<Perfil> perfis;

	public Usuario() {
	}

	public Long getIdusuarios() {
		return this.idusuarios;
	}

	public void setIdusuarios(Long idusuarios) {
		this.idusuarios = idusuarios;
	}

	public byte getAtivo() {
		return this.ativo;
	}

	public void setAtivo(byte ativo) {
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

	public List<Perfil> getPerfis() {
		return this.perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

}