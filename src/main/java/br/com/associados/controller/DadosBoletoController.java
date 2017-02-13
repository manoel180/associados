package br.com.associados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.associados.entities.DadosBoleto;
import br.com.associados.service.CadastroService;

@RestController
@RequestMapping("/dadosBoleto")
public class DadosBoletoController {

	@Autowired
	private CadastroService cadastroService;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody DadosBoleto pesquisar() {
		DadosBoleto dadosBoleto = cadastroService.getDadosBoleto();
		return dadosBoleto;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<DadosBoleto> salvar(@RequestBody DadosBoleto dadosBoleto) {

		try {
			cadastroService.salvarDadosBoleto(dadosBoleto);
			return new ResponseEntity<DadosBoleto>(dadosBoleto, HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return null;
		}
	}
	
	
}