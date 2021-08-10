package com.codegym.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
//name code area cost maxPeople rentType serviceType poolArea numberOfFloors
    private String code;

    private int area;

    private double cost;

    private int maxPeople;

    private int flags;

    @ManyToOne(targetEntity = RentType.class)
    @JoinColumn(name = "rent_type_id",referencedColumnName = "id")
    private RentType rentType;

    @ManyToOne(targetEntity = ServiceType.class)
    @JoinColumn(name = "service_type_id",referencedColumnName = "id")
    private ServiceType serviceType;

    private String standardRoom;

    private String description;

    private double poolArea;

    private int numberOfFloors;

    @OneToMany(mappedBy = "service",cascade = CascadeType.ALL)
    private List<Contract> contractList;
}

