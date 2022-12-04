package br.dev.jstec.inheriated.domain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String street;
	private String numberStreet;
	private String complement;
	private String region;
	private String zipCode;
	
	@ManyToOne
	@JoinColumn(name="City_Id")
	private City city;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="costumer_id")
	private Costumer costumer;

	public Address(String street, String numberStreet, String complement, String region, String zipCode, City city,
			Costumer costumer) {
		super();
		this.street = street;
		this.numberStreet = numberStreet;
		this.complement = complement;
		this.region = region;
		this.zipCode = zipCode;
		this.city = city;
		this.costumer = costumer;
	}

	public Address() {
		
	}

	
	
	

}
