public class Addition {
    public static String addNumbers(String input) {

        // if out inpput is a empty string [CONDITION--- 2]
        if (input.isEmpty()) {
            return "0";
        }

        // custom separator [CONDITION---6]
        String separator = ",";
        if (input.startsWith("//")) {
            int separatorIndex = input.indexOf("//") + 2;
            separator = input.substring(separatorIndex, separatorIndex + 1);
            input = input.substring(input.indexOf("\n") + 1);
        }

        String[] numberArray = input.split("[,\n]");
        StringBuilder result = new StringBuilder();
        int sum = 0;
        StringBuilder negativeNumbers = new StringBuilder();

        for (String number : numberArray) {
            if (number.isEmpty()) {
                result.append("Number expected but ',' found at position ").append(input.indexOf(","));
                return result.toString();
            }

            int num = Integer.parseInt(number);
            if (num < 0) {
                negativeNumbers.append(number).append(",");
            } else if (num <= 1000) {
                sum += num;
            }
        }

        if (negativeNumbers.length() > 0) {
            result.append("Negative not allowed : ").append(negativeNumbers.substring(0, negativeNumbers.length() - 1));
            return result.toString();
        }

        return String.valueOf(sum);
    }
}
