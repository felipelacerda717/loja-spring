package com.projeto_loja.loja.strategy;
import org.springframework.stereotype.Service;

@Service
public class SeasonalDiscountStrategy implements DiscountStrategy {
    private static final double Season_Discount = 0.2;



    @Override
    public Double applyDiscount(Double price) {
        return price - (price * Season_Discount);
    }
}
