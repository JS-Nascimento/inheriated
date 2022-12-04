package br.dev.jstec.inheriated.domain.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import br.dev.jstec.inheriated.domain.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Payment {



	@Id
	private Integer id;
	
	private Integer paymentStatus;
	
	@OneToOne
	@JoinColumn(name="saleOrder_id")
	@MapsId
	private SaleOrder saleOrder;
	
	public String getPaymentStatus() {
		return PaymentStatus.toEnum(paymentStatus);
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus.getId();
	}

	public Payment(Integer id, PaymentStatus paymentStatus, SaleOrder saleOrder) {
		this.id = id;
		this.paymentStatus = paymentStatus.getId();
		this.saleOrder = saleOrder;
	}
	
	
}
