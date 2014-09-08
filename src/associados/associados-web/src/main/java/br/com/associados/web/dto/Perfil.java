package br.com.associados.web.dto;

import java.io.Serializable;
import java.util.List;


public class Perfil implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	private byte ativo;

	private String name;

	private List<Funcionalidade> funcionalidades;

	private List<PerfisHasFuncionalidade> perfisHasFuncionalidades;

	private List<Usuario> usuarios;

	public Perfil() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
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

	public List<Funcionalidade> getFuncionalidades() {
		return this.funcionalidades;
	}

	public void setFuncionalidades(List<Funcionalidade> funcionalidades) {
		this.funcionalidades = funcionalidades;
	}

	public List<PerfisHasFuncionalidade> getPerfisHasFuncionalidades() {
		return this.perfisHasFuncionalidades;
	}

	public void setPerfisHasFuncionalidades(List<PerfisHasFuncionalidade> perfisHasFuncionalidades) {
		this.perfisHasFuncionalidades = perfisHasFuncionalidades;
	}

	public PerfisHasFuncionalidade addPerfisHasFuncionalidade(PerfisHasFuncionalidade perfisHasFuncionalidade) {
		getPerfisHasFuncionalidades().add(perfisHasFuncionalidade);
		perfisHasFuncionalidade.setPerfi(this);

		return perfisHasFuncionalidade;
	}

	public PerfisHasFuncionalidade removePerfisHasFuncionalidade(PerfisHasFuncionalidade perfisHasFuncionalidade) {
		getPerfisHasFuncionalidades().remove(perfisHasFuncionalidade);
		perfisHasFuncionalidade.setPerfi(null);

		return perfisHasFuncionalidade;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}