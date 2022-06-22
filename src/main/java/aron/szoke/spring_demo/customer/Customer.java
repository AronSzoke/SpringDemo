package aron.szoke.spring_demo.customer;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @NotBlank(message = "name must not be empty")
    private  String name;

//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = "password must not be empty")
    private  String password;

    @Email(regexp = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-zA-Z]{2,})$", message = "email must be formatted as: test@gmail.com")
    private String email;

    public Customer(Long id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public Customer() {

    }
//  @JsonProperty("customerId")
    public Long getId() {
        return id;
    }
//  @JsonIgnore
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
