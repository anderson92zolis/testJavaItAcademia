import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static Scanner myObj = new Scanner(System.in);

    public static void main(String[] args) throws PersonalizedException {

        Initialization newIni = new Initialization();
        newIni.inicialization();


        boolean sortir = false;

        do {
            switch (menu()) {
                case 1:
                    consultItemsOfSeller();
                    break;
                case 2:
                    CheckSellerCity();
                    break;
                case 3:

                    Item resultOfMinimunPrice = showCheapestItemCiudadLambda();
                    System.out.println(" Name of Item: " + resultOfMinimunPrice.getName() + ", price: " + resultOfMinimunPrice.getPrice());

                    break;
                case 4:
                    showItemsDetTypoSortASC();
                    break;
                case 5:
                    simulateBuyItem();
                    break;
                case 6:
                    simulateSellItem();
                    break;
                case 0:
                    System.out.println("Thanks for use the apps");
                    sortir = true;
                    break;
            }
        } while (!sortir);

    }

    public static byte menu() {
        // Scanner entrada = new Scanner(System.in);
        byte opcio;
        final byte MINIMO = 0;
        final byte MAXIMO = 6;

        do {

            System.out.println("Choose which option you want to perform from the following menu: " +
                    "\n " + "1. Consultar los los ítems de un vendedor." +
                    "\n " + "2. Consultar los vendedores que hay en una ciudad " +
                    "\n " + "3. Mostrar el ítems más barato de todos los vendedores de una ciudad ->lambdas" +
                    "\n " + "4. Mostrar todos los ítems de un determinado tipo ordenados por precio (asc) -> lambdas" +
                    "\n " + "5. Simular la compra de un ítem a un NPC" +
                    "\n " + "6. Simular la venta de un ítem a un NPC" +
                    "\n " + "0. Exit the application. " + "\n");

            System.out.print("Choose a number from 0 to 6:" + "\r");

            opcio = myObj.nextByte();
            if (opcio < MINIMO || opcio > MAXIMO) {
                System.out.println("Choose a valid option");
            }
        } while (opcio < MINIMO || opcio > MAXIMO);
        return opcio;
    }

    public static void consultItemsOfSeller() {

        // 1. Consultar los los ítems de un vendedor.

        myObj.nextLine();
        System.out.println("Enter a name of seller: ");
        String inputName = myObj.nextLine();

        for (Npcs sell : Initialization.getMySellers()) {
            if (sell.getName().equalsIgnoreCase(inputName)) {
                System.out.println(sell.get_inventory());
            }
        }
    }

    public static void CheckSellerCity() {

        //2. Consultar los vendedores que hay en una ciudad.

        myObj.nextLine();
        System.out.println("Enter a city to check the sellers: ");
        String inputCity = myObj.nextLine();

        for (Npcs sell : Initialization.getMySellers()) {
            if (sell.getCity().equalsIgnoreCase(inputCity)) {
                System.out.println(sell.getName());
            }
        }
    }


    public static Item showCheapestItemCiudadLambda() {

        //3 .Mostrar el ítems más barato de todos los vendedores de una ciudad ->lambdas

        myObj.nextLine();
        System.out.println("Enter a city to check the sellers: ");
        String inputCity = myObj.nextLine();

        List<Item> resultOfItemInCity = Initialization.getMySellers().stream()
                .filter(seller -> seller.getCity().equalsIgnoreCase(inputCity))
                .flatMap(seller -> seller.get_inventory().stream())
                .collect(Collectors.toList());

        Optional<Item> cheapItems = resultOfItemInCity.stream()
                .min(Comparator.comparingDouble(Item::getPrice));

        if (cheapItems.isPresent()) {
            return cheapItems.get();
        } else {
            return null;
        }
    }


    public static void showItemsDetTypoSortASC() {

        // 4. Mostrar todos los ítems de un determinado tipo ordenados por precio (asc) -> lambdas

        myObj.nextLine();
        System.out.println("Enter a type of Item to order by price: ");
        String inputType = myObj.nextLine();

        List<Item> resultOfItemByType = Initialization.getMySellers().stream()
                .flatMap(seller -> seller.get_inventory().stream())
                .collect(Collectors.toList());

        List<Item> itemsOfColor = resultOfItemByType.stream()
                .filter(item -> item.getType().equals(inputType))
                .sorted((item1, item2) -> Double.compare(item1.getPrice(), item2.getPrice()))
                .collect(Collectors.toList());

        for (Item item : itemsOfColor) {
            System.out.println(item.getName() + " - " + item.getPrice());
        }
    }

    public static void simulateBuyItem() {

        // 5- Simular la compra de un ítem a un NPC.

        printNPCsavailable();

        myObj.nextLine();
        System.out.println("\nEnter a Name of Category NPCs to buy: ");
        String inputCategoryName = myObj.nextLine();

        System.out.println("Enter a name of Item To Buy: ");
        String itemName = myObj.nextLine();

        int indexNPCs = CategoryNPCs(inputCategoryName);
        int indexNPCsBuyer = -1;
        int indexItem = Initialization.getMySellers().get(indexNPCs).lookForItem(itemName);

        if (indexNPCs != -1 && indexItem != -1) {

            System.out.println("Enter a name of the buyer: ");
            String NameBuyer = myObj.nextLine();

            String type = "BUYER";
            System.out.println("Enter a name of city: ");
            String cityName = myObj.nextLine();

            indexNPCsBuyer = CategoryNPCs(NameBuyer);

            Item itemtoBuy = Initialization.getMySellers().get(indexNPCs).get_inventory().get(indexItem);
            Item cloneItem = itemtoBuy.clone(itemtoBuy);

            if (indexNPCsBuyer == -1) {

                Buyer myBuyer = new Buyer(NameBuyer, type, cityName);
                Initialization.addSellers(myBuyer);
                indexNPCsBuyer = CategoryNPCs(myBuyer.getName());
                Initialization.getMySellers().get(indexNPCsBuyer).get_inventory().add(cloneItem);

                System.out.println("successful purchase ");
                Initialization.getMySellers().get(indexNPCs).get_inventory().remove(indexItem);
            } else {
                try {
                    if (Initialization.getMySellers().get(indexNPCsBuyer).can_add_item()) {
                        Initialization.getMySellers().get(indexNPCsBuyer).get_inventory().add(cloneItem);
                        System.out.println("successful purchase ");
                        Initialization.getMySellers().get(indexNPCs).get_inventory().remove(indexItem);
                    } else {
                        throw new PersonalizedException();
                    }
                } catch (PersonalizedException e) {
                    System.out.println("The user can't add more items : " + e.getMessage());
                }
            }
        } else {
            System.out.println("name of Category NPCs or name Items are Incorrect!");
        }
    }

    public static void simulateSellItem() throws PersonalizedException {

        // 6. Simular la venta de un ítem a un NPC.*

        printNPCsavailable();

        myObj.nextLine();
        System.out.println("\nEnter a Name of Category NPCs to sell: ");
        String inputCategoryName = myObj.nextLine();

        System.out.println("Enter a name of Item To sell: ");
        String itemName = myObj.nextLine();

        int indexNPCs = CategoryNPCs(inputCategoryName);
        int indexNPCsBuyer = -1;
        int indexItem = Initialization.getMySellers().get(indexNPCs).lookForItem(itemName);

        if (indexNPCs != -1 && indexItem != -1) {

            System.out.println("Enter a name of the buyer to sell: ");
            String NameBuyer = myObj.nextLine();

            String type = "BUYER";
            System.out.println("Enter a name of city: ");
            String cityName = myObj.nextLine();

            indexNPCsBuyer = CategoryNPCs(NameBuyer);

            Item itemtoBuy = Initialization.getMySellers().get(indexNPCs).get_inventory().get(indexItem);
            Item cloneItem = itemtoBuy.clone(itemtoBuy);

            if (indexNPCsBuyer == -1) {

                Buyer myBuyer = new Buyer(NameBuyer, type, cityName);
                Initialization.addSellers(myBuyer);
                indexNPCsBuyer = CategoryNPCs(myBuyer.getName());
                Initialization.getMySellers().get(indexNPCsBuyer).get_inventory().add(cloneItem);

                System.out.println("successful purchase ");
                Initialization.getMySellers().get(indexNPCs).get_inventory().remove(indexItem);

            } else {
                try {
                    if (Initialization.getMySellers().get(indexNPCsBuyer).can_add_item()) {
                        Initialization.getMySellers().get(indexNPCsBuyer).get_inventory().add(cloneItem);
                        System.out.println("successful purchase ");
                        Initialization.getMySellers().get(indexNPCs).get_inventory().remove(indexItem);
                    } else {
                        throw new PersonalizedException();
                    }
                } catch (PersonalizedException e) {
                    System.out.println("The user can't add more items : " + e.getMessage());
                }
            }
        } else {
            System.out.println("name of Name of Category NPCs or Items Incorrect!");
        }
    }

    public static int CategoryNPCs(String TypeNPCs) {
        int index = 0;
        int iFindingOrNot = -1;
        while (index < Initialization.getMySellers().size() && iFindingOrNot == -1) {
            if (Initialization.getMySellers().get(index).getName().equalsIgnoreCase(TypeNPCs)) {
                iFindingOrNot = index;
            }
            index++;
        }
        return iFindingOrNot;
    }

    public static void printNPCsavailable() {

        for (int index = 0; index < Initialization.getMySellers().size(); index++) {

            if (Initialization.getMySellers().get(index) instanceof Farmer) {

                Farmer Castingfarmer = (Farmer) Initialization.getMySellers().get(index);

                System.out.println("\nName: " + Castingfarmer.getName() +
                        ", Type: " + Castingfarmer.getType() + ", City: " +
                        Castingfarmer.getCity() + " InventoryItems: \n" + Castingfarmer.get_inventory());

            } else if (Initialization.getMySellers().get(index) instanceof Thief) {

                Thief castingThief = (Thief) Initialization.getMySellers().get(index);

                System.out.println("\nName: " + castingThief.getName() +
                        ", Type: " + castingThief.getType() + ", City: " +
                        castingThief.getCity() + " InventoryItems: \n" + castingThief.get_inventory());


            } else if (Initialization.getMySellers().get(index) instanceof Merchant) {

                Merchant castingMerchant = (Merchant) Initialization.getMySellers().get(index);

                System.out.println("\nName: " + castingMerchant.getName() +
                        ", Type: " + castingMerchant.getType() + ", City: " +
                        castingMerchant.getCity() + " InventoryItems: \n" + castingMerchant.get_inventory());

            } else {
                Buyer castingBuyer = (Buyer) Initialization.getMySellers().get(index);

                System.out.println("\nName: " + castingBuyer.getName() +
                        ", Type: " + castingBuyer.getType() + ", City: " +
                        castingBuyer.getCity() + " InventoryItems: \n" + castingBuyer.get_inventory());
            }
        }
    }
}