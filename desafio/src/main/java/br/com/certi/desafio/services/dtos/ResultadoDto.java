package br.com.certi.desafio.services.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultadoDto {
	private String extenso;
	
	public ResultadoDto(String extenso) {
		this.extenso = extenso;
	}
}
