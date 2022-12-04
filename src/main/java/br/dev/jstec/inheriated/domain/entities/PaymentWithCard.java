package br.dev.jstec.inheriated.domain.entities;



import javax.persistence.Entity;

import br.dev.jstec.inheriated.domain.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PaymentWithCard extends Payment {

	private Integer installments;

	public PaymentWithCard(Integer id, PaymentStatus paymentStatus, SaleOrder saleOrder, Integer installments) {
		super(id, paymentStatus, saleOrder);
		this.installments = installments;
	}
	
	
	
	
}
