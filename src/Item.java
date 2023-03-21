public class Item {
     private String name;
     private String type;
     private double price;
     private int wearPorcentage;

    public Item(String name, String type, double price,int wearPorcentage) {
        this.name = name;
        this.type = type;
        this.price = price;
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

    public int getWearPorcentage() {
        return wearPorcentage;
    }

    public void setWearPorcentage(int wearPorcentage) {
        this.wearPorcentage = wearPorcentage;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", wearPorcentage=" + wearPorcentage +
                '}';
    }
}
