package com.castille.customer.model;

import com.castille.customer.dto.CustomerDto;
import com.castille.customer.model.enumeration.Gender;
import lombok.Data;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String phoneNumber;

    public CustomerDto toCustomerDto(){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setFirstName(this.getFirstName());
        customerDto.setLastName(this.getLastName());
        customerDto.setEmail(this.getEmail());
        customerDto.setGender(this.getGender());
        customerDto.setPhoneNumber(this.getPhoneNumber());
        customerDto.setId(this.getId());
        customerDto.setFullName(this.getFirstName()+ " " + this.getLastName());
        return customerDto;
    }
}
