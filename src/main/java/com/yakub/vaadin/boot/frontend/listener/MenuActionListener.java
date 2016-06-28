package com.yakub.vaadin.boot.frontend.listener;

import java.util.List;

import com.yakub.vaadin.boot.backend.domain.ApplicationMenu;

public interface MenuActionListener {

  void addNewMenu(ApplicationMenu menu);

  void updateMenu(ApplicationMenu menu);

  void deleteMenu(ApplicationMenu menu);

  List<ApplicationMenu> findAllApplicationMenus();

  ApplicationMenu findApplicationMenu(String applicationMenuId);

}
