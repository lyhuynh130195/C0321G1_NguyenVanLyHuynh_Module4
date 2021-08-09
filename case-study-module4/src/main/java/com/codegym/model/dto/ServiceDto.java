package com.codegym.model.dto;

import com.codegym.model.entity.Contract;
import com.codegym.model.entity.RentType;
import com.codegym.model.entity.ServiceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDto {
    private int id;
    @NotBlank(message = "Name not empty")
    private String name;

    @Min(value = 0,message = "area always > 0")
    private int area;

    @Min(value = 0,message = "cost always > 0")
    private double cost;

    @Min(value = 0,message = "maxPeople always > 0")
    private int maxPeople;

    private RentType rentType;

    private ServiceType serviceType;

    private String standardRoom;

    private String description;

    @Min(value = 0,message = "poolArea always > 0")
    private double poolArea;

    private int numberOfFloors;

}
