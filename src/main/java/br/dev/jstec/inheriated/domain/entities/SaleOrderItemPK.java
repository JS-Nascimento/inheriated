package br.dev.jstec.inheriated.domain.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Embeddable
public class SaleOrderItemPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="saleorder_id")
	private SaleOrder saleorder;
	
	@ManyToOne
	@JoinColumn(name="Product_Id")
	private Product product;
	
	

	public SaleOrder getSaleorder() {
		return saleorder;
	}

	public void setSaleorder(SaleOrder saleorder) {
		this.saleorder = saleorder;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public int hashCode() {
		return Objects.hash(product, saleorder);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SaleOrderItemPK other = (SaleOrderItemPK) obj;
		return Objects.equals(product, other.product) && Objects.equals(saleorder, other.saleorder);
	}
	
	
	
	

}
