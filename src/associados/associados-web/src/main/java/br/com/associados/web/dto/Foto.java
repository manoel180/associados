package br.com.associados.web.dto;

import java.io.Serializable;

public class Foto implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idfotos;

	private byte[] file;

	private String nome;

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