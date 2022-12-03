package br.dev.jstec.inheriated.domain.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

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

	public Product(@NotEmpty(message = "Entre com a Descrição Produto") String description, Double price) {
		this.description = description;
		this.price = price;
	}
	

}
