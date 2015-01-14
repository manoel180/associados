package br.com.associados.web.util;

public enum Servicos {
	USUARIOS("usuarios/search?"),
	PLANOS("planos"),
	PERFIS("perfis"),
	ASSOCIADOS("associados"),
	FOTO("foto"),
	FUNCIONALIDADES("funcionalidades");
	
	 private final String text;

	    /**
	     * @param text
	     */
	    private Servicos(final String text) {
	        this.text = text;
	    }

	    /* (non-Javadoc)
	     * @see java.lang.Enum#toString()
	     */
	    @Override
	    public String toString() {
	        return text;
	    }
}
