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
public class ProductApiController {


	
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
	
	@Value("${server.env}")
	private String env;
	@Value("${server.port}")
	private String serverPort;
	@Value("${server.address}")
	private String serverAddress;
	@Value("${serverName}")
	private String serverName;
	
	//서버가 잘 돌아가나
	@GetMapping("/hc")
	public ResponseEntity<?> healthCheck() {
		Map<String, String> responseData = new TreeMap<>();
		responseData.put("env", env);
		responseData.put("serverPort", serverPort);
		responseData.put("serverAddress", serverAddress);
		responseData.put("serverName", serverName);
		return ResponseEntity.ok(responseData);
	}
	
	@GetMapping("/env")
	public ResponseEntity<?> getEnv() {
		return ResponseEntity.ok(env);
	}
}
