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

import br.dev.jstec.inheriated.domain.entities.Product;
import br.dev.jstec.inheriated.domain.repositories.ProductRepository;


@RequestMapping(path = "/api/products")
@RestController
public class ProductController {
	
	
	@Autowired
	private ProductRepository products;

	public ProductController(ProductRepository products) {
	
		this.products = products;
	}
	
	
	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<Product> getAllProducts (){
		
		return products.findAll();
	}
	
	@GetMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public Product getProductById(@PathVariable Integer id){
		
		return products.findById(id).orElseThrow(
				()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado."));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public @Valid Product saveProduct(@RequestBody @Valid Product product) {
		try {
			return products.save(product);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
		
		
	}

}
