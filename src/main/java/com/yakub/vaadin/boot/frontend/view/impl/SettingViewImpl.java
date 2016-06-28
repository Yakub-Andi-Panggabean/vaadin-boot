package com.yakub.vaadin.boot.frontend.view.impl;

import javax.annotation.PostConstruct;

import com.vaadin.server.ExternalResource;
import com.vaadin.ui.BrowserFrame;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.yakub.vaadin.boot.frontend.components.HorizontalComponentContainer;
import com.yakub.vaadin.boot.frontend.view.SettingView;
import com.yakub.vaadin.boot.utility.VaadinUiComponent;

@VaadinUiComponent
public class SettingViewImpl extends VerticalLayout implements SettingView {
  /**
   *
   * main form of setting view
   *
   */
  private static final long serialVersionUID = -7459850599251390831L;

  private DateField dateFieldstart;
  private DateField dateFieldEnd;
  private DateField lastDateField;
  private Button actionButton;


  public void construtcWIndow() {

    BrowserFrame frame = new BrowserFrame("Maps",
        new ExternalResource("https://www.blibli.com/handphone-tablet/54593"));

    Window window = new Window("This is window");
    VerticalLayout subContent = new VerticalLayout();
    subContent.setMargin(true);
    window.setContent(frame);

    // Put some components in it

    frame.setSizeFull();

    subContent.setWidth("800px");
    subContent.setHeight("500px");

    window.setModal(true);

    window.setHeight("500px");
    window.setWidth("800px");
    window.center();

    UI.getCurrent().addWindow(window);

  }

  @PostConstruct
  @Override
  public void init() {
    // TODO Auto-generated method stub
    FormLayout formLayout = new FormLayout();
    formLayout.setSizeFull();
    // panelContainer = new Panel();
    // panelContainer.setSizeFull();

    dateFieldstart = new DateField();
    dateFieldstart.setCaption("Start Date");
    dateFieldEnd = new DateField();
    dateFieldEnd.setCaption("End Date");
    lastDateField = new DateField();
    lastDateField.setCaption("End Date2");

    HorizontalLayout horizontalLayout = new HorizontalLayout();
    horizontalLayout.setWidth("80%");
    HorizontalComponentContainer container =
        new HorizontalComponentContainer(dateFieldstart, dateFieldEnd, lastDateField);

    HorizontalComponentContainer container2 = new HorizontalComponentContainer();
    actionButton = new Button("Show Window");

    actionButton.addClickListener(e -> {
      construtcWIndow();
    });

    container2.addComponent(actionButton);


    formLayout.addComponent(container);
    formLayout.addComponent(actionButton);
    // panelContainer.setCaption("Setting View");
    // panelContainer.setContent(formLayout);

    addComponent(formLayout);
  }

  @Override
  public DateField getDatefieldStart() {
    // TODO Auto-generated method stub
    return dateFieldstart;
  }

  @Override
  public DateField getDatefieldEnd() {
    // TODO Auto-generated method stub
    return dateFieldEnd;
  }

  @Override
  public DateField getLastDateField() {
    // TODO Auto-generated method stub
    return lastDateField;
  }

  @Override
  public Button getButton() {
    // TODO Auto-generated method stub
    return actionButton;
  }


}
