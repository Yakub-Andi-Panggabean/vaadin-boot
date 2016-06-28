package com.yakub.vaadin.boot.frontend.components;

import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;

public class HorizontalComponentContainer extends HorizontalLayout {

  /**
   *
   */
  private static final long serialVersionUID = 175116277258988041L;


  public HorizontalComponentContainer(Component... components) {
    init(components);
  }

  public void init(Component... components) {

    this.setWidth("100%");

    for (Component component : components) {

      component.setWidth("70%");
      this.addComponent(component);
      // this.setSpacing(true);
      this.setExpandRatio(component, 1);
    }

  }

}
