package br.com.associados.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the funcionalidades database table.
 * 
 */
@Entity
@Table(name="funcionalidades")
@NamedQuery(name="Funcionalidade.findAll", query="SELECT f FROM Funcionalidade f")
public class Funcionalidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=255)
	private String nome;

	//bi-directional many-to-many association to Perfil
	@ManyToMany
	@JoinTable(
		name="perfis_has_funcionalidades"
		, joinColumns={
			@JoinColumn(name="funcionalidades_id", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="perfis_id", nullable=false)
			}
		)
	private List<Perfil> perfis;

	public Funcionalidade() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Perfil> getPerfis() {
		return this.perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

}