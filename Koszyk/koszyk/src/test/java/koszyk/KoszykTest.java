package koszyk;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

public class KoszykTest {
    private Koszyk koszyk;
    private Product product1;
    private Product product2;
    private Product product3;

    @Before
    public void setUp() {
        koszyk = new Koszyk();
        product1 = new Product("001", "Produkt A", 100.0);
        product2 = new Product("002", "Produkt B", 200.0);
        product3 = new Product("003", "Produkt C", 50.0);
    }

    @Test
    public void AddProductToCart() {
        
        koszyk.addProduct(product1);

        
        assertEquals(100.0, koszyk.getTotalValue(), 0.001);
    }

    @Test
    public void FindCheapestProduct() {
        
        koszyk.addProduct(product1);
        koszyk.addProduct(product2);
        koszyk.addProduct(product3);

        
        Product cheapest = koszyk.getCheapestProduct();

        
        assertEquals(50.0, cheapest.getPrice(), 0.001);
        assertEquals("Produkt C", cheapest.getName());
    }

    @Test
    public void FindMostExpensiveProduct() {
        
        koszyk.addProduct(product1);
        koszyk.addProduct(product2);
        koszyk.addProduct(product3);

        
        Product mostExpensive = koszyk.getMostExpensiveProduct();

        
        assertEquals(200.0, mostExpensive.getPrice(), 0.001);
        assertEquals("Produkt B", mostExpensive.getName());
    }

    @Test
    public void CalculateTotalValue() {
        
        koszyk.addProduct(product1);
        koszyk.addProduct(product2);
        koszyk.addProduct(product3);

        
        double total = koszyk.getTotalValue();

        
        assertEquals(350.0, total, 0.001);
    }

    @Test
    public void ApplyValueBasedDiscount() {
        
        koszyk.addProduct(product1); // 100.0
        koszyk.addProduct(product2); // 200.0
        koszyk.addProduct(product3); // 50.0
        koszyk.addPromotion(new ValueBasedDiscount());

        
        koszyk.applyPromotions();

        
        
        assertEquals(332.5, koszyk.getTotalValue(), 0.001);
    }

    @Test
    public void ApplyBuyTwoGetThirdFreePromotion() {
        
        koszyk.addProduct(product1); // 100.0
        koszyk.addProduct(product2); // 200.0
        koszyk.addProduct(product3); // 50.0 - powinno być za darmo
        koszyk.addPromotion(new BuyTwoGetThirdFree());

        
        koszyk.applyPromotions();

        
        assertEquals(0.0,product3.getPrice(),0.001);
        assertEquals(300.0, koszyk.getTotalValue(), 0.001);
    }

    @Test
    public void SortProductsByPriceDescending() {
        
        koszyk.addProduct(product3); // 50.0
        koszyk.addProduct(product1); // 100.0
        koszyk.addProduct(product2); // 200.0
        koszyk.setSortingStrategy(new PriceDescending());

        
        Product[] products = koszyk.getProducts();

        
        assertEquals(200.0, products[0].getPrice(), 0.001);
        assertEquals(100.0, products[1].getPrice(), 0.001);
        assertEquals(50.0, products[2].getPrice(), 0.001);
    }

    @Test
    public void ReturnNullForEmptyCartCheapestProduct() {
        
        Product cheapest = koszyk.getCheapestProduct();

        
        assertNull(cheapest);
    }

    @Test
    public void ReturnZeroTotalValueForEmptyCart() {
        
        double total = koszyk.getTotalValue();

        
        assertEquals(0.0, total, 0.001);
    }
}