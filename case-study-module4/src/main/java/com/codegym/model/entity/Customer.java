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

public class Customer {
    @Id
    private String id;

    @ManyToOne(targetEntity = CustomerType.class)
    @JoinColumn(name = "type_id",referencedColumnName = "id")
    private CustomerType customerType;

    private String name;

    @Column(name = "birthday",columnDefinition = "Date")
    private String birthday;

    private String gender;

    private String idCard;

    private String phone;

    private String email;

    private String address;

    private int flags;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Contract> contractList;
}
