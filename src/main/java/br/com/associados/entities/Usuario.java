package br.com.associados.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
public class Usuario extends AbstractBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable=false)
	private boolean ativo;

	@Column(nullable=false, length=60)
	private String nome;
	
	@Column(nullable=false, length=10)
	private String login;

	@Column(nullable=false, length=45)
	private String senha;

	//bi-directional many-to-many association to Perfil
	@ManyToMany
	@JoinTable(
		name="perfis_has_usuarios"
		, joinColumns={
			@JoinColumn(name="usuarios_idusuarios", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="perfis_id", nullable=false)
			}
		)
	private List<Perfil> perfis;

	public Usuario() {
	}

	public boolean getAtivo() {
		return this.ativo;
	}

	public void setAtivo(boolean ativo) {
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

	public String getNome() {
	    return nome;
	}

	public void setNome(String nome) {
	    this.nome = nome;
	}

}