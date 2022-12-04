package br.dev.jstec.inheriated.rest.controllers;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.dev.jstec.inheriated.domain.entities.Costumer;
import br.dev.jstec.inheriated.domain.repositories.CostumerRepository;
import br.dev.jstec.inheriated.services.CostumerService;

@RequestMapping(path = "/api/costumers")
@RestController
public class CostumerController {

	@Autowired
	private CostumerRepository repository;
	
	@Autowired
	private CostumerService service;
	
	@GetMapping
	@ResponseStatus(OK)
	public List<Costumer> getAllCostumer(){
		return repository.findAll();
	}
	
	@GetMapping("{id}")
	@ResponseStatus(OK)
	public Costumer findById(@PathVariable Integer id) {
	
		return service.findById(id);
	}
	

	@PostMapping
	@ResponseStatus(CREATED)
	public Costumer saveState(@RequestBody Costumer costumer ) {
		
		return repository.save(costumer);
		
	}
	
}
