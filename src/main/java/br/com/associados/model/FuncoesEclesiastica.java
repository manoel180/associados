package br.com.associados.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the funcoes_eclesiasticas database table.
 * 
 */
@Entity
@Table(name="funcoes_eclesiasticas")
public class FuncoesEclesiastica extends AbstractBean implements Serializable {
	private static final long serialVersionUID = 1L;

	

	@Column(nullable=false, length=45)
	private String descricao;

	//bi-directional many-to-one association to Associado
	@OneToMany(mappedBy="funcoesEclesiastica")
	private List<Associado> associados;

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricacao(String descricao) {
		this.descricao = descricao;
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