package br.com.associados.boleto.util;

import java.math.BigDecimal;
import java.util.Date;


public class LoteUtil {
	private Integer qtdParcela;

	public Integer getQtdParcela() {
		return qtdParcela;
	}

	public void setQtdParcela(Integer qtdParcela) {
		this.qtdParcela = qtdParcela;
	}

	public Integer getQtdLote() {
		return qtdLote;
	}

	public void setQtdLote(Integer qtdLote) {
		this.qtdLote = qtdLote;
	}

	public Date getDtVencimento() {
		return dtVencimento;
	}

	public void setDtVencimento(Date dtVencimento) {
		this.dtVencimento = dtVencimento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	private Integer qtdLote;

	private Date dtVencimento;

	private BigDecimal valor;

}
