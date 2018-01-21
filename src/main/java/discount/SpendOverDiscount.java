package discount;

import basket.Item;

import java.util.ArrayList;

public class SpendOverDiscount implements IDiscount {
    @Override
    public double applyDiscount(ArrayList<Item> items, double total) {
        if (total >= 20) {
            return total -= 0.1 * total;
        }
        return
                total;
    }
}
