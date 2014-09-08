package br.com.associados.web.dto;

import java.io.Serializable;

public class PerfisHasFuncionalidade implements Serializable {
	private static final long serialVersionUID = 1L;

	private PerfisHasFuncionalidadePK id;

	private Perfil perfi;

	public PerfisHasFuncionalidade() {
	}

	public PerfisHasFuncionalidadePK getId() {
		return this.id;
	}

	public void setId(PerfisHasFuncionalidadePK id) {
		this.id = id;
	}

	public Perfil getPerfi() {
		return this.perfi;
	}

	public void setPerfi(Perfil perfi) {
		this.perfi = perfi;
	}

}