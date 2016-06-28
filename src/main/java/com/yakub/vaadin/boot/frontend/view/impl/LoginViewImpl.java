package com.yakub.vaadin.boot.frontend.view.impl;

import javax.annotation.PostConstruct;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.shared.Position;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.yakub.vaadin.boot.frontend.listener.LoginActionsListener;
import com.yakub.vaadin.boot.frontend.view.LoginView;
import com.yakub.vaadin.boot.utility.VaadinUiComponent;


@VaadinUiComponent
public class LoginViewImpl extends VerticalLayout implements LoginView {


  private static final long serialVersionUID = -8264058848282048642L;

  private LoginActionsListener listener;
  private TextField textUserName;
  private TextField textPassword;
  private Button loginButton;


  @Override
  public void enter(ViewChangeEvent event) {
    // TODO Auto-generated method stub
    Notification notif = new Notification("Welcome");
    notif.setDelayMsec(3000);
    notif.setPosition(Position.MIDDLE_CENTER);
    notif.show(Page.getCurrent());
  }

  @Override
  public void setListener(LoginActionsListener listener) {
    // TODO Auto-generated method stub
    this.listener = listener;
  }

  @Override
  @PostConstruct
  public void init() {
    // TODO Auto-generated method stub
    setSizeFull();
    Panel panel = new Panel("Login ...");
    FormLayout innerLayout = new FormLayout();
    innerLayout.setWidthUndefined();

    textUserName = new TextField("username");
    textUserName.setWidth("80%");
    textPassword = new TextField("password");
    textPassword.setWidth("80%");
    loginButton = new Button("login");

    innerLayout.addComponent(textUserName);
    innerLayout.addComponent(textPassword);
    innerLayout.addComponent(loginButton);

    HorizontalLayout horizontalLayout = new HorizontalLayout();
    horizontalLayout.setSizeFull();
    horizontalLayout.addComponent(innerLayout);
    horizontalLayout.setComponentAlignment(innerLayout, Alignment.MIDDLE_CENTER);

    panel.setContent(horizontalLayout);
    panel.setHeight("35%");
    panel.setWidth("30%");


    addComponent(panel);

    setComponentAlignment(panel, Alignment.MIDDLE_CENTER);

    loginButton.addClickListener(new Button.ClickListener() {

      /**
       *
       */
      private static final long serialVersionUID = 3762092809911994569L;

      @Override
      public void buttonClick(ClickEvent event) {
        // TODO Auto-generated method stub
        listener.login();
      }
    });

  }

  @Override
  public TextField getTxtUsername() {
    // TODO Auto-generated method stub
    return textUserName;
  }

  @Override
  public TextField getTxtPassword() {
    // TODO Auto-generated method stub
    return textPassword;
  }

  @Override
  public Button getLoginButton() {
    // TODO Auto-generated method stub
    return loginButton;
  }

  @Override
  public void afterSuccessLogin() {
    // TODO Auto-generated method stub
    UI.getCurrent().getNavigator().navigateTo("");
    Notification notif = new Notification("login success");
    notif.setDelayMsec(3000);
    notif.setPosition(Position.TOP_RIGHT);
    notif.show(Page.getCurrent());

  }

}
