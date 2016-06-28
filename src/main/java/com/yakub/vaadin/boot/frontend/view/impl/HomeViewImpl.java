package com.yakub.vaadin.boot.frontend.view.impl;

import javax.annotation.PostConstruct;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.yakub.vaadin.boot.frontend.view.HomeView;
import com.yakub.vaadin.boot.utility.VaadinUiComponent;

@VaadinUiComponent
public class HomeViewImpl extends VerticalLayout implements HomeView {

  /**
   *
   */
  private static final long serialVersionUID = -7597074119465706121L;

  @Override
  @PostConstruct
  public void init() {
    // TODO Auto-generated method stub
    setSizeFull();

    setHeight("100%");

    Label homeLabel = new Label("Welcome");
    homeLabel.addStyleName("h1");
    homeLabel.setSizeUndefined();
    homeLabel.setHeightUndefined();

    Panel panel = new Panel();
    VerticalLayout innerLayout = new VerticalLayout();
    innerLayout.setSizeFull();
    innerLayout.addComponent(homeLabel);

    innerLayout.setComponentAlignment(homeLabel, Alignment.MIDDLE_CENTER);

    panel.setContent(innerLayout);
    panel.setWidth("50%");
    panel.setHeight("300px");


    addComponent(new Label(""));
    addComponent(panel);
    addComponent(new Label(""));


    setComponentAlignment(panel, Alignment.MIDDLE_CENTER);


  }



}
