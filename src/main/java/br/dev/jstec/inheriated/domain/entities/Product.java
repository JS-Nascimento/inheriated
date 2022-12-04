package br.dev.jstec.inheriated.domain.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message="Entre com a Descrição Produto")
	private String description;
	private Double price;
	

	
	@ManyToMany( cascade = {
	         
	        CascadeType.MERGE
	    })
	@JoinTable(name = "Product_Category",
				joinColumns = @JoinColumn(name= "Product_ID", referencedColumnName = "id"), 
				inverseJoinColumns = @JoinColumn (name = "Category_ID", referencedColumnName = "id"),   
				uniqueConstraints={@UniqueConstraint(columnNames={"Product_ID", "Category_ID"})})
	@JsonIgnoreProperties("products")
	private List<Category> categories = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.product")
	private Set<SaleOrderItem> items = new HashSet<SaleOrderItem>();
	
	@JsonIgnore	
	public List<SaleOrder> getSaleOrders(){
		List<SaleOrder> list = new ArrayList<>();
		for (SaleOrderItem soi : items) {
			list.add(soi.getSaleorder());
		}
		return list;
	}

	public Product(@NotEmpty(message = "Entre com a Descrição Produto") String description, Double price) {
		this.description = description;
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
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
