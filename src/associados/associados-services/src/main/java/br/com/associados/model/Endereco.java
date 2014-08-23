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
	private String id;

	public Endereco() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

}