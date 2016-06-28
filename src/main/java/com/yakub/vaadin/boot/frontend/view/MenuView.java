package com.yakub.vaadin.boot.frontend.view;

import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;

public interface MenuView extends Component {

  void init();

  ComboBox getParentComboBox();

  TextField getLabelTextField();

  TextArea getDescriptionTextArea();

  Button getSaveButton();

  Button getDeleteButton();

  Button getUpdateButton();

  Button getFindButton();

  Grid getMenuTable();

}
