package br.com.associados.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Boletos implements Serializable {
	private static final long serialVersionUID = 1L;

	private BoletoPK id;

	private Date dtVencimento;

	private String observacoes;

	private byte taxaBancaria;

	private BigDecimal valor;

	public BoletoPK getId() {
		return this.id;
	}

	public void setId(BoletoPK id) {
		this.id = id;
	}

	public Date getDtVencimento() {
		return this.dtVencimento;
	}

	public void setDtVencimento(Date dtVencimento) {
		this.dtVencimento = dtVencimento;
	}

	public String getObservacoes() {
		return this.observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public byte getTaxaBancaria() {
		return this.taxaBancaria;
	}

	public void setTaxaBancaria(byte taxaBancaria) {
		this.taxaBancaria = taxaBancaria;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}