package br.dev.jstec.inheriated;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.dev.jstec.inheriated.domain.entities.Category;
import br.dev.jstec.inheriated.domain.entities.City;
import br.dev.jstec.inheriated.domain.entities.Product;
import br.dev.jstec.inheriated.domain.entities.State;
import br.dev.jstec.inheriated.domain.repositories.CategoryRepository;
import br.dev.jstec.inheriated.domain.repositories.CityRepository;
import br.dev.jstec.inheriated.domain.repositories.ProductRepository;
import br.dev.jstec.inheriated.domain.repositories.StateRepository;
import lombok.Data;

@SpringBootApplication
@Data
public class InheritanceApplication implements CommandLineRunner{
	@Autowired
	private CategoryRepository CatRepo;
	@Autowired
	private ProductRepository ProdRepo;
	@Autowired
	private CityRepository CityRepo;
	@Autowired
	private StateRepository StRepo;
	
	

	public static void main(String[] args) {
		SpringApplication.run(InheritanceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category ct1 = new Category("Papelaria");
		Category ct2 = new Category("Bazar");
		Category ct3 = new Category("Aviamentos");
		Category ct4 = new Category("Festas");
		Category ct5 = new Category("Brinquedos");
		
		Product prod1 = new Product("Caneta" , 1.99);
		Product prod2 = new Product("Lapis" , 2.99);
		Product prod3 = new Product("Cortina" , 10.99);
		
		
		//ct1.getProducts().addAll((Arrays.asList(prod1, prod2)));
		//ct2.getProducts().addAll((Arrays.asList(prod1, prod3)));
		
		
		prod1.getCategories().addAll((Arrays.asList(ct1, ct2)));
		prod2.getCategories().addAll((Arrays.asList(ct1)));
		prod3.getCategories().addAll((Arrays.asList(ct2)));
	
		CatRepo.saveAll(Arrays.asList(ct1,ct2, ct3, ct4, ct5));
			ProdRepo.saveAll(Arrays.asList(prod1,prod2,prod3));
		
		
		Category ct6 = new Category("Badulaques");
		CatRepo.save(ct6);
		
		State st1 = new State("Rio de Janeiro", "rj");
		State st2 = new State("São Paulo", "sP");
		State st3 = new State("Minas Gerais", "mg");
		
		StRepo.saveAll(Arrays.asList(st1,st2,st3));
		
		City city1 = new City("Rio de Janeiro", st1);
		City city2 = new City("São Paulo", st2);
		City city3 = new City("Belo Horizonte", st3);
		City city4 = new City("Uberlandia", st3);
		City city5 = new City("Nova Iguaçu", st1);
		City city6 = new City("São José do Rio Preto", st2);
		
		CityRepo.saveAll(Arrays.asList(city1,city2,city3,city4,city5,city6));
		
		
		
	}

}
