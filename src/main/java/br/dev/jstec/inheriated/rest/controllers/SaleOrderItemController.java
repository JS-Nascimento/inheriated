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

import br.dev.jstec.inheriated.domain.entities.SaleOrderItem;
import br.dev.jstec.inheriated.domain.repositories.SaleOrderItemRepository;
import br.dev.jstec.inheriated.services.SaleOrderItemService;

@RequestMapping(path = "/api/salesOrderItem")
@RestController
public class SaleOrderItemController {

	@Autowired
	private SaleOrderItemRepository repository;
	
	@Autowired
	private SaleOrderItemService service;
	
	@GetMapping
	@ResponseStatus(OK)
	public List<SaleOrderItem> getAllSaleOrderItem(){
		return repository.findAll();
	}
	
	@GetMapping("{id}")
	@ResponseStatus(OK)
	public SaleOrderItem findById(@PathVariable Integer id) {
	
		return service.findById(id);
	}
	

	@PostMapping
	@ResponseStatus(CREATED)
	public SaleOrderItem saveState(@RequestBody SaleOrderItem saleOrderItem ) {
		
		return repository.save(saleOrderItem);
		
	}
	
}
