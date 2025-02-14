package com.example.demo.controllers;


import com.example.demo.entites.Type;
import com.example.demo.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductControllers {

    private final ProductServiceImpl productService;

    @Autowired
    public ProductControllers(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @PostMapping("/addProduct/{count}/{type}")
    public String saveProduct(@PathVariable int count, @PathVariable Type type) {
        int sum = productService.saveProducts(count, type);
        return "Сумма товара: " + sum;
    }

    @PostMapping("/deleteProduct/{count}/{type}")
    public String deleteProduct(@PathVariable int count, @PathVariable Type type) {
        int sum = productService.deleteProducts(count, type);
        return "Сумма товара: " + sum;
    }

}
