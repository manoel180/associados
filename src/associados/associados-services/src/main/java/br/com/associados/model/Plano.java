package br.com.associados.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the planos database table.
 * 
 */
@Entity
@Table(name="planos")
@XmlRootElement
public class Plano implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@XmlElement
	private int idplanos;
	
	@XmlElement
	private Byte ativo;

	@XmlElement
	private String description;


	public int getIdplanos() {
		return this.idplanos;
	}

	public void setIdplanos(int idplanos) {
		this.idplanos = idplanos;
	}

	public Byte getAtivo() {
		return this.ativo;
	}

	public void setAtivo(Byte ativo) {
		this.ativo = ativo;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}