package com.example.demo.services;

import com.example.demo.entites.Product;
import com.example.demo.entites.Type;
import com.example.demo.repo.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public int saveProducts(int count, Type type) {
        if (!type.equals(Type.TIN)) {
            throw new IllegalArgumentException();
        }
        //Не работало, так как в базе данных не было ни одного товара. Решил добавить if, но понимаю, что неправильно
        //и можно было через optional
       Product product = productRepository.findProductByType(type);
       if (product == null) {
           product = new Product(0, type);
       }
       product.setCount(product.getCount() + count);
       productRepository.save(product);
       return product.getCount();
    }

    @Override
    @Transactional
    public int deleteProducts(int count, Type type) {
        if (!type.equals(Type.TIN)) {
            throw new IllegalArgumentException();
        }
        Product product = productRepository.findProductByType(type);
        if (product == null) {
            product = new Product(0, type);
        }
        if (product.getCount() < count) {
            throw new IllegalArgumentException();
        } else {
            product.setCount(product.getCount() - count);
            productRepository.save(product);
        }
        return product.getCount();
    }
}
