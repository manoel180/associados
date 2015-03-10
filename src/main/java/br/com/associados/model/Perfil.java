package br.com.associados.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the perfis database table.
 * 
 */
@Entity
@Table(name = "perfis")
@NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p")
public class Perfil implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPerfil;

    private byte ativo;

    @Column(length = 60)
    private String name;

    // bi-directional many-to-many association to Funcionalidade
    @ManyToMany
    @JoinTable(name = "perfis_has_funcionalidades", joinColumns = { @JoinColumn(name = "perfil", nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "funcionalidade", nullable = false) })
    private List<Funcionalidade> funcionalidades;

    // bi-directional many-to-many association to Usuario
    @ManyToMany(mappedBy = "perfis")
    private List<Usuario> usuarios;

    public Perfil() {
    }

    public int getIdPerfil() {
	return this.idPerfil;
    }

    public void setIdPerfil(int id) {
	this.idPerfil = id;
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

    public List<Usuario> getUsuarios() {
	return this.usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
	this.usuarios = usuarios;
    }

}