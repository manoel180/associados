package br.com.associados.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cidades")
public class Cidade implements Serializable{

        /**
         * 
         */
        private static final long serialVersionUID = 3277599324366911194L;

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        @Column(unique=true, nullable=false)
        private int idCidade;
        
        private String descricao;
      
        @ManyToOne
        private Estado estado;

        /**
         * @return the idCidade
         */
        public int getIdCidade() {
                return idCidade;
        }

        /**
         * @param idCidade the idCidade to set
         */
        public void setIdCidade(int idCidade) {
                this.idCidade = idCidade;
        }

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
