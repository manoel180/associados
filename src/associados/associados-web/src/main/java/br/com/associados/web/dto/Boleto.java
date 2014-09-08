package br.com.associados.web.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the boletos database table.
 * 
 */
public class Boleto implements Serializable {
	private static final long serialVersionUID = 1L;

	private BoletoPK id;

	private Date dtVencimento;

	private String observacoes;

	private byte taxaBancaria;

	private BigDecimal valor;

	private Associado associado;

	private Plano plano;

	private TiposLancamento tiposLancamento;

	public Boleto() {
	}

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

	public Associado getAssociado() {
		return this.associado;
	}

	public void setAssociado(Associado associado) {
		this.associado = associado;
	}

	public Plano getPlano() {
		return this.plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public TiposLancamento getTiposLancamento() {
		return this.tiposLancamento;
	}

	public void setTiposLancamento(TiposLancamento tiposLancamento) {
		this.tiposLancamento = tiposLancamento;
	}

}