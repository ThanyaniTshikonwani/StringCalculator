
import java.util.regex.Pattern;


public class StringCalculator {

    static int add(String input) throws Exception {

            StringBuffer negative = new StringBuffer();
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
        String[] digits = input.split("["+delimiter+"]+");

            // Handling Errors
            if (input.isEmpty()) {
                return 0;
            } else if(input.startsWith(" ")|!input.startsWith("//")&& input.contains("//")|
                    !Pattern.compile("[0-9]").matcher(input.substring(input.length()-1)).matches()) {
                System.out.println ("ERROR: invalid input");
            }
            // Throwing Exception on negative digits
        for (String negativeDigits : digits) {
            if (Integer.parseInt(negativeDigits) < 0) {
                negative.append(negativeDigits);
            }
            if (negativeDigits.equals(digits[digits.length - 1]) && (negative.length() > 0)) {
                throw new Exception("ERROR: negatives not allowed " + negative);
            }
        }

        // Add all integers
        int sum = 0;
            for (String inputs : digits) {
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




