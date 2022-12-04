package br.dev.jstec.inheriated.domain.entities;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SaleOrderItem {

	@JsonIgnore
	@EmbeddedId
	private SaleOrderItemPK id = new SaleOrderItemPK();

	private Double discount;
	private Integer quantity;
	private Double price;

	public SaleOrderItem() {

	}

	public SaleOrderItem(SaleOrder saleorder, Product product, Double discount, Integer quantity, Double price) {
		super();
		id.setSaleorder(saleorder);
		id.setProduct(product);
		this.discount = discount;
		this.quantity = quantity;
		this.price = price;
	}

	@JsonIgnore
	public SaleOrder getSaleorder() {
		return id.getSaleorder();
	}

	public Product getProduct() {
		return id.getProduct();
	}

		
	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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
		SaleOrderItem other = (SaleOrderItem) obj;
		return Objects.equals(id, other.id);
	}

}
