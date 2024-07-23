package com.projeto_loja.loja.integration;

import com.projeto_loja.loja.Produto.Product;
import com.projeto_loja.loja.Produto.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductIntegrationTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void createAndGetProduct() {
        Product product = new Product();
        product.setName("Product B");
        product.setPrice(200.0);

        ResponseEntity<Product> response = restTemplate.postForEntity("/products", product, Product.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Product createdProduct = response.getBody();
        assertThat(createdProduct).isNotNull();
        assertThat(createdProduct.getId()).isNotNull();

        ResponseEntity<Double> priceResponse = restTemplate.getForEntity("/products/" + createdProduct.getId() + "/price", Double.class);
        assertThat(priceResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(priceResponse.getBody()).isEqualTo(200.0);
    }

}
