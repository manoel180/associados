package br.com.associados.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the enderecos database table.
 * 
 */
@Entity
@Table(name = "enderecos")
@NamedQuery(name = "Endereco.findAll", query = "SELECT e FROM Endereco e")
public class Endereco extends AbstractBean implements Serializable {
        private static final long serialVersionUID = 1L;

      
        
        private String cep;
        
        private String logradouro;
        
        private String complemento;
        
        private String numero;
        
        private String bairro;

        @ManyToOne
        @JoinColumn(name="cidade_id")
        private Cidade cidade;


        public Cidade getCidade() {
                return cidade;
        }

        public void setCidade(Cidade cidade) {
                this.cidade = cidade;
        }

        /**
         * @return the cep
         */
        public String getCep() {
                return cep;
        }

        /**
         * @param cep the cep to set
         */
        public void setCep(String cep) {
                this.cep = cep;
        }

        /**
         * @return the logradouro
         */
        public String getLogradouro() {
                return logradouro;
        }

        /**
         * @param logradouro the logradouro to set
         */
        public void setLogradouro(String logradouro) {
                this.logradouro = logradouro;
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
         * @return the bairro
         */
        public String getBairro() {
                return bairro;
        }

        /**
         * @param bairro the bairro to set
         */
        public void setBairro(String bairro) {
                this.bairro = bairro;
        }

        public String getComplemento() {
                return complemento;
        }

        public void setComplemento(String complemento) {
                this.complemento = complemento;
        }

}
