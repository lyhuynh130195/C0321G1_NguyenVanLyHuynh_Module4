package com.calculator.service;


import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public double calculate(double num1, double num2, String calculation) {
        switch (calculation) {
            case "addition":
                return num1 + num2;
            case "subtract":
                return num1 - num2;
            case "multiply":
                return num1 * num2;
            case "division":
                return num1 / num2;
        }
        return 0;
    }
}
