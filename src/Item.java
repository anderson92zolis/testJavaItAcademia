public class Item {
     private String name;
     private String type;
     private double price;
     private double wear;

    public Item(String name, String type, double price,double wear) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.wear = wear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWear() {
        return wear;
    }

    public void setWear(double wear) {
        this.wear = wear;
    }

    public Item clone(Item item){
        return new Item(item.getName(),item.getType(),item.getPrice(),item.getWear()); // bueno

    };

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", wearPorcentage=" + wear +
                '}';
    }
}
