package koszyk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Koszyk {
    private Product[] products;
    private List<Promotion> activePromotions;
    private ProductSorting sortingStrategy;

    public Koszyk() {
        this.products = new Product[0];
        this.activePromotions = new ArrayList<>();
    }

    public void addProduct(Product product) {
        Product[] newProducts = Arrays.copyOf(products, products.length + 1);
        newProducts[products.length] = product;
        products = newProducts;
        sort();
    }

    public void addPromotion(Promotion promotion) {
        activePromotions.add(promotion);
    }

    public void applyPromotions() {
        for (Promotion promotion : activePromotions) {
            promotion.apply(this);
        }
    }
    
    public void setSortingStrategy(ProductSorting strategy) {
        this.sortingStrategy = strategy;
        sort();
    }

    private void sort() {
        if (sortingStrategy != null) {
            sortingStrategy.sort(products);
        }
    }

    public double getTotalValue() {
        if (products == null || products.length == 0) {
            return 0.0;
        }
        return Arrays.stream(products)
                .mapToDouble(Product::getPrice)
                .sum();
    }


    public Product getCheapestProduct() {
        return Arrays.stream(products)
                .min(Comparator.comparingDouble(Product::getPrice))
                .orElse(null);
    }

    public Product getMostExpensiveProduct() {
        return Arrays.stream(products)
                .max(Comparator.comparingDouble(Product::getPrice))
                .orElse(null);
    }

    public Product[] getProducts() {
        return products;
    }
}