import java.util.Scanner;

public class Main {

    static Scanner  = new Scanner(System.in);


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



        boolean sortir = false;

        do{
            switch(menu()){
                case 1:
                    consultItemsOfSeller();
                    break;
                case 2:
                    createLineBill();
                    break;
                case 3:
                    totalPriceByOneBill(numberBill);
                    break;
                case 4:
                    totalPriceAllBills();
                    break;
                case 5:
                    // here
                    try {
                        showNumberBillOfClient("client");
                    } catch (PersonalizedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 6: ShowBillOfCLient("Client");
                    break;
                case 7: ShowBillDependingOfProduct("Product");
                    break;
                case 8:
                    numberBill= Methods.askInteger("Write a number of bill");
                    deleteBillObsolManner(numberBill);
                    break;
                case 9: writeBillinCSV();
                    break;
                case 10:
                    writeBillLineBillinCSV();
                    break;
                case 0: System.out.println("Gràcies per utilitzar l'aplicació");
                    sortir = true;
                    break;
            }
        }while(!sortir);
    }

    public static byte menu(){
        Scanner entrada = new Scanner(System.in);
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

            opcio = entrada.nextByte();
            if(opcio < MINIMO || opcio > MAXIMO){
                System.out.println("Choose a valid option");
            }
        }while(opcio < MINIMO || opcio > MAXIMO);
        return opcio;
    }


    // consulta los item de un vendedor

    public static void  consultItemsOfSeller(){
        ;
    }

}