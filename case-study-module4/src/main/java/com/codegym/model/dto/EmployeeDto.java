package com.codegym.model.dto;

import com.codegym.model.entity.*;
import com.codegym.model.service.EmployeeService;
import com.codegym.until.Age;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto   {

    @Autowired
    EmployeeService employeeService;
    private int id;
    @NotBlank
    private String name;

    @NotBlank
    @Age
    private String birthday;

    @NotBlank
    @Pattern(regexp = "^(\\d{9}||\\d{12})$", message = "idCard invalid")
    private String idCard;


    @Min(value = 1,message = "salary > 0")
    private double salary;

    @NotBlank
    @Pattern(regexp = "^(\\d{10}||\\d{11})$", message = "phone number invalid")
    private String phone;

    @NotBlank
    @Email(message = "email invalid")
    private String email;

    @NotBlank
    private String address;


    private Position position;


    private Education education;


    private Division division;

    private AppUser appUser;

}
