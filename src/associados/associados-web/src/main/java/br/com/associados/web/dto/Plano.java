package br.com.associados.web.dto;

import java.io.Serializable;
import java.util.List;


public class Plano implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idplanos;

	private byte ativo;

	private String description;

	private List<Boleto> boletos;

	public Plano() {
	}

	public int getIdplanos() {
		return this.idplanos;
	}

	public void setIdplanos(int idplanos) {
		this.idplanos = idplanos;
	}

	public byte getAtivo() {
		return this.ativo;
	}

	public void setAtivo(byte ativo) {
		this.ativo = ativo;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Boleto> getBoletos() {
		return this.boletos;
	}

	public void setBoletos(List<Boleto> boletos) {
		this.boletos = boletos;
	}

	public Boleto addBoleto(Boleto boleto) {
		getBoletos().add(boleto);
		boleto.setPlano(this);

		return boleto;
	}

	public Boleto removeBoleto(Boleto boleto) {
		getBoletos().remove(boleto);
		boleto.setPlano(null);

		return boleto;
	}

}