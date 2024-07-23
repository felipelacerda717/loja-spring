package com.projeto_loja.loja.service;
import com.projeto_loja.loja.Produto.Product;
import com.projeto_loja.loja.Produto.ProductRepository;
import com.projeto_loja.loja.strategy.DiscountStrategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;
    @Mock
    private DiscountStrategy discountStrategy;
    @InjectMocks
    private ProductService productService;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testCreateProduct() {
        Product product = new Product();
        product.setName("Product A");
        product.setPrice(100.0);

        when(productRepository.save(any(Product.class))).thenReturn(product);
        Product createdProduct = productService.createProduct(product);

        assertEquals("Product A", createdProduct.getName());
        assertEquals(100.0, createdProduct.getPrice());
    }
    @Test
    public void testGetProductPriceWithDiscount() {
        Product product = new Product();
        product.setId(1L);
        product.setName("Product A");
        product.setPrice(100.0);

        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(discountStrategy.applyDiscount(100.0)).thenReturn(90.0);

        Double priceWithDiscount = productService.getProductPriceWithDiscount(1L);

        assertEquals(90.0, priceWithDiscount);
    }
}
