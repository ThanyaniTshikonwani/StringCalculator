
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;


public class StringCalculator {

    static int add(String input) throws Exception {

        StringBuffer negativeNumbers = new StringBuffer();

        // Declaring delimiters
        String delimiter = "[,\n]";

        // Converting String into Numbers
        if (input.startsWith("//")) {
                String[] parts = input.split("\n");
                delimiter = parts[0].substring(2);
                input = parts[1];
            }

        // Escaping delimiter hyphen and backslash
        delimiter = delimiter.replace("\\","\\\\" ).replace("-","\\-");

        // Getting a list of stringList from the inputs String
        List<String> stringList = Arrays.asList(input.split("["+delimiter+"]+"));

        // Handling Errors
        if (input.isEmpty()) {
                return 0;
            } else if(input.startsWith(" ")|!input.startsWith("//")&& input.contains("//")|
                    !Pattern.compile("[0-9]").matcher(input.substring(input.length()-1)).matches()) {
                System.out.println ("ERROR: invalid input");
            }

        // Throwing Exception on negativeNumbers stringList
        for (String negativeDigits : stringList) {
            if (Integer.parseInt(negativeDigits) < 0) {
                negativeNumbers.append(negativeDigits);
            }
            if (negativeDigits.equals(stringList.get(stringList.size() - 1)) && (negativeNumbers.length() > 0)) {
                throw new Exception("ERROR: negatives not allowed " + negativeNumbers);
            }
        }

        // Add all integers
        int sum = 0;
        int stringNumbers = 0;
        while (stringNumbers < stringList.size()){
            int digits = Integer.parseInt(stringList.get(stringNumbers));
            if (digits<1000){
                sum+=digits;
            }
            stringNumbers++;
        }

            return sum;
        }

    public void inputs() throws Exception {
        System.out.println ("add(\"1\\n2,3\") = " +(add("1\n2,3")));

    }
}




