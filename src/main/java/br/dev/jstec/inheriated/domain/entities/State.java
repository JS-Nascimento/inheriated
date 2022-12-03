package br.dev.jstec.inheriated.domain.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class State {
	
	public State(@NotEmpty(message = "O nome do estado não pode ser vazio.") String name,
			@NotEmpty(message = "O nome do estado não pode ser vazio.") String shortedName) {
		super();
		this.name = name;
		this.shortedName = shortedName.toUpperCase();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message =  "O nome do estado não pode ser vazio.")
	@Column(length = 50)
	private String name;
	
	@NotEmpty(message="O nome do estado não pode ser vazio.")
	@Column(length = 2)
	private String shortedName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "states", fetch = FetchType.LAZY)
	private List<City> cities = new ArrayList<>();
	
	
	
	
	
	

}
