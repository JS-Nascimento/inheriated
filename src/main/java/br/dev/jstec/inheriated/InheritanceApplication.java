package br.dev.jstec.inheriated;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.dev.jstec.inheriated.domain.entities.Address;
import br.dev.jstec.inheriated.domain.entities.Category;
import br.dev.jstec.inheriated.domain.entities.City;
import br.dev.jstec.inheriated.domain.entities.Costumer;
import br.dev.jstec.inheriated.domain.entities.Payment;
import br.dev.jstec.inheriated.domain.entities.PaymentWithCard;
import br.dev.jstec.inheriated.domain.entities.PaymentWithSlip;
import br.dev.jstec.inheriated.domain.entities.Product;
import br.dev.jstec.inheriated.domain.entities.SaleOrder;
import br.dev.jstec.inheriated.domain.entities.SaleOrderItem;
import br.dev.jstec.inheriated.domain.entities.State;
import br.dev.jstec.inheriated.domain.enums.CostumerType;
import br.dev.jstec.inheriated.domain.enums.PaymentStatus;
import br.dev.jstec.inheriated.domain.repositories.AddressRepository;
import br.dev.jstec.inheriated.domain.repositories.CategoryRepository;
import br.dev.jstec.inheriated.domain.repositories.CityRepository;
import br.dev.jstec.inheriated.domain.repositories.CostumerRepository;
import br.dev.jstec.inheriated.domain.repositories.PaymentRepository;
import br.dev.jstec.inheriated.domain.repositories.ProductRepository;
import br.dev.jstec.inheriated.domain.repositories.SaleOrderItemRepository;
import br.dev.jstec.inheriated.domain.repositories.SaleOrderRepository;
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
	@Autowired
	private AddressRepository AdRepo;
	@Autowired
	private CostumerRepository CoRepo;
	@Autowired
	private SaleOrderRepository SooRepo;
	@Autowired
	private PaymentRepository pyRepo;
	@Autowired
	private SaleOrderItemRepository soiRepo;

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
		
		Costumer cli1 = new Costumer("A O da Silva Armarinho","jorge@parmacon.com.br", "68.609.924/0001-23",CostumerType.PESSOAJURIDICA );
		
		cli1.getTelefone().addAll(Arrays.asList("21.979187777", "21.998142672"));
		
		Address ad1 = new Address("Rua Tomas Lopees", "857", "apto 201", "Vila da Penha", "21221210", city1, cli1);
		Address ad2 = new Address("Rua Joaquin de Queiroz ", "25", "Loja", "Ramos", "21120-25", city1, cli1);
		
		cli1.getAddresses().addAll(Arrays.asList(ad1,ad2));
		
		
		
		Costumer cli2 = new Costumer("Jorge Santos do Nascimento","jorge@parmacon.com.br", "08468626708",CostumerType.PESSOAFISICA );
		
		cli2.getTelefone().addAll(Arrays.asList("21.24733023", "21.24754800"));
		
		Address ad3 = new Address("Av Mascarenhas de Morais", "744", "-", "Figueira", "25555353", city1, cli2);
		Address ad4 = new Address("Rua Embau", "759", "-", "Ramos", "21120-250", city1, cli2);
		
		cli2.getAddresses().addAll(Arrays.asList(ad3,ad4));
		
		
		
		CoRepo.saveAll(Arrays.asList(cli1, cli2));
		AdRepo.saveAll(Arrays.asList(ad1, ad2,ad3,ad4));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		SaleOrder sl1  = new SaleOrder(sdf.parse("04/12/2021 00:29"), cli1, ad2);
		
		SaleOrder sl2  = new SaleOrder(sdf.parse("10/11/2022 13:55"), cli1, ad1);
		
		Payment pay1 = new PaymentWithCard(null, PaymentStatus.PAGO , sl1, 6);
		
		sl1.setPayment(pay1);
		
		
		Payment pay2 = new PaymentWithSlip(null, PaymentStatus.PENDENTE, sl2, sdf.parse("27/10/2022 00:00"), null) ;
		sl2.setPayment(pay2);
		
		cli1.getSaleOrders().addAll(Arrays.asList(sl1,sl2));
		
		SooRepo.saveAll(Arrays.asList(sl1,sl2));
		
		pyRepo.saveAll(Arrays.asList(pay1,pay2));
		
		SaleOrderItem soi1 = new SaleOrderItem(sl1, prod1, 10.0, 10, 1.89);
		SaleOrderItem soi2 = new SaleOrderItem(sl1, prod3, 5.0, 1, 3.89);
		SaleOrderItem soi3 = new SaleOrderItem(sl2, prod2, 7.0, 8, 1001.89);
		
		sl1.getItems().addAll(Arrays.asList(soi1,soi2));
		sl2.getItems().addAll(Arrays.asList(soi3));
		
		prod1.getItems().addAll(Arrays.asList(soi1));
		prod2.getItems().addAll(Arrays.asList(soi3));
		prod3.getItems().addAll(Arrays.asList(soi2));
		
		soiRepo.saveAll(Arrays.asList(soi1,soi2,soi3));
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
