package br.dev.jstec.inheriated.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.jstec.inheriated.domain.entities.Costumer;
import br.dev.jstec.inheriated.domain.repositories.CostumerRepository;
import br.dev.jstec.inheriated.exceptions.ObjectNotFoundException;

@Service
public class CostumerService {
	
	@Autowired
	private CostumerRepository repository;
	
	public Costumer findById(Integer Id) {
		
		Costumer costumer = repository.findById(Id).orElseThrow(
				() -> new ObjectNotFoundException("Cliente não encontrado")
				);
		
		
		return costumer;
	}
	
}