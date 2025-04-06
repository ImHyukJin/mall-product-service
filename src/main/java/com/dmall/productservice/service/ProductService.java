package com.dmall.productservice.service;

// 📁 service/ProductService.java
import com.dmall.productservice.dto.ProductRequestDto;
import com.dmall.productservice.dto.ProductResponseDto;
import com.dmall.productservice.model.Product;
import com.dmall.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //상품 등록
    public ProductResponseDto createProduct(ProductRequestDto dto) {
        Product product = new Product(dto.getName(), dto.getPrice(), dto.getDescription());
        Product saved = productRepository.save(product);
        return toResponseDto(saved);
    }

    //모든 상품 조회
    public List<ProductResponseDto> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }
    
    //특정 상품 조회
    public ProductResponseDto getProductById(Long id) {
        return productRepository.findById(id)
                .map(this::toResponseDto)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    //상품 수정
    public ProductResponseDto updateProduct(Long id, ProductRequestDto dto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());

        Product updated = productRepository.save(product);
        return toResponseDto(updated);
    }
    
    //상품 삭제
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        productRepository.delete(product);
    }
    
    
    private ProductResponseDto toResponseDto(Product product) {
        ProductResponseDto dto = new ProductResponseDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setDescription(product.getDescription());
        return dto;
    }
}
