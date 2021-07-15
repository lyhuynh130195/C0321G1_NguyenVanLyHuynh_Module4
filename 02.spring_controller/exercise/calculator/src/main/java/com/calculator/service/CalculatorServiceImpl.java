package com.calculator.service;

import com.calculator.repository.CalculatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService{
    @Autowired
    CalculatorRepository calculatorRepository;
    @Override
    public double addition(double num1, double num2) {
        return calculatorRepository.addition(num1,num2);
    }

    @Override
    public double subtraction(double num1, double num2) {
        return calculatorRepository.subtraction(num1,num2);
    }

    @Override
    public double multiplication(double num1, double num2) {
        return calculatorRepository.multiplication(num1,num2);
    }

    @Override
    public double division(double num1, double num2) {
        return calculatorRepository.division(num1,num2);
    }
}
