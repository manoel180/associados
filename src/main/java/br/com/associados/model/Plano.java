package br.com.associados.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the planos database table.
 * 
 */
@Entity
@Table(name="planos")
@NamedQuery(name="Plano.findAll", query="SELECT p FROM Plano p")
public class Plano implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idplanos;

	private byte ativo;

	@Column(length=48)
	private String description;

	//bi-directional many-to-one association to Boleto
	@OneToMany(mappedBy="plano")
	private List<Boleto> boletos;

	public Plano() {
	}

	public int getIdplanos() {
		return this.idplanos;
	}

	public void setIdplanos(int idplanos) {
		this.idplanos = idplanos;
	}

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