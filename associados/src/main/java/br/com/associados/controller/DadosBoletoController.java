package br.com.associados.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.associados.boleto.BoletoFactory;
import br.com.associados.boleto.util.LoteUtil;
import br.com.associados.repository.BoletoRepository;
import br.com.associados.service.CadastroService;

@RestController
@RequestMapping("/dadosBoleto")
public class DadosBoletoController {

	@Autowired
	private CadastroService cadastroService;
	
	@Autowired
	BoletoRepository repository;

	@RequestMapping(method = RequestMethod.POST )
	public HttpEntity<byte[]> save(@RequestBody LoteUtil loteUtil) {
		if(loteUtil != null){
			
		}
		return null;
	}
	
	
}