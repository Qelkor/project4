package com.bob.project4.products;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductController {
  @Autowired
  ProductRepository productRepo;

  // Get Route
  @GetMapping("/products")
  public ResponseEntity<List<ProductEntity>> getAllProducts(@RequestParam(required = false) String name) {
    try {
      List<ProductEntity> products = new ArrayList<ProductEntity>();
      if (name == null)
        productRepo.findAll().forEach(products::add);
      else
        productRepo.findByProductName(name).forEach(products::add);

      if (products.isEmpty()) {
        return new ResponseEntity<>(products, HttpStatus.OK);
      }
      return new ResponseEntity<>(products, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  // Get by ID
  @GetMapping("/products/{id}")
  public ResponseEntity<ProductEntity> getByProductId(@PathVariable("id") int id) {
    Optional<ProductEntity> productData = productRepo.findById(id);

    if (productData.isPresent()) {
      return new ResponseEntity<>(productData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  // Post Data
  @PostMapping("/products")
  public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductEntity product) {
    try {
      ProductEntity _product = productRepo
          .save(
              new ProductEntity(product.getProductName(), product.getDescription(), product.getStyle(),
                  product.getAbv(), product.getStock(), product.getPrice(), product.getImageUrl()));
      return new ResponseEntity<>(_product, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  // Update Data
  @PutMapping("/products/{id}")
  public ResponseEntity<ProductEntity> updateProduct(@PathVariable("id") int id, @RequestBody ProductEntity product) {
    Optional<ProductEntity> productData = productRepo.findById(id);

    if (productData.isPresent()) {
      ProductEntity _product = productData.get();
      _product.setProductName(product.getProductName());
      _product.setPrice(product.getPrice());
      _product.setAbv(product.getAbv());
      _product.setDescription(product.getDescription());
      _product.setStyle(product.getStyle());
      _product.setImageUrl(product.getImageUrl());
      _product.setStock(product.getStock());
      return new ResponseEntity<>(productRepo.save(_product), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  // Delete Data
  @DeleteMapping("/products/{id}")
  public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") int id) {
    try {
      productRepo.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
