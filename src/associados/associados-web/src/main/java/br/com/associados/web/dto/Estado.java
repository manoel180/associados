package br.com.associados.web.dto;
/**
 * @author manoel
 */
public class Estado {
        /**
         * Id.
         */
        private Long id;
        /**
         * Description.
         */
        private String descricao;

        /**
         * @return the id
         */
        public final Long getId() {
                return id;
        }

        /**
         * @param identificador the id to set
         */
        public final void setId(final Long identificador) {
                this.id = identificador;
        }

        /**
         * @return the descricao
         */
        public final String getDescricao() {
                return descricao;
        }

        /**
         * @param desc the descricao to set
         */
        public final void setDescricao(final String desc) {
                this.descricao = desc;
        }
}
