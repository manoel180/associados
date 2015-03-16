package br.com.associados.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the tipos_lancamentos database table.
 * 
 */
@Entity
@Table(name="tipos_lancamentos")
public class TiposLancamento extends AbstractBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable=false, length=45)
	private String descricao;

	//bi-directional many-to-one association to Boleto
	@OneToMany(mappedBy="tiposLancamento")
	private List<Boleto> boletos;

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