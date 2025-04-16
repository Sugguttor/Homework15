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

    public int calculateSumOfBasket() {
        int sum = 0;
        for (Product product : productBasket) {
            if (product != null) {
                sum = sum + product.getCost();
            }
        }
        return sum;
    }

    public void printProductBasket() {
        int sum = calculateSumOfBasket();
        for (Product product : productBasket) {
            if (product != null) {
                System.out.println(product.getName() + " : " + product.getCost());
            }
        }
        if (sum == 0) {
            System.out.println("в корзине пусто");
        } else {
            System.out.println("Итого: " + sum);
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

