package br.com.associados.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * The persistent class for the funcionalidades database table.
 * 
 */
@Entity
@Table(name="funcionalidades")
public class Funcionalidade extends AbstractBean implements Serializable {
    private static final long serialVersionUID = 151261933548719046L;


	@Column
	private String nome;
	
//	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "perfilFuncionalidades")
//	private Set<Perfil> perfis;


	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

//	public Set<Perfil> getPerfis() {
//	    return perfis;
//	}
//
//	public void setPerfis(Set<Perfil> perfis) {
//	    this.perfis = perfis;
//	}


}