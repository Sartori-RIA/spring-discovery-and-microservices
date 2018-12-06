package com.cookiecode.microservico01.structure.repository;

import com.cookiecode.microservico01.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
