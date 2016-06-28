package com.yakub.vaadin.boot.backend.service;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.yakub.vaadin.boot.VaadinBootApplication;
import com.yakub.vaadin.boot.backend.domain.ApplicationMenu;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = VaadinBootApplication.class)
@WebAppConfiguration
public class ApplicationMenuServiceTest {

  @Autowired
  private ApplicationMenuService service;

  // @Test
  public void saveApplicationMenuTest() {

    try {

      ApplicationMenu applicationMenu = new ApplicationMenu();
      applicationMenu.setActive(true);
      applicationMenu.setChildren(null);
      applicationMenu.setCreatedDate(new Date());
      applicationMenu.setLabel("menu");
      applicationMenu.setParent(service.findById("4028b88155732b0f0155732b1dda0001"));
      applicationMenu.setRole(null);
      applicationMenu.setUpdatedDate(null);
      applicationMenu.setDescription("menu setting");

      service.save(applicationMenu);
    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }

  // @Test
  public void update() {

    ApplicationMenu applicationMenu = service.findById("4028b88155732b0f0155732b1ccc0000");
    // applicationMenu.setUpdatedDate(new Date());
    applicationMenu.setLabel("new label 2");
    applicationMenu.setParent(service.findById("4028b88155732b0f0155732b1dda0001"));
    service.update(applicationMenu);

  }

  @Test
  public void selectMenu() {

    try {
      List<ApplicationMenu> applicationMenu = service.fetchApplicationMenu();// findById("4028b88155732b0f0155732b1dda0001");
      System.out.println(applicationMenu.toString());
      // System.out.println(applicationMenu.getCreatedDate());
    } catch (Exception ex) {
      ex.printStackTrace();
    }

  }



}
