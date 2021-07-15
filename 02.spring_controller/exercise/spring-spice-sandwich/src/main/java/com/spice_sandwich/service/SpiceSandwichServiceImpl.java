package com.spice_sandwich.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpiceSandwichServiceImpl implements SpiceSandwichService{
    @Override
    public List<String> saveSpice(String[] arrCondiment) {
        List<String> listSpice = new ArrayList<>();

        for (String condiment : arrCondiment) {
            listSpice.add(condiment);
        }
        return listSpice;
    }
}
