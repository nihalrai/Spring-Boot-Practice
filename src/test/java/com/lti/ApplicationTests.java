package com.lti;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Customer;
import com.lti.repository.CustomerRepository;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class ApplicationTests {
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Test
	void add() {
		Customer c = new Customer();
		c.setName("Nihal Rai");
		c.setEmail("nihalrai@example.com");
		c.setPassword("nihalrai");
		c.setDateOfBirth(LocalDate.of(1998, 9, 11));
		
		customerRepo.save(c);
		//assert missing
	}
	
	@Test
	void findAll() {
		List<Customer> listOfCustomers = customerRepo.findAll();
		
		for(Customer c: listOfCustomers) {
			System.out.println(c.getId() + " , " + c.getName() + " , " + c.getDateOfBirth() + " , " + c.getEmail());;
		}
		//assert missing
	}
}
