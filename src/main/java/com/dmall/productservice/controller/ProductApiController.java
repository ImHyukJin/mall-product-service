package com.dmall.productservice.controller;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmall.productservice.dto.ProductRequestDto;
import com.dmall.productservice.dto.ProductResponseDto;
import com.dmall.productservice.model.Product;
import com.dmall.productservice.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductApiController {

	private final ProductService productService;
	
	public ProductApiController(ProductService productService) {
		this.productService = productService;
	}

	//healthcheck
	@Value("${server.env}")
	private String env;
	
	@GetMapping("/env")
	public ResponseEntity<?> getEnv() {
		return ResponseEntity.ok(env);
	}
	//////////////////////////////////////////////
//putMapping , reposnebody , pathvariable
	

	//모든 상품 조회
	@GetMapping
	public ResponseEntity<List<ProductResponseDto>> getAllProducts(){
		return ResponseEntity.ok(productService.getAllProducts());
	}
	
	//특정 상품 조회
	@GetMapping("/{id}")
	public ResponseEntity<ProductResponseDto> getProductById(@PathVariable Long id){
		return ResponseEntity.ok(productService.getProductById(id));
	}
	
	//상품 추가
	@PostMapping
	public ResponseEntity<ProductResponseDto> createProduct (@RequestBody ProductRequestDto product){
		return ResponseEntity.ok(productService.createProduct(product));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProductResponseDto> updateProduct(
	        @PathVariable Long id,
	        @RequestBody ProductRequestDto requestDto
	) {
	    return ResponseEntity.ok(productService.updateProduct(id, requestDto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
	    productService.deleteProduct(id);
		return ResponseEntity.noContent().build(); // 204 No Content;
	}
	
	
}
