package br.com.associados.dao.imp;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.associados.dao.CidadeDao;
import br.com.associados.model.Cidade;

@Repository
public class CidadeDaoImp extends GenericDaoImp<Cidade> implements CidadeDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<Cidade> listCidadeByEstado(Integer id) {
	Query query = this.em.createQuery("Select c FROM Cidade c inner join fetch c.estado est "
		+ " where est.id="+id);
	List<Cidade> result = query.getResultList();
	return result;
    }
}
