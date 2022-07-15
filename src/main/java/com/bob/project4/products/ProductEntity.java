package com.bob.project4.products;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;

@Entity
@Table(name = "Products")

public class ProductEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "product_id")
  private int id;
  @Column(name = "name", nullable = false)
  private String productName;
  @Column(name = "description")
  private String description;
  @Column(name = "beer_style", nullable = false)
  private String style;
  @Column(name = "ABV", nullable = false)
  private double abv;
  @Column(name = "Stock", nullable = false)
  private int stock;
  @Column(name = "Price", nullable = false)
  private double price;
  @Column(name = "image_url", nullable = false)
  private String imageUrl;

  public ProductEntity(String productName, String description, String style, double abv, int stock, double price,
      String imageUrl) {
    this.productName = productName;
    this.description = description;
    this.style = style;
    this.abv = abv;
    this.stock = stock;
    this.price = price;
    this.imageUrl = imageUrl;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getProductName() {
    return this.productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getStyle() {
    return this.style;
  }

  public void setStyle(String style) {
    this.style = style;
  }

  public double getAbv() {
    return this.abv;
  }

  public void setAbv(double abv) {
    this.abv = abv;
  }

  public int getStock() {
    return this.stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  public double getPrice() {
    return this.price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getImageUrl() {
    return this.imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        ", productName='" + getProductName() + "'" +
        ", description='" + getDescription() + "'" +
        ", style='" + getStyle() + "'" +
        ", abv='" + getAbv() + "'" +
        ", stock='" + getStock() + "'" +
        ", price='" + getPrice() + "'" +
        ", imageUrl='" + getImageUrl() + "'" +
        "}";
  }

  public ProductEntity() {
  }

}
