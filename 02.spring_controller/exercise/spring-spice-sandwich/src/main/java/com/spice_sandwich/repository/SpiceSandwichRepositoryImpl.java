package com.spice_sandwich.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SpiceSandwichRepositoryImpl implements SpiceSandwichRepository {
    @Override
    public List<String> save(String[] arrCondiment) {
        List<String> listSpice = new ArrayList<>();

        for (String condiment : arrCondiment) {
            listSpice.add(condiment);
        }
        return listSpice;
    }
}
