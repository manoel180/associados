package br.com.associados.model;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the enderecos database table.
 * 
 */
@Entity
@Table(name = "enderecos")
@NamedQuery(name = "Endereco.findAll", query = "SELECT e FROM Endereco e")
public class Endereco implements Serializable {
        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(unique = true, nullable = false)
        private int idEndereco;
        
        private String cep;
        
        private String logradouro;
        
        private String complemento;
        
        private String numero;
        
        private String Bairro;

        @ManyToOne
        private Cidade cidade;

        public int getIdEndereco() {
                return idEndereco;
        }

        public void setIdEndereco(int idEndereco) {
                this.idEndereco = idEndereco;
        }

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
                return Bairro;
        }

        /**
         * @param bairro the bairro to set
         */
        public void setBairro(String bairro) {
                Bairro = bairro;
        }

        public String getComplemento() {
                return complemento;
        }

        public void setComplemento(String complemento) {
                this.complemento = complemento;
        }

}
