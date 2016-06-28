package com.yakub.vaadin.boot.backend.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = User.TABLE_NAME)
public class User {

  public static final String TABLE_NAME = "user";

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid")
  @Column(columnDefinition = "CHAR(32)")
  private String id;

  @Column(name = "username", nullable = false)
  private String username;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "active", nullable = false)
  private boolean active;

  @Column(name = "created_datetime", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdDate;

  @Column(name = "updated_datetime", nullable = true)
  private Date updatedDate;

  @ManyToOne
  @JoinTable(name = "user_role",
      joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
      inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
  private Role role;

  public User() {
    super();
  }

  public User(String username, String password) {
    super();
    this.username = username;
    this.password = password;
  }

  public User(String id, String username, String password, boolean active, Date createdDate,
      Date updatedDate, Role role) {
    super();
    this.id = id;
    this.username = username;
    this.password = password;
    this.active = active;
    this.createdDate = createdDate;
    this.updatedDate = updatedDate;
    this.role = role;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", username=" + username + ", password=" + password + ", active="
        + active + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", role="
        + role + "]";
  }



}
