package com.projeto_loja.loja.strategy;
import org.springframework.stereotype.Service;

@Service
public class PercentageDiscountStrategy implements DiscountStrategy {
    private static final double DISCOUNT_RATE = 0.1; // 10% de desconto

    @Override
    public Double applyDiscount(Double price)  {
        return price - (price * DISCOUNT_RATE);
    }
}
