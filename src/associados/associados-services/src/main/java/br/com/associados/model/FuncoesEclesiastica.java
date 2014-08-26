package br.com.associados.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the funcoes_eclesiasticas database table.
 * 
 */
@Entity
@Table(name="funcoes_eclesiasticas")
@NamedQuery(name="FuncoesEclesiastica.findAll", query="SELECT f FROM FuncoesEclesiastica f")
public class FuncoesEclesiastica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idfuncoes_eclesiasticas")
	private int idfuncoesEclesiasticas;

	private String descricacao;

	//bi-directional many-to-one association to Associado
	@OneToMany(mappedBy="funcoesEclesiastica")
	private List<Associado> associados;

	public FuncoesEclesiastica() {
	}

	public int getIdfuncoesEclesiasticas() {
		return this.idfuncoesEclesiasticas;
	}

	public void setIdfuncoesEclesiasticas(int idfuncoesEclesiasticas) {
		this.idfuncoesEclesiasticas = idfuncoesEclesiasticas;
	}

	public String getDescricacao() {
		return this.descricacao;
	}

	public void setDescricacao(String descricacao) {
		this.descricacao = descricacao;
	}

	public List<Associado> getAssociados() {
		return this.associados;
	}

	public void setAssociados(List<Associado> associados) {
		this.associados = associados;
	}

	public Associado addAssociado(Associado associado) {
		getAssociados().add(associado);
		associado.setFuncoesEclesiastica(this);

		return associado;
	}

	public Associado removeAssociado(Associado associado) {
		getAssociados().remove(associado);
		associado.setFuncoesEclesiastica(null);

		return associado;
	}

}