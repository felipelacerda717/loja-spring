package com.projeto_loja.loja.facade;

import com.projeto_loja.loja.Produto.Product;
import com.projeto_loja.loja.Produto.ProductRepository;
import com.projeto_loja.loja.service.ProductService;
import com.projeto_loja.loja.strategy.DiscountStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductFacade {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productService.createProduct(product);
    }

    public Double getProductPriceWithDiscount(Long productId, DiscountStrategy discountStrategy) {
        Product product = productService.getProduct(productId);
        return discountStrategy.applyDiscount(product.getPrice());
    }

    public Iterable<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    public Product updateProduct(Long productId, Product product) {
        return productService.updateProduct(productId, product);
    }

    public void deleteProduct(Long productId) {
        productService.deleteProduct(productId);
    }

    public Iterable<Product> searchProduct(String name) {
        return productService.searchProduct(name);
    }
}
