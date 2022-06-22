package aron.szoke.spring_demo.customer;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepo {
    public List<Customer> getCustomers();
}
