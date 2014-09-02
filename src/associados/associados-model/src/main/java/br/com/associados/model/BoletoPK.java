package br.com.associados.model;

import java.io.Serializable;

/**
 * The primary key class for the boletos database table.
 * 
 */
public class BoletoPK implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idassociados;

	private int idplanos;

	private int idtiposLancamentos;

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