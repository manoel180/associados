package br.com.associados.dao.imp;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.associados.dao.PerfilDao;
import br.com.associados.model.Perfil;

@Repository
public class PerfilDaoImp extends GenericDaoImp<Perfil> implements PerfilDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<Perfil> listAll() {
	Query query = this.em.createQuery("FROM Perfil");
	List<Perfil> result = query.getResultList();
	return result;
    }
}
