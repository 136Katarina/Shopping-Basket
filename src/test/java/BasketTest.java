import basket.Basket;
import basket.Item;
import discount.LoyaltyCard;
import discount.SpendOverDiscount;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasketTest {
    Basket basket;
    Item item1;
    Item item2;
    Item item3;
    LoyaltyCard loyaltyCard;
    SpendOverDiscount tenOff;

    @Before
    public void before(){
        basket = new Basket();
        item1 = new Item("Blender", 40.00);
        item2 = new Item("Book", 25.00);
        item3 = new Item("Pillow", 50.00);
        basket.addNewItem(item1);
        basket.addNewItem(item2);
        basket.addNewItem(item3);
        loyaltyCard = new LoyaltyCard();
        tenOff = new SpendOverDiscount();

    }

    @Test
    public void canGetTotal(){
        assertEquals(115.00, basket.getTotal(), 0.05);
    }

    @Test
    public void canRemoveItem(){
        basket.removeItem(item3);
        basket.removeItem(item2);
        assertEquals(1, basket.NumberOfItems());
        assertEquals(40.00, basket.getTotal(),0.05);
    }

    @Test
    public void canClearBasket(){
        assertEquals(3, basket.NumberOfItems());
        basket.removeAll();
        assertEquals(0, basket.NumberOfItems());
    }

    @Test
    public void canApplyLoyaltyCard(){
        basket.addDiscount(loyaltyCard);
        basket.applyDiscount();
        assertEquals(112.70, basket.getTotal(), 0.50);
    }

    @Test
    public void canApplyTenOff(){
        basket.addDiscount(tenOff);
        basket.applyDiscount();
        assertEquals(103.5, basket.getTotal(), 0.50);

    }
}
