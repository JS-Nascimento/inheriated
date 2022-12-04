package br.dev.jstec.inheriated.domain.entities;

import java.util.Date;

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
public class PaymentWithSlip extends Payment{

	private Date dueDate;
	private Date payDay;
	
	
	public PaymentWithSlip(Integer id, PaymentStatus paymentStatus, SaleOrder saleOrder, Date dueDate, Date payDay) {
		super(id, paymentStatus, saleOrder);
		this.dueDate = dueDate;
		this.payDay = payDay;
	}
	
	
	
}
