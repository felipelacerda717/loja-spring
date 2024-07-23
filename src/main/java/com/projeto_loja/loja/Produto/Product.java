package com.projeto_loja.loja.Produto;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lombok.Data;
import lombok.Getter;

/**
 * Represents a product entity in the product management system.
 * This class is annotated as an Entity, making it suitable for ORM (Object-Relational Mapping) frameworks to map it to a database table.
 */
@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id; // Unique identifier for the product.

    private String name; // Name of the product.
    private String description; // Description of the product.
    private double price; // Price of the product.

    /**
     * Sets the ID of the product.
     * @param id The new ID of the product.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the ID of the product.
     * @return The ID of the product.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the name of the product.
     * @param name The new name of the product.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the product.
     * @return The name of the product.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the description of the product.
     * @param description The new description of the product.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the description of the product.
     * @return The description of the product.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the price of the product.
     * @param price The new price of the product.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns the price of the product.
     * @return The price of the product.
     */
    public double getPrice() {
        return price;
    }

}