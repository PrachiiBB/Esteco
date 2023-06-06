public class Multiplication {
    public static String multiplyNumbers(String input) {
        if (input.isEmpty()) {
            return "0";
        }

        String separator = ",";
        if (input.startsWith("//")) {
            int separatorIndex = input.indexOf("//") + 2;
            separator = input.substring(separatorIndex, separatorIndex + 1);
            input = input.substring(input.indexOf("\n") + 1);
        }

        String[] numberArray = input.split("[,\n]");
        StringBuilder result = new StringBuilder();
        int product = 1;
        StringBuilder negativeNumbers = new StringBuilder();

        for (String number : numberArray) {
            if (number.isEmpty()) {
                result.append("Number expected but ',' found at position ").append(input.indexOf(","));
                return result.toString();
            }

            int num = Integer.parseInt(number);
            if (num < 0) {
                negativeNumbers.append(number).append(",");
            } else if (num > 1000) {
                continue;
            } else {
                product *= num;
            }
        }

        if (negativeNumbers.length() > 0) {
            result.append("Negative not allowed : ").append(negativeNumbers.substring(0, negativeNumbers.length() - 1));
            return result.toString();
        }

        return String.valueOf(product);
    }
}
