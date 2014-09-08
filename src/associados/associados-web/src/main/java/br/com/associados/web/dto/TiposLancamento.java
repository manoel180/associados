package br.com.associados.web.dto;

import java.io.Serializable;
import java.util.List;


public class TiposLancamento implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idtiposLancamentos;

	private String descricao;

	private List<Boleto> boletos;

	public TiposLancamento() {
	}

	public int getIdtiposLancamentos() {
		return this.idtiposLancamentos;
	}

	public void setIdtiposLancamentos(int idtiposLancamentos) {
		this.idtiposLancamentos = idtiposLancamentos;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Boleto> getBoletos() {
		return this.boletos;
	}

	public void setBoletos(List<Boleto> boletos) {
		this.boletos = boletos;
	}

	public Boleto addBoleto(Boleto boleto) {
		getBoletos().add(boleto);
		boleto.setTiposLancamento(this);

		return boleto;
	}

	public Boleto removeBoleto(Boleto boleto) {
		getBoletos().remove(boleto);
		boleto.setTiposLancamento(null);

		return boleto;
	}

}