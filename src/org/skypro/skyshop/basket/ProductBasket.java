package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class ProductBasket {
    private final Map<String, LinkedList<Product>> productBasket = new TreeMap<>();

    public void addProduct(Product product) {
        productBasket.computeIfAbsent(product.getName(), k -> new LinkedList<>()).add(product);
    }

    public double calculateSumOfBasket() {
        double sum = 0;
        for (Map.Entry<String, LinkedList<Product>> product : productBasket.entrySet()) {
            if (product != null) {
                for (Product p : product.getValue())
                    sum += p.getPrice();
            }
        }
        return sum;
    }

    public void printProductBasket() {
        double sum = calculateSumOfBasket();
        int specialCounter = 0;
        for (Map.Entry<String, LinkedList<Product>> product : productBasket.entrySet()) {
            System.out.println(product.toString());
            for (Product p : product.getValue()) {
                if (p.isSpecial()) {
                    specialCounter++;
                }
            }
        }
        if (sum == 0) {
            System.out.println("в корзине пусто");
        } else {
            System.out.println("Итого: " + sum);
            System.out.println("Специальных товаров: " + specialCounter);
        }
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

