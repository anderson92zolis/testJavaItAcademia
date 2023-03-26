import java.util.InputMismatchException;
import java.util.Scanner;

public class Methods {

    private static Scanner myObj = new Scanner(System.in);

    public static int askInteger(String message) {
        int outputParameter = 0;
        boolean continua = true;

        do {
            try {
                System.out.println("\r" + message);
                outputParameter = myObj.nextInt();

                continua = false;
            } catch (InputMismatchException e) {
                System.out.println("Entered value isn't a Integer, try again! ");
            }
            myObj.nextLine();
        } while (continua);

        return outputParameter;
    }

    public static byte askByte(String message) {

        byte outputParameter = 0;
        boolean continua = true;

        do {
            try {
                System.out.println("\r" + message);
                outputParameter = myObj.nextByte();

                continua = false;
            } catch (InputMismatchException e) {
                System.out.println("Entered value isn't a Integer, try again! ");
            }
            myObj.nextLine();
        } while (continua);

        return outputParameter;

    }

    public static String askString(String message) {

        System.out.println("\r"+message);
        return myObj.nextLine();
    }


}
