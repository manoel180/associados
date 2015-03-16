package br.com.associados.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the planos database table.
 * 
 */
@Entity
@Table(name="planos")
public class Plano extends AbstractBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private byte ativo;

	@Column(length=48)
	private String description;

	//bi-directional many-to-one association to Boleto
	@OneToMany(mappedBy="plano")
	private List<Boleto> boletos;

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