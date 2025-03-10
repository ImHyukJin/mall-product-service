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

	
	//��ü ��ǰ ��� ��ȸ
	@GetMapping("/")
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	//��ǰ �߰� (post)
	@PostMapping("/")
	public Product addProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
}
