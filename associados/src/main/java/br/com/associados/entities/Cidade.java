package br.com.associados.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cidades")
public class Cidade extends AbstractBean implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String nome;

    private String lat;

    private String lng;

    @ManyToOne
    private Estado estado;

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getLat() {
	return lat;
    }

    public void setLat(String lat) {
	this.lat = lat;
    }

    public String getLng() {
	return lng;
    }

    public void setLng(String lng) {
	this.lng = lng;
    }

    public Estado getEstado() {
	return estado;
    }

    public void setEstado(Estado estado) {
	this.estado = estado;
    }
    
  
}
