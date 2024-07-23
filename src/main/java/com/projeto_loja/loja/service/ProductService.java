package com.projeto_loja.loja.service;

import com.projeto_loja.loja.strategy.DiscountStrategy;
import com.projeto_loja.loja.Produto.Product;
import com.projeto_loja.loja.Produto.ProductRepository;
import com.projeto_loja.loja.strategy.NoDiscountStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    private DiscountStrategy discountStrategy;

    @Autowired
    public void setDiscountStrategy(@Qualifier("percentageDiscountStrategy") DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Double getProductPriceWithDiscount(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        return discountStrategy.applyDiscount(product.getPrice());
    }

    public Product getProduct(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product updateProduct(Long productId, Product product) {
        Product productToUpdate = productRepository
                .findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        productToUpdate.setName(product.getName());
        productToUpdate.setPrice(product.getPrice());
        return productRepository.save(productToUpdate);
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);

    }

    public Iterable<Product> searchProduct(String name) {
        return productRepository.findByNameContaining(name);
    }

    public void setNoDiscountStrategy() {
        this.discountStrategy = (DiscountStrategy) new NoDiscountStrategy();
    }


}
