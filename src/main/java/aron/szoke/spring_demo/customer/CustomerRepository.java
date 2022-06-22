package aron.szoke.spring_demo.customer;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

//@Repository
//@Primary
public interface CustomerRepository extends JpaRepository<Customer,Long> {


}
