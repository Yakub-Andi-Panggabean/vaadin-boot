package com.yakub.vaadin.boot.backend.service;

import java.util.List;

import com.yakub.vaadin.boot.backend.domain.ApplicationMenu;

public interface ApplicationMenuService {

  List<ApplicationMenu> fetchApplicationMenu();

  List<ApplicationMenu> fetchApplicationMenuByRole(String roleId);

  void save(ApplicationMenu applicationMenu);

  ApplicationMenu findById(String id);

  void update(ApplicationMenu applicationMenu);

}
