package org.skypro.skyshop.search;

public class BestResultNotFoundException extends Exception{

    private final String name;

    public BestResultNotFoundException(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Для запроса " + name + " не нашлось статьи" + '}';
    }
}
