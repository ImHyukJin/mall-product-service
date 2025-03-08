package com.dmall.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dmall.productservice.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
