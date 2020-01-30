package br.com.certi.desafio.services;

import org.springframework.stereotype.Service;

import br.com.certi.desafio.infrastructure.RangeException;
import br.com.certi.desafio.services.dtos.ResultadoDto;

@Service
public class ConversorService {
	private static final String[] unidades = { "", "um", "dois", "três", "quatro",
			"cinco", "seis", "sete", "oito", "nove", "dez", "onze", "doze",
			"treze", "catorze", "quinze", "dezesseis", "dezessete",
			"dezoito", "dezenove" };

	private static final String[] dezenas = { 
			"", "", "vinte", "trinta", "quarenta", "cinquenta", "sessenta", "setenta", "oitenta", "noventa" 
	};
	
	private static final String[] centenas = { 
			"", "cem", "duzentos", "trezentos", "quatrocentos", "quinhentos", "seiscentos", "setecentos", "oitocentos", "novecentos" 
	};
	
		
	public ResultadoDto converteNumeroParaExtenso(int numero) throws RangeException {
		if(numero < -99999 || numero > 999999) {
			throw new RangeException("Ops! O número informado está fora do range de conversão, [-99999, 99999].");
		}
		
		return new ResultadoDto(converter(numero));
	}
	
	private String converter(int numero) {
			
		if (numero < 0) {
			return "menos " + converter(-numero);
		}

		if (numero < 20) {
			return unidades[numero];
		}

		if (numero < 100) {
			return dezenas[numero / 10] + ((numero % 10 != 0) ? " e " : "") + unidades[numero % 10];
		}

		if (numero < 1000) {
			return centenas[numero / 100] + ((numero % 100 != 0) ? " e " : "") + converter(numero % 100);
		}

		return converter(numero / 1000) + " mil" + ((numero % 1000 != 0) ? " e " : "") + converter(numero % 1000);
	}

}
