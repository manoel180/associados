package br.com.associados.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


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
	private int idassociados;

	private byte ativo;

	private String cpf;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento")
	private Date dtNascimento;

	private String email;

	private String email2;

	private String name;

	private String passaporte;

	private byte sexo;

	@Column(name="tel_celular")
	private String telCelular;

	@Column(name="tel_residencial")
	private String telResidencial;

	//bi-directional many-to-one association to FuncoesEclesiastica
	@ManyToOne
	@JoinColumn(name="idfuncoes_eclesiasticas")
	private FuncoesEclesiastica funcoesEclesiastica;

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

	public byte getAtivo() {
		return this.ativo;
	}

	public void setAtivo(byte ativo) {
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

	public byte getSexo() {
		return this.sexo;
	}

	public void setSexo(byte sexo) {
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

}