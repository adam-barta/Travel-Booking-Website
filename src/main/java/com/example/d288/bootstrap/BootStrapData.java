package com.example.d288.bootstrap;

import com.example.d288.dao.CustomerRepository;
import com.example.d288.dao.DivisionRepository;
import com.example.d288.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (customerRepository.count() == 1) {

            Customer george = new Customer();
            george.setFirstName("George");
            george.setLastName("Greenough");
            george.setAddress("500 Flight St");
            george.setPhone("707-566-5045");
            george.setPostal_code("98733");
            george.setDivision(divisionRepository.getReferenceById(2L));
            customerRepository.save(george);

            Customer bob = new Customer();
            bob.setFirstName("Bob");
            bob.setLastName("Mitsven");
            bob.setAddress("123 Cushman Ave");
            bob.setPhone("510-910-0009");
            bob.setPostal_code("90110");
            bob.setDivision(divisionRepository.getReferenceById(3L));
            customerRepository.save(bob);

            Customer eagle = new Customer();
            eagle.setFirstName("Eagle");
            eagle.setLastName("Jones");
            eagle.setAddress("123 Nest St");
            eagle.setPhone("123-523-2643");
            eagle.setPostal_code("63423");
            eagle.setDivision(divisionRepository.getReferenceById(4L));
            customerRepository.save(eagle);

            Customer spork = new Customer();
            spork.setFirstName("Spork");
            spork.setLastName("Utensil");
            spork.setAddress("999 Diner Dr");
            spork.setPhone("313-222-3131");
            spork.setPostal_code("12312");
            spork.setDivision(divisionRepository.getReferenceById(5L));
            customerRepository.save(spork);

            Customer special = new Customer();
            special.setFirstName("Special");
            special.setLastName("Agent");
            special.setAddress("99 Secret Rd");
            special.setPhone("000-000-0000");
            special.setPostal_code("23455");
            special.setDivision(divisionRepository.getReferenceById(6L));
            customerRepository.save(special);
        }
    }
}