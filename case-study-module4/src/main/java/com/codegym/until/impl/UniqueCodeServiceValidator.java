package com.codegym.until.impl;

import com.codegym.model.entity.Service;
import com.codegym.model.service.ServiceService;
import com.codegym.until.UniqueCodeService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;


public class UniqueCodeServiceValidator implements ConstraintValidator<UniqueCodeService,String> {
    @Autowired
    ServiceService serviceService;
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        List<Service> serviceList = serviceService.findAll();
        List<String> listCode = new ArrayList<>();
        for(Service service : serviceList){
            listCode.add(service.getCode());
        }
        return !listCode.contains(value);
    }
}
