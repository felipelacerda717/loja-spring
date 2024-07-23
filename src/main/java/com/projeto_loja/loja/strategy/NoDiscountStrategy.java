package com.projeto_loja.loja.strategy;
import org.springframework.stereotype.Service;

@Service    // @Service annotation is used with the classes that provide some business functionalities.
public class NoDiscountStrategy {
    public Double applyDiscount(Double price) {
        return price;
    }
}
