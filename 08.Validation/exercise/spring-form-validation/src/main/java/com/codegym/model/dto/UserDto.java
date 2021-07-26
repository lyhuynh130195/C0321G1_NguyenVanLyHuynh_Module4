package com.codegym.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private Integer id;

    @Size(min = 5,max=45,message ="first name length > 5 and <45")
    private String firstName;

    @Size(min = 5,max=45,message = "last name length > 5 and <45")
    private String lastName;

    @Pattern(regexp = "^\\d{10}$",message = "phone number invalid")
    private String numberPhone;

    @Min(value = 18,message = "age >=18")
    private Integer age;

    @Email(message = "email invalid")
    private String email;

}
