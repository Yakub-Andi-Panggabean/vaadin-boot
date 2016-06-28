package com.yakub.vaadin.boot.backend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.yakub.vaadin.boot.backend.domain.Role;
import com.yakub.vaadin.boot.backend.domain.User;

public interface RoleRepository extends CrudRepository<Role, String> {

  Role findByUser(User user);

  List<Role> findRoleByRoleName(String roleName);

}
