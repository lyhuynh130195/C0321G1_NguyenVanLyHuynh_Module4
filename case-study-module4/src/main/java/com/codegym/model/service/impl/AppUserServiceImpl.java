package com.codegym.model.service.impl;

import com.codegym.model.entity.AppUser;
import com.codegym.model.repository.AppUserRepository;
import com.codegym.model.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserServiceImpl implements AppUserService {
    @Autowired
    AppUserRepository appUserRepository;

    @Override
    public List<AppUser> findAll() {
        return appUserRepository.findAll();
    }

    @Override
    public Optional<AppUser> findById(int id) {
        return appUserRepository.findById(id);
    }

    @Override
    public void save(AppUser appUser) {
        appUserRepository.save(appUser);
    }

    @Override
    public void remove(AppUser appUser) {
        appUserRepository.delete(appUser);
    }
}
