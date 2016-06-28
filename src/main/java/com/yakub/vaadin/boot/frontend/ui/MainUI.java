package com.yakub.vaadin.boot.frontend.ui;

import javax.inject.Inject;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import com.yakub.vaadin.boot.frontend.listener.LoginActionsListener;
import com.yakub.vaadin.boot.frontend.view.LoginView;
import com.yakub.vaadin.boot.frontend.view.impl.MainView;

@Theme("custom")
@SpringUI
public class MainUI extends UI {

  /**
   *
   * the main class of vaadin ui
   *
   */

  private static final long serialVersionUID = 2064539666249073386L;

  @Inject
  private LoginView view;

  @Inject
  private LoginActionsListener presenter;

  @Inject
  private MainView mainLayout;

  // @Inject
  // private SpringViewProvider provider;


  @Override
  protected void init(VaadinRequest request) {
    Navigator navigator = new Navigator(this, this);
    view.setListener(presenter);

    registerView(navigator);

    // navigator.addProvider(provider);
    setNavigator(navigator);
    navigator.navigateTo(LoginView.NAME);

  }


  /**
   *
   * adding view to navigator to switch the page
   *
   * @param navigator
   */

  public void registerView(Navigator navigator) {

    navigator.addView(LoginView.NAME, view);
    navigator.addView("", mainLayout);

  }



}
