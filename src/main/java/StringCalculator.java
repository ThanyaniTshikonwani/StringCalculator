import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringCalculator {

    static int add(String input) {

        String delimiter = ",|\n";
        String[] parts =input.split("\n");
        boolean startsWith =input.startsWith("//");

        if (input.isEmpty())
            return 0;
        try {
            if (input.contains("\n1000;")){
                throw new NumberFormatException();
            }
        }catch (NumberFormatException e){
            System.out.println("ERROR: Invalid inputs 1000");
        }

        if (startsWith){
            delimiter =parts[0].substring(2);
            input = parts[1];
        }
        customerDelimiter ( input );


        List<String> num = Arrays.asList(input.split(delimiter));
        try {
            if (getIntStream(num).anyMatch(n->n<0))
                throw new IllegalArgumentException();
        }catch (IllegalArgumentException e){
            System.out.println ("error : negatives number are not allowed");
        }
        return getIntStream(num).sum();
    }

    private static IntStream getIntStream(List<String> num) {
        return num.stream().mapToInt(Integer::parseInt).map(n->n%1000);
    }

    private static String customerDelimiter(String input) {
        input = input.replace("\n", ",");
        if(input.startsWith("//[")) {
            String delim = input.substring(3, input.indexOf ( "]" ));
            if(delim.contains("-"))
                throw new IllegalArgumentException("Illegal delimiter: " + delim);
            input = input.substring(5 + delim.length());
            input = input.replace(delim, ",");
        }
        return input;
    }



    private static String parseDelimiter(String header) {

        String delimiter = header.substring(2);
        if (delimiter.startsWith("[")) {
            delimiter = delimiter.substring(1, delimiter.length() - 1);
        }
        return Stream.of(delimiter.split("]\\["))
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));
    }

    public List<Integer> multipleDelimeter(String inputValue)
            throws RuntimeException {

        String stringArray[] = inputValue
                .split("[//\n,!.?:;@#$%^&*()_+=?'<>+]");
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < stringArray.length; i++) {

            String string = stringArray[i];

            if (null != string && !string.equals("")) {
                if (isInteger(string)) {
                    list.add(Integer.parseInt(string));
                }
            }

        }

        StringBuilder negativeValue = new StringBuilder();
        for (Integer integer : list) {
            if (integer < 0)
                negativeValue.append(integer + " ");
        }

        if (!negativeValue.toString().equals("")) {
            throw new RuntimeException(
                    "Negatives not allowed. Negative values: "
                            + negativeValue.toString());
        }

        return list;
    }

    public static boolean isInteger(String inputValue) {
        try {
            Integer.parseInt(inputValue);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }



    public void inputs(){

        String[] split = "1,2|3.4$5".split("[,|.]");
        System.out.println(Arrays.toString(split));
        System.out.println ("add(\"\") = " +(add("")));
        System.out.println ("add(\"2,3\") = " +(add("2,3")));
        System.out.println ("add(\"1\\n2,3\") = " +(add("1\n2,3")));
        System.out.println ("add(\"//;\\n1;2\") = " +(add("//;\n1;2")));
        System.out.println ("add(\"//4\\n142\") = " +(add("//4\n142")));
        System.out.println(add("1,-1"));
        System.out.println ("add(\"//[:D][&]\\n:D2&3\") = " +(multipleDelimeter("//[:D][&]\n:D2&3")));
        System.out.println("add(\"//[***]\\n1***2***3\") = "+(add ( customerDelimiter ("//[***]\n1***2***3"))));
    }
}




