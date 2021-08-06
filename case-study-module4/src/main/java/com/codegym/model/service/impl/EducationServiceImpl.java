package com.codegym.model.service.impl;

import com.codegym.model.entity.Education;
import com.codegym.model.repository.EducationRepository;
import com.codegym.model.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationServiceImpl implements EducationService {
    @Autowired
    EducationRepository educationRepository;
    @Override
    public List<Education> findAll() {
        return educationRepository.findAll();
    }

    @Override
    public Optional<Education> findById(int id) {
        return educationRepository.findById(id);
    }

    @Override
    public void save(Education education) {
        educationRepository.save(education);
    }

    @Override
    public void remove(Education education) {
        educationRepository.delete(education);
    }
}
