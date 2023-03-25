public class Buyer extends Seller3 {

    private final static int MAXITEMTOSELL = 100;
    private final static double TAXPERCENTAGE = 4/100;

    public Buyer(String name, String type, String city) {
        super(name, type, city);
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
