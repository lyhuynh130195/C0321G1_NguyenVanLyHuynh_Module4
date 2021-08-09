package com.codegym.model.dto;

import com.codegym.model.entity.AttachService;
import com.codegym.model.entity.Contract;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContractDetailDto {
//  id contract attachService quantity

    private int id;

    private Contract contract;

    private AttachService attachService;

    @Min(value = 0,message = "quantity always > 0")
    private int quantity;
}
