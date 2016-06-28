package com.yakub.vaadin.boot.frontend.presenter;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.ui.TextField;
import com.yakub.vaadin.boot.backend.domain.User;
import com.yakub.vaadin.boot.backend.service.LoginService;
import com.yakub.vaadin.boot.frontend.listener.LoginActionsListener;
import com.yakub.vaadin.boot.frontend.view.LoginView;
import com.yakub.vaadin.boot.utility.VaadinUiComponent;

@VaadinUiComponent
public class LoginPresenter implements LoginActionsListener {


  private LoginView view;
  private LoginService service;

  public LoginPresenter() {
    super();
    // TODO Auto-generated constructor stub
  }

  @Autowired
  public LoginPresenter(LoginView view, LoginService service) {
    super();
    this.view = view;
    this.service = service;
  }

  @Override
  public void login() {
    // TODO Auto-generated method stub
    TextField textUsername = view.getTxtUsername();
    TextField textPassword = view.getTxtPassword();

    String username = textUsername.getValue();
    String password = textPassword.getValue();

    try {
      if (service.login(new User(username, password))) {
        view.afterSuccessLogin();
      } else {
        System.out.println("login failed");
      }
    } catch (Exception exception) {
      exception.printStackTrace();
    }

  }

}
