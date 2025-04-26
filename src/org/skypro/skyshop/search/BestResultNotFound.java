package org.skypro.skyshop.search;

public class BestResultNotFound extends Exception{

    private String name;

    public BestResultNotFound(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Для запроса " + name + " не нашлось статьи" + '}';
    }
}
