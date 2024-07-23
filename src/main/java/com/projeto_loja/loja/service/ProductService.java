package com.projeto_loja.loja.service;

import com.projeto_loja.loja.strategy.DiscountStrategy;
import com.projeto_loja.loja.Produto.Product;
import com.projeto_loja.loja.Produto.ProductRepository;
import com.projeto_loja.loja.strategy.NoDiscountStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductService {
    private  ProductRepository productRepository;
    private  DiscountStrategy discountStrategy;

    @Autowired
    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Double getProductPriceWithDiscount(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        return discountStrategy.applyDiscount(product.getPrice());
    }
}
