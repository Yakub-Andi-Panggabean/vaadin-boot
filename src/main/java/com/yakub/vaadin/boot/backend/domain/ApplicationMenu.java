package com.yakub.vaadin.boot.backend.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = ApplicationMenu.TABLE_NAME)
public class ApplicationMenu {

  public static final String TABLE_NAME = "application_menu";

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid")
  @Column(columnDefinition = "CHAR(32)")
  private String id;

  @Column(name = "label", unique = true, nullable = false)
  private String label;

  @Column(name = "active", nullable = false)
  private boolean active;

  @Column(name = "created_datetime", columnDefinition = "DATETIME")
  @Temporal(TemporalType.DATE)
  private Date createdDate;

  @Column(name = "updated_datetime", columnDefinition = "DATETIME")
  @Temporal(TemporalType.DATE)
  private Date updatedDate;

  @Column(name = "description", nullable = false)
  private String description;

  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "parent_id")
  private ApplicationMenu parent;

  @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
  List<ApplicationMenu> children;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable(name = "role_menu",
      joinColumns = {@JoinColumn(name = "menu_id", referencedColumnName = "id")},
      inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
  private List<Role> role;


  public ApplicationMenu() {
    super();
    // TODO Auto-generated constructor stub
  }

  public ApplicationMenu(String id, String label, boolean active, Date createdDate,
      Date updatedDate, String description, ApplicationMenu parent, List<ApplicationMenu> children,
      List<Role> role) {
    super();
    this.id = id;
    this.label = label;
    this.active = active;
    this.createdDate = createdDate;
    this.updatedDate = updatedDate;
    this.description = description;
    this.parent = parent;
    this.children = children;
    this.role = role;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public Date getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(Date updatedDate) {
    this.updatedDate = updatedDate;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Role> getRole() {
    return role;
  }

  public void setRole(List<Role> role) {
    this.role = role;
  }

  public ApplicationMenu getParent() {
    return parent;
  }

  public void setParent(ApplicationMenu parent) {
    this.parent = parent;
  }

  public List<ApplicationMenu> getChildren() {
    return children;
  }

  public void setChildren(List<ApplicationMenu> children) {
    this.children = children;
  }

  @Override
  public String toString() {
    return "ApplicationMenu [id=" + id + ", label=" + label + ", active=" + active
        + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", description="
        + description + ", parent=" + parent + ", children=" + children.size() + ", role=" + role
        + "]";
  }



}
