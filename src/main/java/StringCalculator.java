
import java.util.regex.Pattern;


public class StringCalculator {

    static int add(String input) throws Exception {

            StringBuilder negative = new StringBuilder();
            // Declaring delimiters
            String delimiter = "[,\n]";

            // Converting String into Numbers
            if (input.startsWith("//")) {
                String[] parts = input.split("\n");
                delimiter = parts[0].substring(2);
                input = parts[1];
            }
            // Escaping delimiter metacharacters and backslash
        delimiter = delimiter.replace("\\","\\\\");
        delimiter = delimiter.replace("-","\\-");
        String[] numbers = input.split("["+delimiter+"]+");

            // Handling Errors
            if (input.isEmpty()) {
                return 0;
            } else if(input.startsWith(" ")|!input.startsWith("//")&& input.contains("//")|
                    !Pattern.compile("[0-9]").matcher(input.substring(input.length()-1)).matches()) {
                System.out.println ("ERROR: invalid input");
            }else

                // Throwing Exception on negative numbers
                for (String a : numbers) {
                    if (Integer.parseInt(a) < 0) {
                        negative.append(a);
                    }
                    if (a.equals(numbers[numbers.length - 1]) && (negative.length() > 0)) {
                        throw new Exception("ERROR: negatives not allowed " + negative);
                    }

                }

            // Add all integers
            int sum = 0;
            for (String inputs : numbers) {
                int nums = Integer.parseInt(inputs);//convert strings to integer
                if (nums < 1000) {
                    sum += nums;
                }
            }
            return sum;
        }

    public void inputs() throws Exception {
        System.out.println ("add(\"1\\n2,3\") = " +(add("1\n2,3")));

    }
}




