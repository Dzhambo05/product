package com.example.demo.services;


import com.example.demo.entites.Product;
import com.example.demo.entites.Type;
import com.example.demo.repo.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl productService;
    @Mock
    private ProductRepository productRepository;


    @Test
    void saveProducts() {
        Product product = new Product(60, Type.TIN);
        Mockito.when(productRepository.findProductByType(Type.TIN)).thenReturn(new Product(100, Type.TIN));
        int sum = productService.saveProducts(product.getCount(), product.getType());
        Assertions.assertEquals(160, sum);
    }

    @Test
    void deleteProducts() {
        Product product = new Product(30, Type.TIN);
        Mockito.when(productRepository.findProductByType(Type.TIN)).thenReturn(new Product(100, Type.TIN));
        int sum = productService.deleteProducts(product.getCount(), product.getType());
        Assertions.assertEquals(70, sum);
    }

    @Test
    void deleteProducts_exception() {
        Product product = new Product(110, Type.TIN);
        Mockito.when(productRepository.findProductByType(Type.TIN)).thenReturn(new Product(100, Type.TIN));
        Assertions.assertThrows(IllegalArgumentException.class, () -> productService.deleteProducts(product.getCount(), product.getType()));
    }

}
