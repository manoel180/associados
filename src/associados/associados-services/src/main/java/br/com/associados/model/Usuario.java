package br.com.associados.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idusuarios;

	private byte ativo;

	private String login;

	private String senha;

	//bi-directional many-to-many association to Perfil
	@ManyToMany
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

	public int getIdusuarios() {
		return this.idusuarios;
	}

	public void setIdusuarios(int idusuarios) {
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