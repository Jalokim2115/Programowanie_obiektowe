package koszyk;

import java.util.Arrays;

public class PriceDescending implements ProductSorting {
    @Override
    public void sort(Product[] products) {
        Arrays.sort(products, (p1, p2) -> {
            int priceCompare = Double.compare(p2.getPrice(), p1.getPrice());
            if (priceCompare == 0) {
                return p1.getName().compareTo(p2.getName());
            }
            return priceCompare;
        });
    }
}