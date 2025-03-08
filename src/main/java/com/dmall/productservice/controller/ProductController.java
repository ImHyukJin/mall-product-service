package com.dmall.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmall.productservice.model.Product;
import com.dmall.productservice.repository.ProductRepository;

@RestController
@RequestMapping("/api/products")
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
