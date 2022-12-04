package br.dev.jstec.inheriated.domain.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.dev.jstec.inheriated.domain.enums.CostumerType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Costumer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private String email;
	private String cpfOrCnpj;
	
	private Integer costumerType;
	

	
	
	@ElementCollection
	@CollectionTable(name = "phone")
	private Set<String>telefone = new HashSet<>();
	
	
	@OneToMany(mappedBy = "costumer", fetch = FetchType.LAZY) 
	private List<Address> addresses = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "costumer")
	private List<SaleOrder> saleOrders = new ArrayList<>();
	
	public String getCostumerType() {
		return CostumerType.toEnum(costumerType);
	}

	public void setCostumerType(CostumerType costumerType) {
		this.costumerType =costumerType.getId();
	}

	
	public Costumer(String name, String email, String cpfOrCnpj, CostumerType costumerType) {
		this.name = name;
		this.email = email;
		this.cpfOrCnpj = cpfOrCnpj;
		this.costumerType = costumerType.getId();
	}

		
}
