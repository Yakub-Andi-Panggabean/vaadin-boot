package com.yakub.vaadin.boot.backend.component;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class BeanContextAccessor implements ApplicationContextAware {

  private static ApplicationContext applicationContext;

  @Override
  public void setApplicationContext(ApplicationContext context) throws BeansException {
    // TODO Auto-generated method stub
    BeanContextAccessor.applicationContext = context;

  }

  public static Object obtainBean(String beanName) {
    return applicationContext.getBean(beanName);
  }

}
