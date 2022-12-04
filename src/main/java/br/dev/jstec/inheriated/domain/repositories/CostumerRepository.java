package br.dev.jstec.inheriated.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.jstec.inheriated.domain.entities.Costumer;

public interface CostumerRepository extends JpaRepository<Costumer, Integer> {
	

}
