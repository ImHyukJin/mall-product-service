package com.dmall.productservice.controller;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmall.productservice.model.Product;
import com.dmall.productservice.repository.ProductRepository;

@RestController
@RequestMapping("/api/product")
public class ProductController {


	
	@Autowired
	private ProductRepository productRepository;

	
	//전체 상품 목록 조회
	@GetMapping("/")
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	//상품 추가 (post)
	@PostMapping("/")
	public Product addProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
}
