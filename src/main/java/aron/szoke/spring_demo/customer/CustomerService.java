package aron.szoke.spring_demo.customer;

import aron.szoke.spring_demo.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    private final CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository){
        this.repository = repository;
    }

    public List<Customer> getCustomers(){
        LOGGER.info("retrieving all customers");
       return repository.findAll();
    }

    public void createCustomer(Customer customer) {
    }

    public void updateCustomerWithName(Long id, String name) {
    }

    public void updateCustomerWithPassword(Long id, String password) {
    }

    public void deleteCustomer(Long id) {
    }

    public Customer getCustomer(Long id) {
        return repository.findById(id)
                .orElseThrow( ()-> {
                    NotFoundException e = new NotFoundException("There is no customer with id : " + id);
                    LOGGER.error("error in getting customer {} ", id, e);
                    return e;
                });
    }
}
