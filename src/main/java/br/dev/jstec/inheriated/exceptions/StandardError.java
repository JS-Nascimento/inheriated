package br.dev.jstec.inheriated.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StandardError {


	private Integer status;
	private String message;
	private Long timeStamp;
	
		
}
