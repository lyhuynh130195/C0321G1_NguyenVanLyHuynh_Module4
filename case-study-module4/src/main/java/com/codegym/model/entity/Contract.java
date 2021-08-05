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
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "start_date",columnDefinition = "Date")
    private String startDate;
    @Column(name = "end_date",columnDefinition = "Date")
    private String endDate;

    private double deposit;

    private double totalMoney;

    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(name = "employee_id",referencedColumnName = "id")
    private Employee employee;

    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private  Customer customer;

    @ManyToOne(targetEntity = Service.class)
    @JoinColumn(name = "service_id",referencedColumnName = "id")
    private  Service service;

    @OneToMany(mappedBy = "contract",cascade = CascadeType.ALL)
    private List<ContractDetail> detailList;
}