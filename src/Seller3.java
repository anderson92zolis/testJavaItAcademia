import java.util.ArrayList;
import java.util.List;

public abstract class Seller3 {
    private String name;
    private String type;
    private String city;
    private List<Item> inventory;

    public Seller3(String name, String type, String city) {
        this.name = name;
        this.type = type;
        this.city = city;
        this.inventory = new ArrayList<>();
    }

    public void add_item(Item item) {
        inventory.add(item);
    }

    public List<Item> get_inventory() {
        return inventory;
    }

    public void sell_item(Item item) throws Exception {
        if (!inventory.contains(item)) {
            throw new Exception("Item not found in inventory!");
        }
        inventory.remove(item);
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getCity() {
        return city;
    }

    public boolean can_add_item() {
        return inventory.size() < get_max_inventory_size();
    }

    public abstract int get_max_inventory_size();

    public abstract double get_tax_percentage();

    public int lookForItem(String nameITEM) {
        int index = 0;
        int iFindingOrNot = -1;
        while (index < inventory.size() && iFindingOrNot == -1) {
            if (inventory.get(index).getName().equalsIgnoreCase(nameITEM)) {
                iFindingOrNot = index;
            }
            index++;
        }
        return iFindingOrNot;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", city='" + city + '\'' +
                ", inventory=" + inventory +
                '}';
    }
}
