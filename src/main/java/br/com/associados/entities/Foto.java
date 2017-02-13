package br.com.associados.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the fotos database table.
 * 
 */
@Entity
@Table(name="fotos")
public class Foto extends AbstractBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Lob
	private byte[] file;

	@Column(nullable=false, length=60)
	private String nome;

	//bi-directional many-to-one association to Associado
	@ManyToOne
	@JoinColumn(name="idassociados", nullable=false)
	private Associado associado;

	public Foto() {
	}

	public byte[] getFile() {
		return this.file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Associado getAssociado() {
		return this.associado;
	}

	public void setAssociado(Associado associado) {
		this.associado = associado;
	}

}