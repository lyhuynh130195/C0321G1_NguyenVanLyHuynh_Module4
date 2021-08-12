package com.codegym.model.dto;

import com.codegym.model.entity.RentType;
import com.codegym.model.entity.ServiceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDto {
    private int id;

    @NotBlank(message = "Name not empty")
    private String name;

    @Pattern(regexp = "^DV-\\d{4}$", message = "Code invalid")
    @NotBlank(message = "code not empty")
    private String code;

    @Min(value = 1,message = "area always > 0")
    private int area;

    @Min(value = 1,message = "cost always > 0")
    private double cost;

    @Min(value = 1,message = "maxPeople always > 0")
    private int maxPeople;

    private RentType rentType;

    private ServiceType serviceType;

    private String standardRoom;

    private String description;

    @Min(value = 1,message = "poolArea always > 0")
    private double poolArea;

    private int numberOfFloors;

}
