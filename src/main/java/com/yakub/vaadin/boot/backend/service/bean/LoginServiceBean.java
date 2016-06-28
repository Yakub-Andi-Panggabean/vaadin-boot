package com.yakub.vaadin.boot.backend.service.bean;

import org.springframework.stereotype.Service;

import com.yakub.vaadin.boot.backend.domain.User;
import com.yakub.vaadin.boot.backend.service.LoginService;

@Service
public class LoginServiceBean implements LoginService {

  @Override
  public boolean login(User user) {
    if (user.getUsername().equals("john") && user.getPassword().equals("lennon")) {
      return true;
    }
    return false;
  }

}
