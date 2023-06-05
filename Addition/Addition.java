// input ---string  
// output---string

// ------conditions------
// 1) input only--0,1,2 [example-- allowed--- " ", "1", "1,2" not allowed---- "1.1", "1,,1"]
// 2) empty string will retrun '0'
// 3) use \n as separator "1\n2,1"== 1+2+1=4
// 4) (err) "175.2,\n35" == Number expected but '\n' 
// found at position 6."

// 5) ',' at the end not allowed [Number expected but EOF found]
// 6) custom separators [//[delimiter]\n inputs]  allowed---//;\n1;2;3 notallowed-- //;\n1;2,2 or //;\n1;2\n2
// 7)negative number not allowed  "-1,2"=Negative not allowed : -1
// 8)(err) multiple errors --"-1,,-1"= -ve 1 not allowed \n "," founeded \n -ve 2 not allowed 
 

public class AdditionProgram {
    public static String addNumbers(String input) {

        //if out inpput is a empty string [CONDITION--- 2]
        if (input.isEmpty()) {
            return "0";
        }

//custom separator [CONDITION---6]
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
