package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {

    private String name;

    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя задано некорректно!");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double getPrice();

    @Override
    public String toString() {
        return name;
    }

    public abstract boolean isSpecial();

    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getTypeOfContent() {
        return "PRODUCT";
    }
}
