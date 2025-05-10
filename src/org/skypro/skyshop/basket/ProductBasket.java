package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Stream;

public class ProductBasket {
    private final Map<String, LinkedList<Product>> productBasket = new HashMap<>();

    public void addProduct(Product product) {
        productBasket.computeIfAbsent(product.getName(), k -> new LinkedList<>()).add(product);
    }

    public double calculateSumOfBasket() {
        double sum = productBasket.values().stream().flatMap(Collection::stream)
                .mapToDouble(x -> x.getPrice())
                .sum();
        return sum;
    }

    public void printProductBasket() {
        double sum = calculateSumOfBasket();
        long specialCount = calculateSpecialProducts();
        Stream<Product> basket = productBasket.values().stream().flatMap(Collection::stream);
        if (sum == 0) {
            System.out.println("в корзине пусто");
        } else {
            basket.forEach(System.out::println);
            System.out.println("Итого: " + sum);
            System.out.println("Специальных товаров: " + specialCount);
        }
    }

    private long calculateSpecialProducts() {
        long specialCounter = productBasket.values().stream().flatMap(Collection::stream)
                .filter(x -> x.isSpecial())
                .count();
        return specialCounter;
    }

    public boolean searchProduct(String name) {
        for (Map.Entry<String, LinkedList<Product>> product : productBasket.entrySet()) {
            for (Product p : product.getValue()) {
                if (p.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void clear() {
        productBasket.clear();
    }

    public LinkedList<Product> removeThisProduct(String name) {
        LinkedList<Product> removedProducts = new LinkedList<>();
        if (productBasket.containsKey(name)) {
            removedProducts.addAll(productBasket.get(name));
            productBasket.remove(name);
        }
        if (removedProducts.isEmpty()) {
            System.out.println("Список пуст");
        }
        return removedProducts;
    }


}

