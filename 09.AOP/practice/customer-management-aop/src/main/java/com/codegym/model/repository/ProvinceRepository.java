package com.codegym.model.repository;

import com.codegym.model.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinceRepository extends JpaRepository<Province,Integer> {
}
