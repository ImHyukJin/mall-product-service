package com.dmall.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dmall.productservice.model.Product;
import com.dmall.productservice.repository.ProductRepository;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // ��ü ��ǰ ��� ��ȸ (HTML ������ ������)
    @GetMapping()
    public String getAllProducts(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "index";  // templates/index.html�� ������
    }

    // ��ǰ �߰� (POST)
    @PostMapping()
    public String addProduct(@ModelAttribute Product product) {
        productRepository.save(product);
        return "redirect:/product";  // ��ǰ �߰� �� ��� �������� �����̷�Ʈ
    }
}
