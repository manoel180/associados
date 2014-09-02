package br.com.associados.model;

import java.io.Serializable;


public class Fotos implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idfotos;

	private byte[] file;

	private String nome;

	private Associados associado;

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

	public Associados getAssociados() {
		return this.associado;
	}

	public void setAssociados(Associados associado) {
		this.associado = associado;
	}

}