package com.codegym.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NotBlank
    @Size(min = 5, max = 45, message = "first name length >= 5 and =<45")
    private String firstName;
    @NotBlank
    @Size(min = 5, max = 45, message = "last name length >= 5 and <=45")
    private String lastName;

    @Pattern(regexp = "^\\d{10}$", message = "phone number invalid")
    private String numberPhone;

    @Min(value = 18, message = "age >=18")
    private Integer age;

    @Email(message = "email invalid")
    private String email;


}
