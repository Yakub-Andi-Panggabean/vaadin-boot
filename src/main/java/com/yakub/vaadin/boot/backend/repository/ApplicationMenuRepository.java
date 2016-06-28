package com.yakub.vaadin.boot.backend.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.yakub.vaadin.boot.backend.domain.ApplicationMenu;
import com.yakub.vaadin.boot.backend.domain.Role;

public interface ApplicationMenuRepository extends CrudRepository<ApplicationMenu, String> {

  List<ApplicationMenu> findByParent(ApplicationMenu parent);

  Page<ApplicationMenu> findAll(Pageable page);

  ApplicationMenu findByLabel(String label);

  List<ApplicationMenu> findByRole(Role role);

  List<ApplicationMenu> findApplicationMenuByActiveAndRole(boolean active, Role role);

}
