package com.ms.user.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.user.service.entities.User;

public interface UserRepo extends JpaRepository<User, String> {

}
