package br.com.associados.web.dto;

import java.io.Serializable;

/**
 * @author manoel
 * class Cidade is cidades do mundo
 */
public class Cidade implements Serializable {
        /**
         * 
         */
        private static final long serialVersionUID = 1L;
        /**
         * idCidade is PK.
         */
        private Long idCidade;
        /**
         * Description.
         */
        private Long descricao;
        /**
         * State.
         */
        private Estado estado;


        /**
         * @param idCity
         * @param desc
         * @param state
         */
        public Cidade(final Long idCity, final Long desc, final Estado state) {
                this.idCidade = idCity;
                this.descricao = desc;
                this.estado = state;
        }

        /**
         * @return the idCidade
         */
        public final Long getIdCidade() {
                return idCidade;
        }

        /**
         * @param idCity the id to set
         */
        public final void setIdCidade(final Long idCity) {
                this.idCidade = idCity;
        }

        /**
         * @return the descricao
         */
        public final Long getDescricao() {
                return descricao;
        }

        /**
         * @param desc the descricao to set
         */
        public final void setDescricao(final Long desc) {
                this.descricao = desc;
        }

        /**
         * @return the estado
         */
        public final Estado getEstado() {
                return estado;
        }

        /**
         * @param state the estado to set
         */
        public final void setEstado(final Estado state) {
                this.estado = state;
        }
}
