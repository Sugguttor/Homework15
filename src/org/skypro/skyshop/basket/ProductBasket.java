package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] productBasket = new Product[5];

    public void addProduct(Product product) {
        for (int i = 0; i < productBasket.length; i++) {
            if (productBasket[i] == null) {
                productBasket[i] = product;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
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
        for (int i = 0; i < productBasket.length; i++) {
            productBasket[i] = null;
        }
    }


}

