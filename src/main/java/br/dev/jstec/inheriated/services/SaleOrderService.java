package br.dev.jstec.inheriated.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.jstec.inheriated.domain.entities.SaleOrder;
import br.dev.jstec.inheriated.domain.repositories.SaleOrderRepository;
import br.dev.jstec.inheriated.exceptions.ObjectNotFoundException;

@Service
public class SaleOrderService {
	
	@Autowired
	private SaleOrderRepository repository;
	
	public SaleOrder findById(Integer Id) {
		
		SaleOrder saleOrder = repository.findById(Id).orElseThrow(
				() -> new ObjectNotFoundException("Pedido não encontrado")
				);
		
		
		return saleOrder;
	}
	
}