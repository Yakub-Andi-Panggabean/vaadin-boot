package com.yakub.vaadin.boot.frontend.view;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.yakub.vaadin.boot.frontend.listener.LoginActionsListener;

public interface LoginView extends View {

  public static final String NAME = "login";

  void setListener(LoginActionsListener listener);

  void init();

  TextField getTxtUsername();

  TextField getTxtPassword();

  Button getLoginButton();

  void afterSuccessLogin();

}
