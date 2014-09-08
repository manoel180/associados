package br.com.associados.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the perfis_has_funcionalidades database table.
 * 
 */
@Embeddable
public class PerfisHasFuncionalidadePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="perfis_id", insertable=false, updatable=false, unique=true, nullable=false)
	private String perfisId;

	@Column(name="funcionalidades_id", unique=true, nullable=false)
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