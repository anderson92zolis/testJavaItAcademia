import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static Scanner myObj  = new Scanner(System.in);

    public static void main(String[] args) {

        Initialization newIni= new Initialization();
        newIni.inicialization();


        boolean sortir = false;

        do{
            switch(menu()){
                case 1:
                    consultItemsOfSeller();
                    break;
                case 2:
                    CheckSellerCity();
                    break;
                case 3:

                     Item resultOfMinimunPrice = showCheapestItemCiudadLambda();
                     System.out.println(" Name of Item: " + resultOfMinimunPrice.getName()+", price: "+ resultOfMinimunPrice.getPrice());

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
        myObj.nextLine();

        System.out.println("Enter a name of seller: ");
        String inputName= myObj.nextLine();
        for (Seller sell:Initialization.getMySellers()){
            if (sell.getName().equalsIgnoreCase(inputName)){
                System.out.println(sell.get_inventory());
            }
        }
    }

    public static void  CheckSellerCity(){

        //2. Consultar los vendedores que hay en una ciudad.
        myObj.nextLine();

        System.out.println("Enter a city to check the sellers: ");
        String inputCity= myObj.nextLine();
        for (Seller sell:Initialization.getMySellers()){
            if (sell.getCity().equalsIgnoreCase(inputCity)){
                System.out.println(sell.getName());
            }
        }
    }


    public static  Item  showCheapestItemCiudadLambda(){

        //3 .Mostrar el ítems más barato de todos los vendedores de una ciudad ->lambdas
        myObj.nextLine();
        System.out.println("Enter a city to check the sellers: ");
        String inputCity= myObj.nextLine();

        List<Item> resultOfItemInCity = Initialization.getMySellers().stream()
                        .filter(seller-> seller.getCity().equalsIgnoreCase(inputCity))
                        .flatMap(seller -> seller.get_inventory().stream())
                        .collect(Collectors.toList());

        Optional<Item> cheapItems = resultOfItemInCity.stream()
                .min(Comparator.comparingDouble(Item::getPrice));

        if(cheapItems.isPresent()){
            return  cheapItems.get();
        } else {
            return null;
        }
    }


    public static void showItemsDetTypoSortASC(){

       // 4. Mostrar todos los ítems de un determinado tipo ordenados por precio (asc) -> lambdas

        myObj.nextLine();
        System.out.println("Enter a type of Item to order by price: ");
        String inputType=   myObj.nextLine();

        List<Item> resultOfItemByType = Initialization.getMySellers().stream()
                .filter(seller-> seller.getType().equalsIgnoreCase(inputType))
                .flatMap(seller -> seller.get_inventory().stream())
                .collect(Collectors.toList());

        resultOfItemByType.sort(Comparator.comparing(Item::getPrice));
        System.out.println(resultOfItemByType);
    }

    public static void  simulateBuyAItem(){

        // 5- Simular la compra de un ítem a un NPC.


    }

    public static void  simulateSellAItem(){

        // 6. Simular la venta de un ítem a un NPC.*


    }

}