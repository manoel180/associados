package br.com.associados.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/**
 * The persistent class for the perfis database table.
 * 
 */
@Entity
@Table(name = "perfis")
public class Perfil extends AbstractBean implements Serializable {
    private static final long serialVersionUID = 1L;


    private Boolean ativo;

    @Column(length = 60)
    private String name;

    @ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.DETACH)
    @JoinTable(name="perfis_has_funcionalidades",
			   joinColumns=@JoinColumn(name="PERFIL_ID", nullable = false, updatable = false),
			   inverseJoinColumns={@JoinColumn( name="FUNCIONALIDADE_ID", nullable = false, updatable = false)})
    private List<Funcionalidade> perfilFuncionalidades;

    public Boolean getAtivo() {
	return this.ativo;
    }

    public void setAtivo(Boolean ativo) {
	this.ativo = ativo;
    }

    public String getName() {
	return this.name;
    }

    public void setName(String name) {
	this.name = name;
    }


    public List<Funcionalidade> getPerfilFuncionalidades() {
	return perfilFuncionalidades;
    }

    public void setPerfilFuncionalidades(List<Funcionalidade> perfilFuncionalidades) {
	this.perfilFuncionalidades = perfilFuncionalidades;
    }

}