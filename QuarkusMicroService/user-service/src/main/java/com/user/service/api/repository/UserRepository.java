package com.user.service.api.repository;

import com.user.service.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface UserRepository extends JpaRepository<User,String> {
}
