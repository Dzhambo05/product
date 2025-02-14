package com.example.demo.services;

import com.example.demo.entites.Type;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    int saveProducts(int count, Type type);

    int deleteProducts(int count, Type type);

}
