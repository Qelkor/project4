package com.bob.project4.profile;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "Users")
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_id")
  private int id;

  @Column(name = "name", nullable = false)
  @NotEmpty(message = "*Please provide your name")
  private String name;

  @Column(name = "email", unique = true, nullable = false)
  @Email(message = "*Please provide a valid Email")
  @NotEmpty(message = "*Please provide an email")
  private String email;

  @Column(name = "password", nullable = false)
  @Length(min = 3, message = "*Your password must have at least 5 characters")
  @NotEmpty(message = "*Please provide your password")
  private String password;

  @Column(name = "address", nullable = false)
  @NotEmpty(message = "*Please provide your address")
  private String address;

  // @JsonIgnore
  // @OneToMany
  // @JoinColumn(name = "order_id")
  // private Set<CartEntity> orders;

  public UserEntity(@NotEmpty(message = "*Please provide your name") String name,
      @Email(message = "*Please provide a valid Email") @NotEmpty(message = "*Please provide an email") String email,
      @Length(min = 5, message = "*Your password must have at least 5 characters") @NotEmpty(message = "*Please provide your password") String password,
      @NotEmpty(message = "*Please provide your address") String address) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.address = address;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        ", name='" + getName() + "'" +
        ", email='" + getEmail() + "'" +
        ", password='" + getPassword() + "'" +
        ", address='" + getAddress() + "'" +

        "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof UserEntity)) {
      return false;
    }
    UserEntity userEntity = (UserEntity) o;
    return id == userEntity.id && Objects.equals(name, userEntity.name) && Objects.equals(email, userEntity.email)
        && Objects.equals(password, userEntity.password) && Objects.equals(address, userEntity.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, email, password, address);
  }

  public UserEntity() {

  }
}
