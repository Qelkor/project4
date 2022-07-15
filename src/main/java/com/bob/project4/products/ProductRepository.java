package com.bob.project4.products;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

  List<ProductEntity> findByProductName(String name);

  List<ProductEntity> findByStyle(String style);

}
