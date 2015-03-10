package br.com.associados.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the associados database table.
 * 
 */
@Entity
@Table(name="associados")
@NamedQuery(name="Associado.findAll", query="SELECT a FROM Associado a")
public class Associado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idassociados;

	private Boolean ativo;

	@Column(length=13)
	private String cpf;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento", nullable=false)
	private Date dtNascimento;

	@Column(length=60)
	private String email;

	@Column(length=60)
	private String email2;

	@Column(length=60)
	private String name;

	@Column(length=45)
	private String passaporte;

	@Enumerated(EnumType.ORDINAL)
	private Sexo sexo;

	@Column(name="tel_celular", length=11)
	private String telCelular;

	@Column(name="tel_residencial", length=11)
	private String telResidencial;
	
	@ManyToOne
	private Endereco endereco;

	//bi-directional many-to-one association to FuncoesEclesiastica
	@ManyToOne
	@JoinColumn(name="idfuncoes_eclesiasticas", nullable=false)
	private FuncoesEclesiastica funcoesEclesiastica;

	//bi-directional many-to-one association to Boleto
	@OneToMany(mappedBy="associado")
	private List<Boleto> boletos;

	//bi-directional many-to-one association to Foto
	@OneToMany(mappedBy="associado")
	private List<Foto> fotos;

	public Associado() {
	}

	public int getIdassociados() {
		return this.idassociados;
	}

	public void setIdassociados(int idassociados) {
		this.idassociados = idassociados;
	}

	public Boolean getAtivo() {
		return this.ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDtNascimento() {
		return this.dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail2() {
		return this.email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassaporte() {
		return this.passaporte;
	}

	public void setPassaporte(String passaporte) {
		this.passaporte = passaporte;
	}

	public Sexo getSexo() {
		return this.sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getTelCelular() {
		return this.telCelular;
	}

	public void setTelCelular(String telCelular) {
		this.telCelular = telCelular;
	}

	public String getTelResidencial() {
		return this.telResidencial;
	}

	public void setTelResidencial(String telResidencial) {
		this.telResidencial = telResidencial;
	}

	public FuncoesEclesiastica getFuncoesEclesiastica() {
		return this.funcoesEclesiastica;
	}

	public void setFuncoesEclesiastica(FuncoesEclesiastica funcoesEclesiastica) {
		this.funcoesEclesiastica = funcoesEclesiastica;
	}

	public List<Boleto> getBoletos() {
		return this.boletos;
	}

	public void setBoletos(List<Boleto> boletos) {
		this.boletos = boletos;
	}

	public Boleto addBoleto(Boleto boleto) {
		getBoletos().add(boleto);
		boleto.setAssociado(this);

		return boleto;
	}

	public Boleto removeBoleto(Boleto boleto) {
		getBoletos().remove(boleto);
		boleto.setAssociado(null);

		return boleto;
	}

	public List<Foto> getFotos() {
		return this.fotos;
	}

	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}

	public Foto addFoto(Foto foto) {
		getFotos().add(foto);
		foto.setAssociado(this);

		return foto;
	}

	public Foto removeFoto(Foto foto) {
		getFotos().remove(foto);
		foto.setAssociado(null);

		return foto;
	}

        public Endereco getEndereco() {
                return endereco;
        }

        public void setEndereco(Endereco endereco) {
                this.endereco = endereco;
        }

}