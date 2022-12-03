package br.dev.jstec.inheriated.rest.controllers;

import java.util.List;

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

import br.dev.jstec.inheriated.domain.entities.Category;
import br.dev.jstec.inheriated.domain.repositories.CategoryRepository;
import br.dev.jstec.inheriated.exceptions.ObjectNotFoundException;

@RequestMapping(path = "/api/category")
@RestController
public class CategoryController {

	@Autowired
	private CategoryRepository categories;
	
	
	public CategoryController(CategoryRepository categories) {

		this.categories = categories;
	}

	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<Category> getAllCategories() {

		return categories.findAll();
	}

	@GetMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public Category getCategoryById(@PathVariable Integer id) {

		return categories.findById(id).orElseThrow(
				()-> new ObjectNotFoundException("Categoria não encontrada."));
		
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Category saveCategory(@RequestBody Category category) {
		try {
			return categories.save(category);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}

	}

}
