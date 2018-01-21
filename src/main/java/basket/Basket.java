package basket;

import discount.IDiscount;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Item> items;
    private ArrayList<IDiscount> discounts;
    private double total;

    public Basket(){
        this.items = new ArrayList<>();
        this.discounts = new ArrayList<>();
        total = 0;
    }

    public double getTotal(){
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int NumberOfItems(){
        return this.items.size();
    }

    public void addNewItem(Item item){
        this.items.add(item);
        this.total += item.getPrice();
    }

    public void removeItem(Item item){
        this.items.remove(item);
        total -= item.getPrice();
    }

    public void removeAll(){
        this.total = 0;
        this.items = new ArrayList<>();

    }

    public double calculateTotal(){
        double total = 0;
        for (Item item : items){
            total += item.getPrice();
        }
        return total;
    }

    public void applyDiscount(){
        for(IDiscount discount : discounts){
            setTotal(discount.applyDiscount(items,total));
        }
    }

    public void addDiscount(IDiscount discount){
        this.discounts.add(discount);
    }




}
