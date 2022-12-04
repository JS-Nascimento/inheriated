package br.dev.jstec.inheriated.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.jstec.inheriated.domain.entities.SaleOrderItem;

public interface SaleOrderItemRepository extends JpaRepository<SaleOrderItem, Integer> {
	

}
