package com.springsecurity.learning.SpringSecurityLearning.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthRepository extends JpaRepository<AuthGroup,Long> {
     List<AuthGroup> findByUsername(String username);
}
