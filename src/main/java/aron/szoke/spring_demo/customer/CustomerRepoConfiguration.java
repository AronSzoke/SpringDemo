package aron.szoke.spring_demo.customer;

import aron.szoke.spring_demo.infoapp.InfoApp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.List;
import java.util.Optional;

@Configuration
public class CustomerRepoConfiguration {

    @Value("${app.useCustomerRepoFake:false}")
    private boolean useCustomerRepoFake;

    @Bean
    CommandLineRunner commandLineRunner (InfoApp infoApp){
        return args -> {
        System.out.println("Commandline runner runs");
        System.out.println(infoApp);
        };
    }

    @Bean
    CustomerRepo customerRepo (){
        System.out.println("useCustomerRepoFake = " + useCustomerRepoFake);
//        return useCustomerRepoFake ?
                return new CustomerFakeRepository();
//                new CustomerRepository();
    }
}
