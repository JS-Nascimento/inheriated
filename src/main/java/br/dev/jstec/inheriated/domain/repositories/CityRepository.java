package br.dev.jstec.inheriated.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.dev.jstec.inheriated.domain.entities.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

}