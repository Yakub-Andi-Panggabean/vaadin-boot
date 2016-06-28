package com.yakub.vaadin.boot.frontend.view;

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateField;

public interface SettingView extends Component {

  void init();

  DateField getDatefieldStart();

  DateField getDatefieldEnd();

  DateField getLastDateField();

  Button getButton();


}
