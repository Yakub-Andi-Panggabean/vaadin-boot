package com.yakub.vaadin.boot.frontend.view.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.yakub.vaadin.boot.frontend.components.MenuTree;
import com.yakub.vaadin.boot.frontend.view.HomeView;
import com.yakub.vaadin.boot.frontend.view.MenuView;
import com.yakub.vaadin.boot.frontend.view.SettingView;
import com.yakub.vaadin.boot.utility.VaadinUiComponent;


@VaadinUiComponent
public class MainView extends VerticalLayout implements View {

  /**
   *
   *
   * the main layout of main view this view is the main page
   *
   *
   */
  private static final long serialVersionUID = 2220984264212350212L;

  private HorizontalLayout headerLayout;
  private HorizontalLayout bodyLayout;
  private VerticalLayout menuSection;
  private VerticalLayout contentSection;
  private TabSheet tabsheet;

  @Autowired
  private MenuTree menuTree;

  @Autowired
  private HomeView homeView;

  @Autowired
  private SettingView settingView;

  @Autowired
  private MenuView menuView;


  @PostConstruct
  public void init() {

    setSizeFull();

    headerLayout = new HorizontalLayout();
    bodyLayout = new HorizontalLayout();

    menuSection = new VerticalLayout();
    contentSection = new VerticalLayout();

    headerLayout.addStyleName("custom-header-content");

    Label label = new Label("Vaadin Boot Apps");
    label.setStyleName("h1");
    label.setSizeUndefined();
    headerLayout.addComponent(label);

    menuSection.addStyleName("content-container");
    contentSection.addStyleName("content-panel-container");

    menuSection.addComponent(new Label(""));
    menuSection.addComponent(menuTree);

    tabsheet = new TabSheet();

    tabsheet.addTab(homeView).setCaption("Home");
    tabsheet.getTab(homeView).setClosable(true);

    contentSection.addComponent(tabsheet);

    bodyLayout.setSizeFull();

    bodyLayout.addComponent(menuSection);
    bodyLayout.addComponent(contentSection);

    bodyLayout.setExpandRatio(menuSection, 2);
    bodyLayout.setExpandRatio(contentSection, 8);

    // addComponent(verticalLayout);
    addComponent(headerLayout);
    addComponent(bodyLayout);

    setExpandRatio(headerLayout, 1);
    setExpandRatio(bodyLayout, 9);

    menuTree.addValueChangeListener(e -> {
      menuAction(menuTree.getValue());
    });



  }


  /**
   * registering new component to main tab view
   *
   * @param component
   * @param caption
   */
  public void registerTabView(com.vaadin.ui.Component component, String caption) {

    tabsheet.addTab(component).setCaption(caption);
    tabsheet.setSelectedTab(component);
    tabsheet.getTab(component).setClosable(true);

  }

  /**
   *
   * register new menu here
   *
   * @param menuName
   */
  public void menuAction(Object menuName) {
    if (menuName != null) {

      String menu = (String) menuName;

      if (menu.equals("setting")) {

        registerTabView(settingView, "Setting View");


      } else if (menu.equals("home")) {

        registerTabView(homeView, "Home");

      } else if (menu.equals("menu management")) {

        registerTabView(menuView, "Menu Management");
      }
    }

  }


  @Override
  public void enter(ViewChangeEvent event) {
    // TODO Auto-generated method stub

  }



}
