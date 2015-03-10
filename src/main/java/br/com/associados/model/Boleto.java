package br.com.associados.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the boletos database table.
 * 
 */
@Entity
@Table(name="boletos")
@NamedQuery(name="Boleto.findAll", query="SELECT b FROM Boleto b")
public class Boleto implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BoletoPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_vencimento")
	private Date dtVencimento;

	@Column(length=255)
	private String observacoes;

	@Column(name="taxa_bancaria")
	private byte taxaBancaria;

	@Column(precision=10, scale=2)
	private BigDecimal valor;

	//bi-directional many-to-one association to Associado
	@ManyToOne
	@JoinColumn(name="idassociados", nullable=false, insertable=false, updatable=false)
	private Associado associado;

	//bi-directional many-to-one association to Plano
	@ManyToOne
	@JoinColumn(name="idplanos", nullable=false, insertable=false, updatable=false)
	private Plano plano;

	//bi-directional many-to-one association to TiposLancamento
	@ManyToOne
	@JoinColumn(name="idtiposLancamentos", nullable=false, insertable=false, updatable=false)
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