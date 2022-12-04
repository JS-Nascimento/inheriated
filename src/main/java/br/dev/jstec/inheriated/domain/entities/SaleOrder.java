package br.dev.jstec.inheriated.domain.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class SaleOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date instante;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "saleOrder")
	private Payment payment;
	
	@ManyToOne
	@JoinColumn(name="costumer_id")
	private Costumer costumer;
	
	@ManyToOne
	@JoinColumn(name="addressDelivery_id")
	private Address deliveryAddress;
	
	@OneToMany(mappedBy = "id.saleorder")
	private Set<SaleOrderItem> items = new HashSet<SaleOrderItem>();

	public SaleOrder(Date instante, Costumer costumer, Address deliveryAddress) {
		
		this.instante = instante;
		this.costumer = costumer;
		this.deliveryAddress = deliveryAddress;
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
		SaleOrder other = (SaleOrder) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
