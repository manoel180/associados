package br.com.associados.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the perfis_has_funcionalidades database table.
 * 
 */
@Entity
@Table(name="perfis_has_funcionalidades")
@NamedQuery(name="PerfisHasFuncionalidade.findAll", query="SELECT p FROM PerfisHasFuncionalidade p")
public class PerfisHasFuncionalidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PerfisHasFuncionalidadePK id;

	//bi-directional many-to-one association to Perfil
	@ManyToOne
	@JoinColumn(name="perfis_id", nullable=false, insertable=false, updatable=false)
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