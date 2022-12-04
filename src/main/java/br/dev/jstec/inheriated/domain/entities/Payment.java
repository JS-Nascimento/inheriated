package br.dev.jstec.inheriated.domain.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.dev.jstec.inheriated.domain.enums.PaymentStatus;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Payment {



	@Id
	private Integer id;
	
	private Integer paymentStatus;
	
	@JsonIgnore
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
