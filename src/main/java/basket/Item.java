package basket;

public class Item {
    String name;
    Double price;

    public Item(String name, Double price){
        this.price = price;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public Double getPrice(){
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

  public void setPrice(Double price){
        this.price = price;
  }
}
