package br.dev.jstec.inheriated.domain.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class SaleOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Date instante;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "saleOrder")
	private Payment payment;
	
	@ManyToOne
	@JoinColumn(name="costumer_id")
	private Costumer costumer;
	
	@ManyToOne
	@JoinColumn(name="addressDelivery_id")
	private Address deliveryAddress;

	public SaleOrder(Date instante, Costumer costumer, Address deliveryAddress) {
		
		this.instante = instante;
		this.costumer = costumer;
		this.deliveryAddress = deliveryAddress;
	}
	
	
}
