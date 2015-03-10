package br.com.associados.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipos_lancamentos database table.
 * 
 */
@Entity
@Table(name="tipos_lancamentos")
@NamedQuery(name="TiposLancamento.findAll", query="SELECT t FROM TiposLancamento t")
public class TiposLancamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idtiposLancamentos;

	@Column(nullable=false, length=45)
	private String descricao;

	//bi-directional many-to-one association to Boleto
	@OneToMany(mappedBy="tiposLancamento")
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