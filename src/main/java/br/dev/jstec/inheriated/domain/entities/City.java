package br.dev.jstec.inheriated.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class City {
	
	public City(String name, State state) {
		this.name = name;
		this.states=state;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message =  "O nome da cidade não pode ser vazio.")
	@Column(length = 50)
	private String name;
			
	@ManyToOne()
	@JoinColumn(name = "State_Id")
	private State states;
	
}