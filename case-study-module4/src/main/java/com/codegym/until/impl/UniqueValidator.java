package com.codegym.until.impl;

import com.codegym.model.entity.Customer;
import com.codegym.model.service.CustomerService;
import com.codegym.until.Unique;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;


public class UniqueValidator implements ConstraintValidator<Unique, String> {
    @Autowired
    CustomerService customerService;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        List<Customer> customerList = customerService.findAll();
        List<String> listCode = new ArrayList<>();
        for (Customer customer : customerList){
            listCode.add(customer.getCode());
        }
        return !listCode.contains(value);
    }
}
