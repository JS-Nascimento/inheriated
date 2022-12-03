package br.dev.jstec.inheriated.rest.controllers;

import static org.springframework.http.HttpStatus.*;

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

import br.dev.jstec.inheriated.domain.entities.State;
import br.dev.jstec.inheriated.domain.repositories.StateRepository;
import br.dev.jstec.inheriated.exceptions.ObjectNotFoundException;

@RequestMapping(path = "/api/states")
@RestController
public class StateController {

	@Autowired
	private StateRepository repository;
	
	@GetMapping
	@ResponseStatus(OK)
	public List<State> getAllStates(){
		return repository.findAll();
	}
	
	@GetMapping("{id}")
	@ResponseStatus(OK)
	public State getStateById(@PathVariable Integer id){
				
			return repository.findById(id).orElseThrow(
					()-> new ObjectNotFoundException("Estado não encontrado."));
	}
	
	@PostMapping
	@ResponseStatus(CREATED)
	public State saveState(@RequestBody @Valid State state ) {
		
		return repository.save(state);
		
	}
	
}
