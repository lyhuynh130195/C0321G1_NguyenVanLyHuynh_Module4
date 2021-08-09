package com.codegym.model.dto;

import com.codegym.model.entity.Customer;
import com.codegym.model.entity.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    @NotBlank(message = "id not can empty")
    @Pattern(regexp = "^KH-\\d{4}$", message = "Id invalid")
    private String id;

    private CustomerType customerType;
    private String name;
    @NotBlank

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
