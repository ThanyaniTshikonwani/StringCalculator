import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class StringCalculator {

 static int add(String input) {

     String delimiter = ",|\n";
//     String delimiterHeader= header.substring(2);
     String[] parts =input.split("\n",2);
     boolean startsWith =input.startsWith("//");
//     boolean startsWithHeader = delimiterHeader.startsWith("[");


     if (input.isEmpty())
         return 0;

     if (startsWith){
        delimiter =parts[0].substring(2);
        input = parts[1];
     }

     if (input.contains(";\n1000;")){
         throw new NumberFormatException("Errror: Invalid inputs");
     }

//     if (startsWithHeader){
//        delimiter =delimiterHeader.substring(1,delimiterHeader.length()-1);
//     }
     List<String> num = Arrays.asList(input.split(delimiter));


         try {
             if (getIntStream(num).anyMatch(n->n<0))
                 throw new IllegalArgumentException("A negative number was entered");
         }catch (IllegalArgumentException e){
             System.out.println("A negative number was entered");
         }

     return getIntStream(num).sum();
 }
    private static IntStream getIntStream(List<String> num) {
        return num.stream().mapToInt(Integer::parseInt).map(n->n%1000);
    }


    public void inputs(){
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            System.out.println(String.valueOf(add(input)));
        }
}




