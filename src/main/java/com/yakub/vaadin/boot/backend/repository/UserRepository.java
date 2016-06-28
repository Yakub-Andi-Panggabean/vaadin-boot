package com.yakub.vaadin.boot.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.yakub.vaadin.boot.backend.domain.Role;
import com.yakub.vaadin.boot.backend.domain.User;

public interface UserRepository extends CrudRepository<User, String> {

  Page<User> findByRole(Role role, Pageable pageable);

  User findByUsername(String username);

  Page<User> findByActive(boolean active, Pageable pageable);

}
