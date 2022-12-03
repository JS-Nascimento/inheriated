package br.dev.jstec.inheriated.rest.controllers;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.dev.jstec.inheriated.domain.entities.City;
import br.dev.jstec.inheriated.domain.repositories.CityRepository;
import br.dev.jstec.inheriated.exceptions.ObjectNotFoundException;

@RestController
@RequestMapping(path = "/api/cities")
public class CityController {

	@Autowired
	private CityRepository repository;
	
	@GetMapping
	@ResponseStatus(OK)
	public List<City> getAllCities(){
		return repository.findAll();
	}
	
	@GetMapping("{id}")
	@ResponseStatus(OK)
	public City getCityById(@PathVariable Integer id){
				
			return repository.findById(id).orElseThrow(
					()-> new ObjectNotFoundException("Cidade não encontrada."));
	}
	
	@PostMapping
	@ResponseStatus(CREATED)
	public City saveCity(@RequestBody City city ) {
		
		return repository.save(city);
		
	}
}
