package com.yakub.vaadin.boot.frontend.components;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vaadin.server.ThemeResource;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Tree;
import com.yakub.vaadin.boot.backend.domain.ApplicationMenu;
import com.yakub.vaadin.boot.backend.service.ApplicationMenuService;

@Component
@UIScope
public class MenuTree extends Tree {

  /**
   *
   */
  private static final long serialVersionUID = -2986843862687560617L;

  @Autowired
  private ApplicationMenuService applicationMenuService;
  private List<ApplicationMenu> menus;

  private static final String PARENT_ICON_CLOSE = "img/closed_folder.png";
  private static final String PARENT_ICON_OPEN = "img/rsz_open_folder.png";
  private static final String CHILD_ICON = "img/rsz_blue_child.png";


  @PostConstruct
  public void init() {

    menus = applicationMenuService.fetchApplicationMenu();


    for (ApplicationMenu menu : menus) {

      addItem(menu.getLabel());
      setItemIcon(menu.getLabel(), new ThemeResource(CHILD_ICON));
      if (menu.getChildren().size() == 0) {
        setChildrenAllowed(menu.getLabel(), false);
      } else {
        addCollapseListener(e -> {
          setItemIcon(e.getItemId(), new ThemeResource(PARENT_ICON_CLOSE));
        });

        addExpandListener(e -> {
          setItemIcon(e.getItemId(), new ThemeResource(PARENT_ICON_OPEN));
        });
        for (ApplicationMenu children : menu.getChildren()) {
          addItem(children.getLabel());
          setParent(children.getLabel(), menu.getLabel());
          setChildrenAllowed(children.getLabel(), false);
          setItemIcon(children.getLabel(), new ThemeResource(CHILD_ICON));
        }
      }
      expandItemsRecursively(menu.getLabel());

    }

  }



}
