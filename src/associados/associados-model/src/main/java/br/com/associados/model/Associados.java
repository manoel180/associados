package br.com.associados.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class Associados implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idassociados;

	private byte ativo;

	private String cpf;

	private Date dtNascimento;

	private String email;

	private String email2;

	private String name;

	private String passaporte;

	private byte sexo;

	private String telCelular;

	private String telResidencial;

	private FuncoesEclesiasticas funcoesEclesiastica;

	private List<Fotos> fotos;

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

	public FuncoesEclesiasticas getFuncoesEclesiastica() {
		return this.funcoesEclesiastica;
	}

	public void setFuncoesEclesiastica(FuncoesEclesiasticas funcoesEclesiastica) {
		this.funcoesEclesiastica = funcoesEclesiastica;
	}

	public List<Fotos> getFotos() {
		return this.fotos;
	}

	public void setFotos(List<Fotos> fotos) {
		this.fotos = fotos;
	}

	public Fotos addFoto(Fotos foto) {
		getFotos().add(foto);
		foto.setAssociados(this);

		return foto;
	}

	public Fotos removeFoto(Fotos foto) {
		getFotos().remove(foto);
		foto.setAssociados(null);

		return foto;
	}

}