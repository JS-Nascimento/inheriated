package br.dev.jstec.inheriated.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.jstec.inheriated.domain.entities.SaleOrderItem;
import br.dev.jstec.inheriated.domain.repositories.SaleOrderItemRepository;
import br.dev.jstec.inheriated.exceptions.ObjectNotFoundException;

@Service
public class SaleOrderItemService {
	
	@Autowired
	private SaleOrderItemRepository repository;
	
	public SaleOrderItem findById(Integer Id) {
		
		SaleOrderItem saleOrderItem = repository.findById(Id).orElseThrow(
				() -> new ObjectNotFoundException("Pedido não encontrado")
				);
		
		
		return saleOrderItem;
	}
	
}