package com.curency.service;

import org.springframework.stereotype.Service;

@Service
public class CalculateServiceImpl implements CalculateService{
    @Override
    public double calculateConvert(double usd, double exchangeRate) {
        return usd*exchangeRate;
    }
}
