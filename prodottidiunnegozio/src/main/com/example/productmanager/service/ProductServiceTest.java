package com.example.productmanager.service;

import com.example.productmanager.entity.Product;
import com.example.productmanager.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private com.example.productmanager.service.ProductService productService;

    public ProductServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateProduct() {
        Product product = new Product(null, "Phone", "Smartphone", 699.99);
        when(productRepository.save(any(Product.class))).thenReturn(new Product(1L, "Phone", "Smartphone", 699.99));

        Product result = productService.createProduct(product);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(productRepository, times(1)).save(product);
    }

    @Test
    void testGetProductById() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(new Product(1L, "Phone", "Smartphone", 699.99)));

        Product result = productService.getProductById(1L);

        assertNotNull(result);
        assertEquals("Phone", result.getName());
        verify(productRepository, times(1)).findById(1L);
    }

    @Test
    void testDeleteProduct() {
        doNothing().when(productRepository).deleteById(1L);

        productService.deleteProduct(1L);

        verify(productRepository, times(1)).deleteById(1L);
    }
}
