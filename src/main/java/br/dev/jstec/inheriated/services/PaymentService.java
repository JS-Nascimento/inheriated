package br.dev.jstec.inheriated.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.jstec.inheriated.domain.entities.Payment;
import br.dev.jstec.inheriated.domain.repositories.PaymentRepository;
import br.dev.jstec.inheriated.exceptions.ObjectNotFoundException;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository repository;
	
	public Payment findById(Integer Id) {
		
		Payment payment = repository.findById(Id).orElseThrow(
				() -> new ObjectNotFoundException("Pagamento não encontrado")
				);
		
		
		return payment;
	}
	

}
