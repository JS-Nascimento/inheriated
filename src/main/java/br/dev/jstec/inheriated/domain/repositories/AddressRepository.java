package br.dev.jstec.inheriated.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.jstec.inheriated.domain.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
	

}
