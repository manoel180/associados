package br.com.associados.web.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Associado implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idassociados;

	private Boolean ativo;

	private String cpf;

	private Date dtNascimento;

	private String email;

	private String email2;

	private String name;

	private String passaporte;

	private Sexo sexo;

	private String telCelular;

	private String telResidencial;

	// bi-directional many-to-one association to FuncoesEclesiastica
	private FuncoesEclesiastica funcoesEclesiastica;

	// bi-directional many-to-one association to Boleto
	private List<Boleto> boletos;

	// bi-directional many-to-one association to Foto
	private List<Foto> fotos;

	/**
	 * @return the idassociados
	 */
	public int getIdassociados() {
		return idassociados;
	}

	/**
	 * @param idassociados the idassociados to set
	 */
	public void setIdassociados(int idassociados) {
		this.idassociados = idassociados;
	}

	/**
	 * @return the ativo
	 */
	public Boolean getAtivo() {
		return ativo;
	}

	/**
	 * @param ativo the ativo to set
	 */
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the dtNascimento
	 */
	public Date getDtNascimento() {
		return dtNascimento;
	}

	/**
	 * @param dtNascimento the dtNascimento to set
	 */
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the email2
	 */
	public String getEmail2() {
		return email2;
	}

	/**
	 * @param email2 the email2 to set
	 */
	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the passaporte
	 */
	public String getPassaporte() {
		return passaporte;
	}

	/**
	 * @param passaporte the passaporte to set
	 */
	public void setPassaporte(String passaporte) {
		this.passaporte = passaporte;
	}

	/**
	 * @return the sexo
	 */
	public Sexo getSexo() {
		return sexo;
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	/**
	 * @return the telCelular
	 */
	public String getTelCelular() {
		return telCelular;
	}

	/**
	 * @param telCelular the telCelular to set
	 */
	public void setTelCelular(String telCelular) {
		this.telCelular = telCelular;
	}

	/**
	 * @return the telResidencial
	 */
	public String getTelResidencial() {
		return telResidencial;
	}

	/**
	 * @param telResidencial the telResidencial to set
	 */
	public void setTelResidencial(String telResidencial) {
		this.telResidencial = telResidencial;
	}

	/**
	 * @return the funcoesEclesiastica
	 */
	public FuncoesEclesiastica getFuncoesEclesiastica() {
		return funcoesEclesiastica;
	}

	/**
	 * @param funcoesEclesiastica the funcoesEclesiastica to set
	 */
	public void setFuncoesEclesiastica(FuncoesEclesiastica funcoesEclesiastica) {
		this.funcoesEclesiastica = funcoesEclesiastica;
	}

	/**
	 * @return the boletos
	 */
	public List<Boleto> getBoletos() {
		return boletos;
	}

	/**
	 * @param boletos the boletos to set
	 */
	public void setBoletos(List<Boleto> boletos) {
		this.boletos = boletos;
	}

	/**
	 * @return the fotos
	 */
	public List<Foto> getFotos() {
		return fotos;
	}

	/**
	 * @param fotos the fotos to set
	 */
	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}

}