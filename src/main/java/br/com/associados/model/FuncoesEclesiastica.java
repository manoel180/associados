package br.com.associados.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	@Column(name="idfuncoes_eclesiasticas", unique=true, nullable=false)
	private int idfuncoesEclesiasticas;

	@Column(nullable=false, length=45)
	private String descricao;

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