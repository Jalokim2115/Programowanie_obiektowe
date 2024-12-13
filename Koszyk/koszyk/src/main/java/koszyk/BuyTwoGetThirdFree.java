package koszyk;

public class BuyTwoGetThirdFree implements Promotion {
    @Override
    public void apply(Koszyk cart) {
        Product[] products = cart.getProducts();
        if (products.length >= 3) {
            
            ProductSorting sorting = new PriceDescending();
            sorting.sort(products); 
    
            
            products[products.length - 1].setDiscountPrice(0.0);
        }
    }
}