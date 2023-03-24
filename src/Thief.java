public class Thief extends Seller3 {
    private final static int MAXITEMTOSELL = 3;
    private final static double TAXPERCENTAGE = 0.00;

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
    public int get_max_inventory_size() {
        return MAXITEMTOSELL;
    }

    @Override
    public double get_tax_percentage() {
        return TAXPERCENTAGE;
    }


}

