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
	private int idtiposLancamentos;

	private String descricao;

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

}