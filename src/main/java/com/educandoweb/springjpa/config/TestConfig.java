package com.educandoweb.springjpa.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.springjpa.entities.Category;
import com.educandoweb.springjpa.entities.OrdemItem;
import com.educandoweb.springjpa.entities.Order;
import com.educandoweb.springjpa.entities.Payment;
import com.educandoweb.springjpa.entities.Products;
import com.educandoweb.springjpa.entities.Products;
import com.educandoweb.springjpa.entities.User;
import com.educandoweb.springjpa.entities.enums.OrderStatus;
import com.educandoweb.springjpa.repositories.CategoryRepository;
import com.educandoweb.springjpa.repositories.OrderItemRepository;
import com.educandoweb.springjpa.repositories.OrderRepository;
import com.educandoweb.springjpa.repositories.ProductsRepository;
import com.educandoweb.springjpa.repositories.ProductsRepository;
import com.educandoweb.springjpa.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userReporitory;
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private CategoryRepository category;
	
	@Autowired
	private ProductsRepository products;
	
	@Autowired
	private OrderItemRepository orderItem; 

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		category.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		Products p1 = new Products(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Products p2 = new Products(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Products p3 = new Products(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Products p4 = new Products(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Products p5 = new Products(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		products.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		
		products.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITTING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.SHIPPED, u1);
		Payment pay1 = new Payment(null,Instant.parse("2019-06-20T19:55:07Z"),o1 );
		o1.setPayment(pay1);
		
		userReporitory.saveAll(Arrays.asList(u1,u2));
		repository.saveAll(Arrays.asList(o1,o2,o3));
		
		OrdemItem oi1 = new OrdemItem(o1, p1, 2, p1.getPrice());
		OrdemItem oi2 = new OrdemItem(o1, p3, 1, p3.getPrice());
		OrdemItem oi3 = new OrdemItem(o2, p3, 2, p3.getPrice());
		OrdemItem oi4 = new OrdemItem(o3, p5, 2, p5.getPrice());
		
		orderItem.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		
		
		repository.save(o1);
		
	}
	
	

}
