package br.dev.jstec.inheriated.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.jstec.inheriated.domain.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	

}
