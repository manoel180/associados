package br.com.associados.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the fotos database table.
 * 
 */
@Entity
@Table(name="fotos")
@NamedQuery(name="Foto.findAll", query="SELECT f FROM Foto f")
public class Foto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idfotos;

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

	public int getIdfotos() {
		return this.idfotos;
	}

	public void setIdfotos(int idfotos) {
		this.idfotos = idfotos;
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