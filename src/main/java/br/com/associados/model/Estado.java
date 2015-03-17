package br.com.associados.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="estados")
public class Estado extends AbstractBean implements Serializable{
        /**
         * 
         */
        private static final long serialVersionUID = 1L;

        private String sigla;
        
        private String descricao;
        
        public String getDescricao() {
                return descricao;
        }

        public void setDescricao(String descricao) {
                this.descricao = descricao;
        }

	/**
	 * @return the sigla
	 */
	public String getSigla() {
	    return sigla;
	}

	/**
	 * @param sigla the sigla to set
	 */
	public void setSigla(String sigla) {
	    this.sigla = sigla;
	}
}
