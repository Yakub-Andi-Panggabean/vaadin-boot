package com.yakub.vaadin.boot.backend.service.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yakub.vaadin.boot.backend.domain.ApplicationMenu;
import com.yakub.vaadin.boot.backend.domain.Role;
import com.yakub.vaadin.boot.backend.repository.ApplicationMenuRepository;
import com.yakub.vaadin.boot.backend.repository.RoleRepository;
import com.yakub.vaadin.boot.backend.service.ApplicationMenuService;

@Service
@Transactional(readOnly = true)
public class ApplicationMenuServiceBean implements ApplicationMenuService {

  private static final Logger logger = Logger.getLogger(ApplicationMenuServiceBean.class.getName());

  @Autowired
  private ApplicationMenuRepository applicationMenuRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Override
  public List<ApplicationMenu> fetchApplicationMenu() {
    Iterator<ApplicationMenu> applicationMenuIterator =
        applicationMenuRepository.findAll().iterator();
    List<ApplicationMenu> applicationMenus = new ArrayList<>();
    while (applicationMenuIterator.hasNext()) {
      applicationMenus.add(applicationMenuIterator.next());
    }
    return applicationMenus;
  }

  @Override
  public List<ApplicationMenu> fetchApplicationMenuByRole(String roleId) {
    // TODO Auto-generated method stub
    Role role = roleRepository.findOne(roleId);
    return applicationMenuRepository.findApplicationMenuByActiveAndRole(true, role);
  }

  @Override
  @Transactional(readOnly = false)
  public void save(ApplicationMenu applicationMenu) {
    // TODO Auto-generated method stub
    applicationMenuRepository.save(applicationMenu);
  }

  @Override
  public ApplicationMenu findById(String id) {
    // TODO Auto-generated method stub
    try {
      return applicationMenuRepository.findOne(id);
    } catch (Exception exception) {
      logger.info(exception.getMessage());
      return null;
    }
  }

  @Override
  @Transactional(readOnly = false)
  public void update(ApplicationMenu applicationMenu) {
    // TODO Auto-generated method stub
    try {
      if (applicationMenuRepository.exists(applicationMenu.getId())) {
        applicationMenuRepository.save(applicationMenu);
      }
    } catch (Exception exception) {
      logger.info(exception.getMessage());
    }
  }

}
