package com.foodrescue.backend.repository;

import com.foodrescue.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}