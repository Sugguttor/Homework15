package org.skypro.skyshop;

import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFoundException;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws IllegalArgumentException, BestResultNotFoundException {

        Product cucumber = new SimpleProduct("огурец", 200);
        Product tomato = new SimpleProduct("помидор", 110);
        Product banana = new SimpleProduct("банан", 150);
        Product chicken = new SimpleProduct("курица", 210);
        Product pig = new SimpleProduct("свинина", 300);
        Product milk = new SimpleProduct("молоко", 100);
        Product beer = new SimpleProduct("пиво", 115);
        Product oatmeal = new SimpleProduct("овсянка", 80);
        Product apple = new SimpleProduct("яблоко", 155);
        Product orange = new SimpleProduct("апельсин", 180);

        SimpleProduct fish = new SimpleProduct("рыба", 200);
        DiscountedProduct eggs = new DiscountedProduct("яйца", 1000, 50);
        FixPriceProduct tea = new FixPriceProduct("чай");
        Article article1 = new Article("Безопасность мореплавания.", "Средства навигационного оборудования - самая важная отрасль.");
        Article article2 = new Article("Маяки России.", "Первый этап проекта — электронная энциклопедия российских исторических маяков.");
        Article article3 = new Article("Маяки народов России.", "Второй этап проекта — сбор и оцифровка фотоархивов.");

        ProductBasket firstProductBasket = new ProductBasket();

        firstProductBasket.addProduct(tea);
        firstProductBasket.addProduct(tomato);
        firstProductBasket.addProduct(milk);
        firstProductBasket.addProduct(eggs);
        firstProductBasket.addProduct(fish);
        firstProductBasket.addProduct(cucumber);

        ProductBasket secondProductBasket = new ProductBasket();
        secondProductBasket.addProduct(pig);
        secondProductBasket.addProduct(chicken);

        firstProductBasket.printProductBasket();
        System.out.println();

        secondProductBasket.printProductBasket();
        System.out.println();

        System.out.println(firstProductBasket.searchProduct("чай"));
        System.out.println(firstProductBasket.searchProduct("перец"));
        System.out.println(secondProductBasket.searchProduct("перец"));
        System.out.println();

        System.out.println(firstProductBasket.removeThisProduct("помидор"));
        System.out.println();

        firstProductBasket.printProductBasket();
        System.out.println();

        System.out.println(secondProductBasket.removeThisProduct("помидор"));


        firstProductBasket.clear();
        firstProductBasket.printProductBasket();
        System.out.println();
        System.out.println(firstProductBasket.searchProduct("хлеб"));

        SearchEngine searchEngine1 = new SearchEngine();
        searchEngine1.add(beer);
        searchEngine1.add(banana);
        searchEngine1.add(oatmeal);
        searchEngine1.add(apple);
        searchEngine1.add(orange);
        searchEngine1.add(article2);
        searchEngine1.add(article1);
        searchEngine1.add(article3);

        System.out.println();

        System.out.println();
        System.out.println(searchEngine1.search("Маяки"));
        System.out.println(searchEngine1.search("пиво"));
        System.out.println(searchEngine1.search("банан"));

        try {
            Searchable bestMatch = searchEngine1.findBestMatch("Маяки");
            System.out.println("Наиболее подходящий объект: " + bestMatch.getSearchTerm());
        } catch (BestResultNotFoundException e) {
            System.err.println(e);
        }

        try {
            Searchable bestMatch = searchEngine1.findBestMatch("собака");
            System.out.println("Наиболее подходящий объект: " + bestMatch.getSearchTerm());
        } catch (BestResultNotFoundException e) {
            System.err.println("Ошибка: " + e);
        }

        try {
            chicken = new SimpleProduct("    ", 210);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            pig = new SimpleProduct("свинина", 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }
}

