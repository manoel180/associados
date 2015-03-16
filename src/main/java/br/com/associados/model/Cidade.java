package br.com.associados.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cidades")
public class Cidade extends AbstractBean implements Serializable{

        /**
         * 
         */
        private static final long serialVersionUID = 3277599324366911194L;

        
        private String descricao;
      
        @ManyToOne
        private Estado estado;


        /**
         * @return the descricao
         */
        public String getDescricao() {
                return descricao;
        }

        /**
         * @param descricao the descricao to set
         */
        public void setDescricao(String descricao) {
                this.descricao = descricao;
        }

        public Estado getEstado() {
                return estado;
        }

        public void setEstado(Estado estado) {
                this.estado = estado;
        }
        
               
}
