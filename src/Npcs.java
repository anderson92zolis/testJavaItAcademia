import java.util.ArrayList;
import java.util.List;

public abstract class Npcs {
    private String name;
    private String type;
    private String city;
    private List<Item> inventory;

    public Npcs(String name, String type, String city) {
        this.name = name;
        this.type = type;
        this.city = city;
        this.inventory = new ArrayList<>();
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

    public void add_item(Item item) {
        inventory.add(calculatePercentageWear(item));
    }

    public List<Item> get_inventory() {
        return inventory;
    }

    /*


    public void sell_item(Item item) throws Exception {
        if (!inventory.contains(item)) {
            throw new Exception("Item not found in inventory!");
            }
        inventory.remove(item);
    }

     */

    public abstract void sell_item(Item item);


    public abstract Item calculatePercentageWear(Item item);

    public abstract int get_max_inventory_size();

    public abstract double get_tax_percentage();

    public abstract double get_WEAR_PERCENTAGE();

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

