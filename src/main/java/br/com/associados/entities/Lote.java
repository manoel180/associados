package br.com.associados.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="lotes")
public class Lote extends AbstractBean {

    /**
     * 
     */
    private static final long serialVersionUID = 2083105217002169301L;
    // bi-directional many-to-one association to Boleto
    @OneToMany(mappedBy = "associado", cascade=CascadeType.ALL)
    private List<Boleto> boletos;
    
    public List<Boleto> getBoletos() {
	return boletos;
    }
    public void setBoletos(List<Boleto> boletos) {
	this.boletos = boletos;
    }
}
