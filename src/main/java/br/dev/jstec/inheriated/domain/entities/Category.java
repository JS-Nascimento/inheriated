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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
public class Category {
	public Category(@NotEmpty(message = "Entre com a Descrição da Categoria") String description) {
		
		this.description = description;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	
	@NotEmpty(message="Entre com a Descrição da Categoria")
	private String description;
	
	@ManyToMany( cascade = {
	         
	        CascadeType.MERGE
	    })
	@JoinTable(name = "Product_Category",
				joinColumns = @JoinColumn(name= "Category_ID", referencedColumnName = "id"), 
				inverseJoinColumns = @JoinColumn (name = "Product_ID", referencedColumnName = "id"),   
				uniqueConstraints={@UniqueConstraint(columnNames={"Category_ID","Product_ID"})})
	@JsonIgnoreProperties("categories")
	private List<Product> products = new ArrayList<>();


	
	
	

}
