package br.dev.jstec.inheriated.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.jstec.inheriated.domain.entities.SaleOrder;

public interface SaleOrderRepository extends JpaRepository<SaleOrder, Integer> {
	

}
