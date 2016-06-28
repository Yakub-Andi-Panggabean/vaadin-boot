package com.yakub.vaadin.boot.backend.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = Role.TABLE_NAME)
public class Role {

  public static final String TABLE_NAME = "role";

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid")
  @Column(columnDefinition = "CHAR(32)")
  private String id;

  @Column(name = "role_name", nullable = false)
  private String roleName;

  @Column(name = "description", nullable = false)
  private String description;

  @Column(name = "created_datetime", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdDate;

  @Column(name = "updated_datetime", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date updatedDate;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "user_role",
      joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
      inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")})
  private List<User> user;


  public Role() {
    super();
  }

  public Role(String id, String roleName, String description, Date createdDate, Date updatedDate) {
    super();
    this.id = id;
    this.roleName = roleName;
    this.description = description;
    this.createdDate = createdDate;
    this.updatedDate = updatedDate;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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

  public List<User> getUser() {
    return user;
  }

  public void setUser(List<User> user) {
    this.user = user;
  }

  @Override
  public String toString() {
    return "Role [id=" + id + ", roleName=" + roleName + ", description=" + description
        + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
  }



}
