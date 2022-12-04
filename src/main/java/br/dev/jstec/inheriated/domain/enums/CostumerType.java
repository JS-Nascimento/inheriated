package br.dev.jstec.inheriated.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CostumerType {

	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	private Integer id;
	private String description;
	
	public static String toEnum(Integer id) {
		
		if(id == null) {
			return null;
		}
		
		for (CostumerType ct : CostumerType.values()) {
			if (id.equals(ct.getId())) {
				return ct.description;
			}
		}
		throw new IllegalArgumentException("Tipo não encontrado.");
		
	}
	
}
