package com.codegym.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String birthday;


    private String idCard;

    private double salary;

    private String phone;

    private String email;

    private String address;

    @ManyToOne(targetEntity = Position.class)
    @JoinColumn(name = "position_id",referencedColumnName = "id")
    private Position position;

    @ManyToOne(targetEntity = Education.class)
    @JoinColumn(name = "education_id",referencedColumnName = "id")
    private Education education;

    @ManyToOne(targetEntity = Division.class)
    @JoinColumn(name = "division_id",referencedColumnName = "id")
    private Division division;

    @ManyToOne(targetEntity = AppUser.class)
    @JoinColumn(name = "userName",referencedColumnName = "userName")
    private AppUser appUser;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    private List<Contract> contractList;

}
