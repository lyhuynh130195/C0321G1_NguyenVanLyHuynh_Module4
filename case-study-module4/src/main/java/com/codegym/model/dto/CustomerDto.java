package com.codegym.model.dto;

import com.codegym.model.entity.CustomerType;
import com.codegym.until.Age;
import com.codegym.until.Unique;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private int id;

    @NotBlank(message = "Code not can empty")
    @Pattern(regexp = "^KH-\\d{4}$", message = "Id invalid KH-XXXX")
    @Unique(message = "Duplicate code please re-enter")
    private String code;

    private CustomerType customerType;

    @NotBlank
    private String name;

    @NotBlank
    @Age
    private String birthday;

    private String gender;

    @NotBlank
    @Pattern(regexp = "^(\\d{9}||\\d{12})$", message = "idCard invalid")
    private String idCard;
    @NotBlank
    @Pattern(regexp = "^(\\d{10}||\\d{11})$", message = "phone number invalid")
    private String phone;
    @NotBlank
    @Email(message = "email invalid")
    private String email;

    private String address;

}
