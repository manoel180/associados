package br.com.associados.web.dto;

import java.io.Serializable;


public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	
	
	private Cidade cidade;
	
	private String CEP;
	
	private String numero;
	
	private String complemento;

	public Endereco() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

        /**
         * @return the cidade
         */
        public Cidade getCidade() {
                return cidade;
        }

        /**
         * @param cidade the cidade to set
         */
        public void setCidade(Cidade cidade) {
                this.cidade = cidade;
        }

        /**
         * @return the cEP
         */
        public String getCEP() {
                return CEP;
        }

        /**
         * @param cEP the cEP to set
         */
        public void setCEP(String cEP) {
                CEP = cEP;
        }

        /**
         * @return the numero
         */
        public String getNumero() {
                return numero;
        }

        /**
         * @param numero the numero to set
         */
        public void setNumero(String numero) {
                this.numero = numero;
        }

        /**
         * @return the complemento
         */
        public String getComplemento() {
                return complemento;
        }

        /**
         * @param complemento the complemento to set
         */
        public void setComplemento(String complemento) {
                this.complemento = complemento;
        }

}