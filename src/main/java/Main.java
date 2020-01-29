import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String rerun;
        do {
            StringCalculator stringCalculator = new StringCalculator();
            System.out.println("Type in Digits");
            stringCalculator.inputs();
            System.out.println("To rerun please type Yes or no to quit");
            rerun = scan.nextLine();
        }while (rerun.equalsIgnoreCase("yes"));

    }
}
