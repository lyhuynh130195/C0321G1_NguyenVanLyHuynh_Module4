package com.codegym.model.repository;

import com.codegym.model.entity.SmartPhone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartPhoneRepository extends JpaRepository<SmartPhone,Long> {
}
