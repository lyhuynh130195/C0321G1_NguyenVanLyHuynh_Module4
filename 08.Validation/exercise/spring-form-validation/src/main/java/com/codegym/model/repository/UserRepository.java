package com.codegym.model.repository;

import com.codegym.model.entyti.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
