package koszyk;

public class ValueBasedDiscount implements Promotion {
    @Override
    public void apply(Koszyk cart) {
        double totalValue = cart.getTotalValue();
        if (totalValue > 300) {
            Product[] products = cart.getProducts();
            for (Product product : products) {
                double newPrice = product.getPrice() * 0.95; // 5% zniżki
                product.setDiscountPrice(newPrice);
            }
        }
    }
}