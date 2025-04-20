package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        Product cucumber = new SimpleProduct("огурец", 200);
        Product tomato = new SimpleProduct("помидор", 110);
        Product banana = new SimpleProduct("банан", 150);
        Product chicken = new SimpleProduct("курятина", 210);
        Product pig = new SimpleProduct("свинина", 310);
        Product milk = new SimpleProduct("молоко", 100);
        Product beer = new SimpleProduct("пиво", 115);
        Product oatmeal = new SimpleProduct("овсянка", 80);
        Product apple = new SimpleProduct("яблоко", 155);
        Product orange = new SimpleProduct("апельсин", 180);
        SimpleProduct fish = new SimpleProduct("рыба", 200);
        DiscountedProduct eggs = new DiscountedProduct("яйца", 1000, 50);
        FixPriceProduct tea = new FixPriceProduct("чай");

        ProductBasket firstProductBasket = new ProductBasket();
        firstProductBasket.addProduct(tea);
        firstProductBasket.addProduct(tomato);
        firstProductBasket.addProduct(milk);
        firstProductBasket.addProduct(eggs);
        firstProductBasket.addProduct(fish);
        firstProductBasket.addProduct(cucumber);

        ProductBasket secondProductBasket = new ProductBasket();

        firstProductBasket.printProductBasket();
        System.out.println();
        secondProductBasket.printProductBasket();
        System.out.println();
        System.out.println(firstProductBasket.searchProduct("чай"));
        System.out.println(firstProductBasket.searchProduct("перец"));
        System.out.println(secondProductBasket.searchProduct("перец"));
        System.out.println();
        firstProductBasket.clear();
        firstProductBasket.printProductBasket();
        System.out.println();
        System.out.println(firstProductBasket.searchProduct("хлеб"));

    }
}
