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
@RequestMapping("/boleto")
public class BoletoController {

	private BoletoFactory boletoFactory;

	@Autowired
	private CadastroService cadastroService;
	
	@Autowired
	BoletoRepository repository;

	@RequestMapping(method = RequestMethod.POST )
	public HttpEntity<byte[]> save(@RequestBody LoteUtil loteUtil) {
		if(loteUtil != null){
			return gerarLote(loteUtil);
		}
		return null;
	}
	
	 public HttpEntity<byte[]> gerarLote(LoteUtil lote) {
			boletoFactory = new BoletoFactory();
			try {
			 return   boletoFactory.generateLote(lote.getQtdParcela(),//qtdParcela 
			    		lote.getQtdLote(),//qtdLote, 
			    		lote.getDtVencimento(),//dtVencimento, 
			    		lote.getValor(),//getValor(), 
			    		cadastroService);
			} catch (IOException e) {
			    e.printStackTrace();
			    return null;
			}
		    }
}