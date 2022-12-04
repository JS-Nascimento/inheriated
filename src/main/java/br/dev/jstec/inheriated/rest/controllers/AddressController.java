package br.dev.jstec.inheriated.rest.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.dev.jstec.inheriated.domain.entities.Address;
import br.dev.jstec.inheriated.domain.repositories.AddressRepository;

@RequestMapping(path = "/api/addresses")
@RestController
public class AddressController {

	@Autowired
	private AddressRepository repository;

	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<Address> getAllAddress() {

		return repository.findAll();
	}

	@GetMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public Address getAddressById(@PathVariable Integer id) {

		return repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado."));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Address saveProduct(@RequestBody @Valid Address address) {
		try {
			return repository.save(address);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}

	}

}
