package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product cucumber = new Product("огурец", 200);
        Product tomato = new Product("помидор", 110);
        Product banana = new Product("банан", 150);
        Product chicken = new Product("курятина", 210);
        Product pig = new Product("свинина", 310);
        Product milk = new Product("молоко", 100);
        Product beer = new Product("пиво", 115);
        Product oatmeal = new Product("овсянка", 80);
        Product apple = new Product("яблоко", 155);
        Product orange = new Product("апельсин", 180);

        ProductBasket firstProductBasket = new ProductBasket();
        firstProductBasket.addProduct(cucumber);
        firstProductBasket.addProduct(tomato);
        firstProductBasket.addProduct(milk);
        firstProductBasket.addProduct(beer);
        firstProductBasket.addProduct(apple);
        firstProductBasket.addProduct(orange);

        ProductBasket secondProductBasket = new ProductBasket();

        firstProductBasket.printProductBasket();
        System.out.println();
        secondProductBasket.printProductBasket();
        System.out.println();
        System.out.println(firstProductBasket.searchProduct("огурец"));
        System.out.println(firstProductBasket.searchProduct("перец"));
        System.out.println(secondProductBasket.searchProduct("перец"));
        System.out.println();
        firstProductBasket.clear();
        firstProductBasket.printProductBasket();
        System.out.println();
        System.out.println(firstProductBasket.searchProduct("хлеб"));

    }
}
