package br.com.associados.model;

import java.io.Serializable;
import java.util.List;

public class Perfis implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private byte ativo;

	private String name;

	private List<Funcionalidades> funcionalidades;

//	//bi-directional many-to-many association to Usuario
//	@ManyToMany(mappedBy="perfis")
//	private List<Usuario> usuarios;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte getAtivo() {
		return this.ativo;
	}

	public void setAtivo(byte ativo) {
		this.ativo = ativo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Funcionalidades> getFuncionalidades() {
		return this.funcionalidades;
	}

	public void setFuncionalidades(List<Funcionalidades> funcionalidades) {
		this.funcionalidades = funcionalidades;
	}

}