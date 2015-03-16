package br.com.associados.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the boletos database table.
 * 
 */
@Embeddable
public class BoletoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	private int idassociados;

	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	private int idplanos;

	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	private int idtiposLancamentos;

	public BoletoPK() {
	}
	public int getIdassociados() {
		return this.idassociados;
	}
	public void setIdassociados(int idassociados) {
		this.idassociados = idassociados;
	}
	public int getIdplanos() {
		return this.idplanos;
	}
	public void setIdplanos(int idplanos) {
		this.idplanos = idplanos;
	}
	public int getIdtiposLancamentos() {
		return this.idtiposLancamentos;
	}
	public void setIdtiposLancamentos(int idtiposLancamentos) {
		this.idtiposLancamentos = idtiposLancamentos;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BoletoPK)) {
			return false;
		}
		BoletoPK castOther = (BoletoPK)other;
		return 
			(this.idassociados == castOther.idassociados)
			&& (this.idplanos == castOther.idplanos)
			&& (this.idtiposLancamentos == castOther.idtiposLancamentos);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idassociados;
		hash = hash * prime + this.idplanos;
		hash = hash * prime + this.idtiposLancamentos;
		
		return hash;
	}
}