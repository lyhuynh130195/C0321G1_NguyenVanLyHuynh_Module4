package com.spice_sandwich.service;

import com.spice_sandwich.repository.SpiceSandwichRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpiceSandwichServiceImpl implements SpiceSandwichService{
    @Autowired
    SpiceSandwichRepository spiceSandwichRepository;
    @Override
    public List<String> saveSpice(String[] arrCondiment) {
        return spiceSandwichRepository.save(arrCondiment);
    }
}
