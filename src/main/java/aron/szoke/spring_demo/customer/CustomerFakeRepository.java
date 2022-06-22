package aron.szoke.spring_demo.customer;

import java.util.Arrays;
import java.util.List;

//@Repository
//@Qualifier("Fake")
public class CustomerFakeRepository implements CustomerRepo {

    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(4l,"Jamill Ahmed", "xE123Klsp1", "email@gmail.com"),
                new Customer(5l,"Stewart Johns", "kup4tr33sl", "email@gmail.com")
        );
    }

}
