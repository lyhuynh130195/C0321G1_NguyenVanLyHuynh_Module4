package com.spice_sandwich.service;

import com.spice_sandwich.repository.SpiceSandwichRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface SpiceSandwichService {
    List<String> saveSpice(String[] arrCondiment);
}
