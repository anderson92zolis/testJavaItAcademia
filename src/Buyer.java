public class Buyer extends Npcs {

    private final static int MAXITEMTOSELL = 2;
    private final static double TAXPERCENTAGE = 1/100;
    private final static double WEARPERCENTAGE = 0;

    public Buyer(String name, String type, String city) {
        super(name, type, city);
    }

    @Override
    public Item calculatePercentageWear(Item item) {
        double newWearPercentage = item.getWear() * (1 - get_WEAR_PERCENTAGE());
        item.setWear(newWearPercentage);
        return item;
    }

    @Override
    public int get_max_inventory_size() {
        return MAXITEMTOSELL;
    }

    @Override
    public double get_tax_percentage() {
        return TAXPERCENTAGE;
    }

    @Override
    public double get_WEAR_PERCENTAGE() {
        return WEARPERCENTAGE;
    }
}
