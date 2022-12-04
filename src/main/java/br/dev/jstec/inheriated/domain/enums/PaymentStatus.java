package br.dev.jstec.inheriated.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PaymentStatus {

	PENDENTE(1, "Aguardando Pagamento"),
	PAGO(2, "Pedido Pago"),
	CANCELADO(3, "Cancelado");
	
	private Integer id;
	private String description;
	
	public static String toEnum(Integer id) {
		
		if(id == null) {
			return null;
		}
		
		for (PaymentStatus ct : PaymentStatus.values()) {
			if (id.equals(ct.getId())) {
				return ct.description;
			}
		}
		throw new IllegalArgumentException("Tipo não encontrado.");
		
	}
	
}
