public class Thief extends Npcs {
    private final static int MAXITEMTOSELL = 3;
    private final static double TAXPERCENTAGE = 0.00;

    private final static double WEARPERCENTAGE = 0.25;

    public Thief(String name, String type, String city) {
        super(name, type, city);
    }

    @Override
    public void sell_item(Item item) throws Exception {
        super.sell_item(item);
        double priceWithTax = item.getPrice() * (1 + get_tax_percentage());
        item.setPrice(priceWithTax);
    }

    @Override
    public Item calculatePercentageWear(Item item) {
        super.calculatePercentageWear(item);
        double newWearPercentage = item.getWear() * (1 - get_WEAR_PERCENTAGE());
        item.setWear(newWearPercentage);
        return item;
    }



    // abstract methods
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

