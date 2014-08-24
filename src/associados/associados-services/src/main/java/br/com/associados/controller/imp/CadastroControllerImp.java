package br.com.associados.controller.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.associados.controller.CadastroController;
import br.com.associados.dao.PlanoDao;
import br.com.associados.model.Plano;

@Component
public class CadastroControllerImp implements CadastroController {

	@Autowired
	PlanoDao planoDao;
	
	@Override
	public List<Plano> listAllPlanos(){
		return planoDao.listAll();
	}
}
