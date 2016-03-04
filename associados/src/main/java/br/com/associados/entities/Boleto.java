package br.com.associados.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the boletos database table.
 * 
 */
@Entity
@Table(name="boletos")
public class Boleto extends AbstractBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_vencimento")
	private Date dtVencimento;

	@Column(length=255)
	private String observacoes;

	@Column(name="taxa_bancaria")
	private byte taxaBancaria;

	@Column(precision=10, scale=2)
	private BigDecimal valor;
	
	@ManyToOne
	@JoinColumn(name="idLote",insertable = true, updatable=true )
	private Lote lote;
	
	//bi-directional many-to-one association to Associado
	@ManyToOne
	@JoinColumn(name="idassociados", nullable=true, insertable=false, updatable=false)
	private Associado associado;

	//bi-directional many-to-one association to Plano
	@ManyToOne
	@JoinColumn(name="idplanos", nullable=true, insertable=false, updatable=false)
	private Plano plano;

	//bi-directional many-to-one association to TiposLancamento
	@ManyToOne
	@JoinColumn(name="idtiposLancamentos", nullable=true, insertable=false, updatable=false)
	private TiposLancamento tiposLancamento;

	public Boleto() {
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

	/**
	 * @return the lote
	 */
	public Lote getLote() {
	    return lote;
	}

	/**
	 * @param lote the lote to set
	 */
	public void setLote(Lote lote) {
	    this.lote = lote;
	}

}