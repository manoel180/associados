package br.com.associados.web.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Associado extends br.com.associados.model.Associado implements Serializable{
	private static final long serialVersionUID = 1L;

	@Override
	public int getIdassociados() {
		return getIdassociados();
	}
	
	@Override
	public void setIdassociados(int idassociados) {
		setIdassociados(idassociados);
	}
	
	@Override
	public byte getAtivo() {
		return getAtivo();
	}

	@Override
	public void setAtivo(byte ativo) {
		setAtivo(ativo);
	}

	@Override
	public String getName() {
		return getName();
	}

	@Override
	public void setName(String name) {
		setName(name);
	}

}