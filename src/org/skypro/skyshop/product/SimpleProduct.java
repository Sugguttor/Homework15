package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    public double price;

    public SimpleProduct(String name, int price) {
        super(name);
        if (price <= 0) {
            throw new IllegalArgumentException("Цена задана некорректно!");
        }
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getName() + " : " + price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

}
