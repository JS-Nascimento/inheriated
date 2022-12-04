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

import br.dev.jstec.inheriated.domain.entities.Payment;
import br.dev.jstec.inheriated.domain.repositories.PaymentRepository;
import br.dev.jstec.inheriated.services.PaymentService;

@RequestMapping(path = "/api/payments")
@RestController
public class PaymentController {

	@Autowired
	private PaymentRepository repository;
	
	@Autowired
	private PaymentService service;
	
	@GetMapping
	@ResponseStatus(OK)
	public List<Payment> getAllCostumer(){
		return repository.findAll();
	}
	
	@GetMapping("{id}")
	@ResponseStatus(OK)
	public Payment findById(@PathVariable Integer id) {
	
		return service.findById(id);
	}
	

	@PostMapping
	@ResponseStatus(CREATED)
	public Payment saveState(@RequestBody Payment payment ) {
		
		return repository.save(payment);
		
	}
	
}
