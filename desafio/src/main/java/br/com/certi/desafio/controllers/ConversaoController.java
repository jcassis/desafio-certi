package br.com.certi.desafio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.certi.desafio.infrastructure.RangeException;
import br.com.certi.desafio.services.ConversorService;
import br.com.certi.desafio.services.dtos.ResultadoDto;

@RestController
public class ConversaoController {
	
	@Autowired
	ConversorService conversor;
	
	@GetMapping
    public String index(){
        return "Olá! Desafio Certi realizado por Jivago.";
    }
	
    @GetMapping("/{numero}")
    public ResultadoDto conversor(@PathVariable("numero") int numero) throws RangeException{
        return conversor.converteNumeroParaExtenso(numero);
    }
}
