import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static Scanner myObj  = new Scanner(System.in);
    static List<Seller> mySellers = new ArrayList<>();


    public static void main(String[] args) {
        Item item1 = new Item("camion", "objeto", 10.0, 25 / 100);
        Item item2 = new Item("conejo", "animal", 20.0, 25 / 100);
        Item item3 = new Item("camarero", "humano", 15.0, 25 / 100);
        Item item4 = new Item("pelota", "objeto", 8.0, 25 / 100);

        Item item5 = new Item("futbolista", "humano", 25.0, 15 / 100);
        Item item6 = new Item("lapiz", "objeto", 18.0, 15 / 100);
        Item item7 = new Item("arbol", "planta", 12.0, 15 / 100);
        Item item8 = new Item("nido", "planta", 30.0, 15 / 100);

        Item item9 = new Item("laguna", "objeto", 22.0, 0);
        Item item10 = new Item("perro", "animal", 7.0, 0);


        Farmer myFarmer = new Farmer("Juan", "FARMER", "barcelona");
        Thief myThief = new Thief("Pedro", "Thief", "madrid");
        Merchant myMerchant = new Merchant("Maria", "Merchant", "london");


        myFarmer.add_item(item1);
        myFarmer.add_item(item2);
        myFarmer.add_item(item3);
        myFarmer.add_item(item4);
        myThief.add_item(item5);
        myThief.add_item(item6);
        myThief.add_item(item7);
        myThief.add_item(item8);
        myMerchant.add_item(item9);
        myMerchant.add_item(item10);

        System.out.println(myFarmer);

        mySellers.add(myFarmer);
        mySellers.add(myThief);
        mySellers.add(myMerchant);

        System.out.println(mySellers);


        showCheapestItemCiudadLambda();



        /*

        boolean sortir = false;

        do{
            switch(menu()){
                case 1:
                    consultItemsOfSeller();
                    break;
                case 2:
                    consultItemsOfSeller();
                    break;
                case 3:
                    showCheapestItemCiudadLambda();
                    break;
                case 4:
                    showItemsDetTypoSortASC();
                    break;
                case 5:
                     simulateBuyAItem();
                    break;
                case 6: simulateBuyAItem();
                    break;
                case 0: System.out.println("Gràcies per utilitzar l'aplicació");
                    sortir = true;
                    break;
            }
        }while(!sortir);

        */

    }

    public static byte menu(){
        // Scanner entrada = new Scanner(System.in);
        byte opcio;
        final byte MINIMO = 0;
        final byte MAXIMO = 6;

        do{
            System.out.println("Choose which option you want to perform from the following menu: " +
                    "\n " + "1. Consultar los los ítems de un vendedor." +
                    "\n " + "2. Consultar los vendedores que hay en una ciudad " +
                    "\n " + "3. Mostrar el ítems más barato de todos los vendedores de una ciudad ->lambdas" +
                    "\n " + "4. Mostrar todos los ítems de un determinado tipo ordenados por precio (asc) -> lambdas" +
                    "\n " + "5. Simular la compra de un ítem a un NPC" +
                    "\n " + "6. Simular la venta de un ítem a un NPC" +
                    "\n " + "0. Exit the application. " +"\n" );
            System.out.print("Choose a number from 0 to 6:"+ "\r" );

            opcio = myObj.nextByte();
            if(opcio < MINIMO || opcio > MAXIMO){
                System.out.println("Choose a valid option");
            }
        }while(opcio < MINIMO || opcio > MAXIMO);
        return opcio;
    }


    // consulta los item de un vendedor

    public static void  consultItemsOfSeller(){

        // 1. Consultar los los ítems de un vendedor.

        System.out.println("Enter a name of seller: ");
        String inputName= myObj.nextLine();
        for (Seller sell:mySellers){
            if (sell.getName().equalsIgnoreCase(inputName)){
                System.out.println(sell.get_inventory());
            }
        }
    }

    public static void  CheckSellerCity(){

        //2. Consultar los vendedores que hay en una ciudad.

        System.out.println("Enter a city to check the sellers: ");
        String inputCity= myObj.nextLine();
        for (Seller sell:mySellers){
            if (sell.getCity().equalsIgnoreCase(inputCity)){
                System.out.println(sell.getName());
            }
        }
    }


    public static void  showCheapestItemCiudadLambda(){

        //3 .Mostrar el ítems más barato de todos los vendedores de una ciudad ->lambdas

        System.out.println("Enter a city to check the sellers: ");
        String inputCity= myObj.nextLine();
        for (Seller sell:mySellers){
            if (sell.getCity().equalsIgnoreCase(inputCity)){
                double find=0;
                for (Item item: sell.get_inventory()){
                    if (item.getPrice()>find){
                        find=  item.getPrice();
                    }
                }
            }
        }

        /*   System.out.println("Enter a city to check the sellers: ");
        String inputCity= myObj.nextLine();

        for (Seller sell:mySellers){
            if (sell.getCity().equalsIgnoreCase(inputCity)){
                List<Item> cheapestItem = sell.get_inventory()
                        .stream().sorted((Item i1, Item i2)-> (int)i1.getPrice() - (int)i2.getPrice())
                        .limit(1).collect(Collectors.toList());
                System.out.println("Cheapest item: " + cheapestItem + " at " + sell.get_inventory());
            }
        }*/

    }


    public static void  showItemsDetTypoSortASC(){

       // 4. Mostrar todos los ítems de un determinado tipo ordenados por precio (asc) -> lambdas

        System.out.println("Enter a city to check the sellers: ");
        String inputCity= myObj.nextLine();

        for (Seller sell:mySellers){
            if (sell.getCity().equalsIgnoreCase(inputCity)){
                Item cheapestItem = mySellers.stream()
                        .flatMap(x -> x.get_inventory().stream())
                        .min(Comparator.comparing(Item::getPrice))
                        .orElse(null);
                System.out.println("Cheapest item: " + cheapestItem.getPrice() ); // " at " cheapestItem.getName()
            }
        }


    }

    public static void  simulateBuyAItem(){

        // 5- Simular la compra de un ítem a un NPC.


    }

    public static void  simulateSellAItem(){

        // 6. Simular la venta de un ítem a un NPC.*


    }

}