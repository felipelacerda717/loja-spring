package com.projeto_loja.loja.service;

import com.projeto_loja.loja.Produto.Product;
import com.projeto_loja.loja.Produto.ProductRepository;
import com.projeto_loja.loja.strategy.DiscountStrategy;
import com.projeto_loja.loja.strategy.NoDiscountStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    private List<DiscountStrategy> discountStrategies;

    // Autowire the list of DiscountStrategy implementations
    @Autowired
    public ProductService(List<DiscountStrategy> discountStrategies) {
        this.discountStrategies = discountStrategies;
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProduct(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product updateProduct(Long productId, Product product) {
        Product productToUpdate = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
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

    // Method to apply discount using a selected strategy
    public double applyDiscount(Long productId, String discountType) {
        Product product = getProduct(productId);
        DiscountStrategy selectedStrategy = discountStrategies.stream()
                .filter(strategy -> strategy.getClass().getSimpleName().equalsIgnoreCase(discountType))
                .findFirst()
                .orElse((DiscountStrategy) new NoDiscountStrategy()); // Default to NoDiscountStrategy if none match
        return selectedStrategy.applyDiscount(product.getPrice());
    }

    public Double getProductPriceWithDiscount(Long id) {
        return productRepository.findById(id)
                .map(Product::getPrice)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
}