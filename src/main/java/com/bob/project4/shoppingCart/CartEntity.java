package com.bob.project4.shoppingCart;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bob.project4.products.ProductEntity;
import com.bob.project4.profile.UserEntity;

@Entity
@Table(name = "Orders")
public class CartEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "order_id")
  private long id;

  @Column(name = "order_date")
  private Date orderDate;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private ProductEntity product;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserEntity user;

  private int quantity;

  public CartEntity(long id, Date orderDate, ProductEntity product, UserEntity user, int quantity) {
    this.id = id;
    this.orderDate = orderDate;
    this.product = product;
    this.user = user;
    this.quantity = quantity;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Date getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
  }

  public ProductEntity getProduct() {
    return product;
  }

  public void setProduct(ProductEntity product) {
    this.product = product;
  }

  public UserEntity getUser() {
    return user;
  }

  public void setUser(UserEntity user) {
    this.user = user;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public CartEntity() {
  }

}
