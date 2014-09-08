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
	@Column(unique=true, nullable=false)
	private int idusuarios;

	@Column(nullable=false)
	private byte ativo;

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