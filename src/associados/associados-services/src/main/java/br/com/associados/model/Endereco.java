package br.com.associados.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the enderecos database table.
 * 
 */
@Entity
@Table(name="enderecos")
@NamedQuery(name="Endereco.findAll", query="SELECT e FROM Endereco e")
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idEndereco;

	public Endereco() {
	}

	public int getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}

	
}