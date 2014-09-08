package br.com.associados.web.dto;

import java.io.Serializable;

public class PerfisHasFuncionalidadePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String perfisId;

	private String funcionalidadesId;

	public PerfisHasFuncionalidadePK() {
	}
	public String getPerfisId() {
		return this.perfisId;
	}
	public void setPerfisId(String perfisId) {
		this.perfisId = perfisId;
	}
	public String getFuncionalidadesId() {
		return this.funcionalidadesId;
	}
	public void setFuncionalidadesId(String funcionalidadesId) {
		this.funcionalidadesId = funcionalidadesId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PerfisHasFuncionalidadePK)) {
			return false;
		}
		PerfisHasFuncionalidadePK castOther = (PerfisHasFuncionalidadePK)other;
		return 
			this.perfisId.equals(castOther.perfisId)
			&& this.funcionalidadesId.equals(castOther.funcionalidadesId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.perfisId.hashCode();
		hash = hash * prime + this.funcionalidadesId.hashCode();
		
		return hash;
	}
}