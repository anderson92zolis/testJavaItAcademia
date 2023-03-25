public class Farmer extends Npcs {
    private final static int MAXITEMTOSELL = 5;
    private final static double TAXPERCENTAGE = 0.02;

    public Farmer(String name, String type, String city) {
        super(name, type, city);
    }

    @Override
    public void sell_item(Item item) throws Exception {
        super.sell_item(item);
        double priceWithTax = item.getPrice() * (1 + get_tax_percentage());
        item.setPrice(priceWithTax);
    }

    @Override
    public int get_max_inventory_size() {
        return MAXITEMTOSELL;
    }

    @Override
    public double get_tax_percentage() {

        return TAXPERCENTAGE;
    }



}

