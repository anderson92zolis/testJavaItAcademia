import java.util.ArrayList;
import java.util.List;

public class Initialization {

    static List<Npcs> mySellers = new ArrayList<>();

    static void inicialization() {

        Item item1 = new Item("camion", "objeto", 10.0, 150);
        Item item2 = new Item("conejo", "animal", 20.0, 150);
        Item item3 = new Item("perro", "animal", 15.0, 150);
        Item item4 = new Item("cable", "objeto", 8.0, 150);

        Item item5 = new Item("mouse", "animal", 25.0, 250);
        Item item6 = new Item("lapiz", "objeto", 18.0, 250);


        Item item7 = new Item("arbol", "planta", 12.0,500);
        Item item8 = new Item("doctor", "humano", 30.0, 500);
        Item item9 = new Item("laguna", "objeto", 22.0, 500);
        Item item10 = new Item("perro", "animal", 7.0, 500);
        Item item11 = new Item("laguna", "objeto", 22.0, 500);
        Item item12 = new Item("perro", "animal", 7.0, 500);


        Farmer myFarmer = new Farmer("Juan", "FARMER", "barcelona");
        Thief myThief = new Thief("Pedro", "THIEF", "madrid");
        Merchant myMerchant = new Merchant("Maria", "MERCHANT", "london");

        myFarmer.add_item(item1);
        myFarmer.add_item(item2);
        myFarmer.add_item(item3);
        myFarmer.add_item(item4);

        myThief.add_item(item5);
        myThief.add_item(item6);

        myMerchant.add_item(item7);
        myMerchant.add_item(item8);
        myMerchant.add_item(item9);
        myMerchant.add_item(item10);
        myMerchant.add_item(item11);
        myMerchant.add_item(item12);

        mySellers.add(myFarmer);
        mySellers.add(myThief);
        mySellers.add(myMerchant);
    }

    public static void addSellers(Npcs seller) {
        mySellers.add(seller);
    }

    public static List<Npcs> getMySellers() {
        return mySellers;
    }

}
