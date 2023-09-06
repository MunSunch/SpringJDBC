package com.munsun.spring_jdbc.app.controllers;

import com.munsun.spring_jdbc.app.dao.CustomOrderRepository;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
public class CustomOrderRestController {
    private CustomOrderRepository repository;

    @Autowired
    public CustomOrderRestController(CustomOrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/products/fetch-product")
    public List<String> getOrderNameByCustomerName(@RequestParam @NotBlank String name) {
        return repository.getProductName(name);
    }
}
