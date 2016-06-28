package com.yakub.vaadin.boot.frontend.view.impl;

import javax.annotation.PostConstruct;

import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.yakub.vaadin.boot.frontend.components.HorizontalComponentContainer;
import com.yakub.vaadin.boot.frontend.components.TabComponentLayout;
import com.yakub.vaadin.boot.frontend.view.MenuView;
import com.yakub.vaadin.boot.utility.VaadinUiComponent;

@VaadinUiComponent
public class MenuViewImpl extends TabComponentLayout implements MenuView {

  /**
   *
   */
  private static final long serialVersionUID = 1260527051755299884L;

  private ComboBox parentComboBox;
  private TextField labelTextField;
  private TextArea descriptionTextArea;
  private ComboBox roleComboBox;
  private DateField createdDateFrom;
  private DateField createdDateEnd;
  private DateField updatedDateFrom;
  private DateField updatedDateEnd;

  private Button saveButton;
  private Button deleteButton;
  private Button updateButton;
  private Button findButton;
  private Grid menuGrid;



  @Override
  @PostConstruct
  public void init() {
    // TODO Auto-generated method stub
    FormLayout formLayout = new FormLayout();
    formLayout.setHeightUndefined();
    // formLayout.setWidth("50%");
    formLayout.addStyleName("padding-left");

    FormLayout formLayout2 = new FormLayout();
    formLayout2.setHeightUndefined();
    // formLayout2.setWidth("50%");
    formLayout2.addStyleName("padding-left");


    parentComboBox = new ComboBox();
    parentComboBox.setWidth("90%");
    parentComboBox.setInputPrompt("Parent ...");

    labelTextField = new TextField();
    labelTextField.setInputPrompt("Label ...");
    labelTextField.setWidth("90%");

    descriptionTextArea = new TextArea();
    descriptionTextArea.setWidth("90%");
    descriptionTextArea.setInputPrompt("Description ...");

    roleComboBox = new ComboBox();
    roleComboBox.setWidth("90%");
    roleComboBox.setInputPrompt("Role ...");

    createdDateFrom = new DateField();
    createdDateFrom.setCaption("created date from");

    createdDateEnd = new DateField();
    createdDateEnd.setCaption("created date to");

    updatedDateFrom = new DateField();
    updatedDateFrom.setCaption("updated date from");

    updatedDateEnd = new DateField();
    updatedDateEnd.setCaption("updated date end");

    HorizontalComponentContainer horizontalComponentContainer1 =
        new HorizontalComponentContainer(createdDateFrom, createdDateEnd);
    HorizontalComponentContainer horizontalComponentContainer2 =
        new HorizontalComponentContainer(updatedDateFrom, updatedDateEnd);


    findButton = new Button(" Search");
    deleteButton = new Button();
    updateButton = new Button();
    menuGrid = new Grid();

    formLayout.addComponent(parentComboBox);
    formLayout.addComponent(roleComboBox);
    formLayout.addComponent(descriptionTextArea);
    formLayout.addComponent(findButton);

    formLayout2.addComponent(labelTextField);
    formLayout2.addComponent(horizontalComponentContainer1);
    formLayout2.addComponent(horizontalComponentContainer2);

    HorizontalLayout horizontalLayout = new HorizontalLayout();
    horizontalLayout.setSizeFull();
    horizontalLayout.addComponent(formLayout);
    horizontalLayout.addComponent(formLayout2);

    VerticalLayout gridLayout = new VerticalLayout();
    menuGrid = new Grid();
    menuGrid.addColumn("Menu Label");
    menuGrid.addColumn("Parent");
    menuGrid.addColumn("Description");
    menuGrid.setSizeFull();
    menuGrid.addColumn("Updated Date");
    menuGrid.addColumn("Created Date");
    menuGrid.setHeightUndefined();

    gridLayout.addComponent(menuGrid);
    gridLayout.setStyleName("tabpanel");
    gridLayout.setHeightUndefined();

    VerticalLayout innerLayout = new VerticalLayout();
    innerLayout.addComponent(horizontalLayout);
    innerLayout.addComponent(gridLayout);

    Panel menuPanel = new Panel("Menu Panel");
    menuPanel.setContent(innerLayout);
    menuPanel.setWidth("95%");

    addComponent(menuPanel);

  }


  @Override
  public ComboBox getParentComboBox() {
    // TODO Auto-generated method stub
    return parentComboBox;
  }

  @Override
  public TextField getLabelTextField() {
    // TODO Auto-generated method stub
    return labelTextField;
  }

  @Override
  public TextArea getDescriptionTextArea() {
    // TODO Auto-generated method stub
    return descriptionTextArea;
  }

  @Override
  public Button getSaveButton() {
    // TODO Auto-generated method stub
    return saveButton;
  }

  @Override
  public Button getDeleteButton() {
    // TODO Auto-generated method stub
    return deleteButton;
  }

  @Override
  public Button getUpdateButton() {
    // TODO Auto-generated method stub
    return updateButton;
  }

  @Override
  public Button getFindButton() {
    // TODO Auto-generated method stub
    return findButton;
  }

  @Override
  public Grid getMenuTable() {
    // TODO Auto-generated method stub
    return menuGrid;
  }



}
