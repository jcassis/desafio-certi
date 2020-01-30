package br.com.certi.desafio.infrastructure;

public class RangeException extends Exception{	
	public RangeException(String mensagem) {
		super(mensagem,null, false, false);
	}
	
}
