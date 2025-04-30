package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import org.w3c.dom.ls.LSOutput;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    private final LinkedList<Product> productBasket = new LinkedList<>();

    public void addProduct(Product product) {
        productBasket.add(product);

    }

    public double calculateSumOfBasket() {
        double sum = 0;
        for (Product product : productBasket) {
            if (product != null) {
                sum = sum + product.getPrice();
            }
        }
        return sum;
    }

    public void printProductBasket() {
        double sum = calculateSumOfBasket();
        int specialCounter = 0;
        for (Product product : productBasket) {
            if (product != null) {
                System.out.println(product.toString());
                if (product.isSpecial()) {
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
        for (Product product : productBasket) {
            if (product != null && product.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        productBasket.clear();
    }

    public LinkedList<Product> removeThisProduct(String name) {
        LinkedList<Product> removedProducts = new LinkedList<>();
        Iterator<Product> iterator = productBasket.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product != null && product.getName().equals(name)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }
        if (removedProducts.isEmpty()) {
            System.out.println("Список пуст");
        }
        return removedProducts;
    }


}

