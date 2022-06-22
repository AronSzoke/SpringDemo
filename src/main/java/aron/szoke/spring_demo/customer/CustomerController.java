package aron.szoke.spring_demo.customer;

import aron.szoke.spring_demo.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customers")
public class CustomerController {

    private final CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return service.getCustomers();
    }
    @GetMapping(path = "{customerId}")
    public Customer getCustomer(@PathVariable("customerId") Long id) {
        return service.getCustomer(id);
    }

    @GetMapping(path = "{customerId}/exception")
    public Customer getCustomerException(@PathVariable("customerId") Long id) {
        throw new ApiRequestException("customer with id : " + id + " is not present!");
    }

    @PostMapping
    public void createCustomer(@Valid @RequestBody Customer customer) {
         System.out.println("POST REQUEST");
         System.out.println("Customer " + customer);
    }
    @DeleteMapping(path = "{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Long id) {
        System.out.println("DELETE REQUEST");
        System.out.println("Customer with id: " + id  + " is about to be deleted");
    }
    @PutMapping(path = "{customerId}")
    public void updateCustomer(@PathVariable("customerId") Long id, @RequestParam String name, @RequestParam String password, @RequestParam String email) {
        System.out.println("UPDATE REQUEST");
        System.out.println("Customer with id: " + id  + " is about to be updated");
        System.out.println("New name: " + name);
        System.out.println("New password: " + password);
        System.out.println("New email: " + email);
    }

}
