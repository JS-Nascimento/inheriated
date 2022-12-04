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
import br.dev.jstec.inheriated.domain.entities.SaleOrder;
import br.dev.jstec.inheriated.domain.repositories.SaleOrderRepository;
import br.dev.jstec.inheriated.services.SaleOrderService;

@RequestMapping(path = "/api/salesOrder")
@RestController
public class SaleOrderController {

	@Autowired
	private SaleOrderRepository repository;
	
	@Autowired
	private SaleOrderService service;
	
	@GetMapping
	@ResponseStatus(OK)
	public List<SaleOrder> getAllSaleOrder(){
		return repository.findAll();
	}
	
	@GetMapping("{id}")
	@ResponseStatus(OK)
	public SaleOrder findById(@PathVariable Integer id) {
	
		return service.findById(id);
	}
	

	@PostMapping
	@ResponseStatus(CREATED)
	public SaleOrder saveState(@RequestBody SaleOrder SaleOrder ) {
		
		return repository.save(SaleOrder);
		
	}
	
}
