package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private String name;
    private static final double FIX_PRICE_PRODUCT = 100;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public double getPrice() {
        return FIX_PRICE_PRODUCT;
    }

    @Override
    public String toString() {
        return getName() + " : " + "Фиксированная цена " + FIX_PRICE_PRODUCT;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
