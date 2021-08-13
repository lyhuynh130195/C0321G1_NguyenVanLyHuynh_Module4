package com.codegym.model.dto;

import com.codegym.model.entity.ContractDetail;
import com.codegym.model.entity.Customer;
import com.codegym.model.entity.Employee;
import com.codegym.model.entity.Service;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContractDto {

    private int id;

    private String startDate;

    private String endDate;

    @Min(value = 1,message = "deposit always > 0")
    private double deposit;

    @Min(value = 1,message = "totalMoney always > 0")
    private double totalMoney;

    private Employee employee;

    private  Customer customer;

    private  Service service;

}
