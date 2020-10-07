package unit1;

/**
 * RomanToDecimal is a program that converts any given roman numeral into a decimal value.
 * It also can analyze input from the command line.
 * @version 10/06/2020
 * @author tylerpowers
 */


public class RomanToDecimal {
    /**
     * MY EXTRA
     * This method is used to confirm that the value given is a proper roman numeral. It constructs a new roman
     * numeral from the decimal value given and compares it to the value that was entered by the user
     * @param decimal is the number value that romanToDecimal() returns
     * @return returns a boolean indicating whether the entered roman numeral is equal to the newly constructed one
     */
    private static boolean decimalToRoman(String original, int decimal) {
        StringBuilder roman = new StringBuilder();
        while(decimal >= 1000) {
            roman.append("M");
            decimal -= 1000;
        }
        while(decimal >= 900) {
            roman.append("CM");
            decimal -= 900;
        }
        while(decimal >= 500) {
            roman.append("D");
            decimal -= 500;
        }
        while(decimal >= 400) {
            roman.append("CD");
            decimal -= 400;
        }
        while(decimal >= 100) {
            roman.append("C");
            decimal -= 100;
        }
        while(decimal >= 90) {
            roman.append("XC");
            decimal -= 90;
        }
        while(decimal >= 50) {
            roman.append("L");
            decimal -= 50;
        }
        while(decimal >= 40) {
            roman.append("XL");
            decimal -= 40;
        }
        while(decimal >= 10) {
            roman.append("X");
            decimal -= 10;
        }
        while(decimal >= 9) {
            roman.append("IX");
            decimal -= 9;
        }
        while(decimal >= 5) {
            roman.append("V");
            decimal -= 5;
        }
        while(decimal >= 4) {
            roman.append("IV");
            decimal -= 4;
        }
        while(decimal >= 1) {
            roman.append("I");
            decimal -= 1;
        }
    return roman.toString().equals(original);
    }

    /**
     * converts a string of roman numerals to a decimal value
     * @param roman Must be an uppercase String
     * @return returns a decimal value of the roman numeral entered
     */
    public static int romanToDecimal(String roman) {
        int sum = 0;
        for(int i = 0; i < roman.length(); i++) {
            String letter = roman.substring(i, i + 1);
            switch (letter) {
                case "I": sum += 1;
                    break;
                case "V": sum += 5;
                    break;
                case "X": sum += 10;
                    break;
                case "L": sum += 50;
                    break;
                case "C": sum += 100;
                    break;
                case "D": sum += 500;
                    break;
                case "M": sum += 1000;
                    break;
                default: return -1;
            }
        }
        for(int i = 0; i < roman.length() - 1; i++) {
            String invariant = roman.substring(i, i + 2);
            switch (invariant) {
                case "IV": case "IX":
                    sum -= 2; break;
                case "XL": case "XC":
                    sum -= 20; break;
                case "CD": case "CM":
                    sum -= 200; break;
            }
        }

        return sum;
    }

    /**
     * Main method that drives the program -- deals with printing the data and calling other methods
     * @param args the command line input, with each value separated by a single space
     */
    public static void main(String[] args) {
        for(String roman : args) {
            String upperRoman = roman.toUpperCase();
            int decimal = romanToDecimal(upperRoman);
            System.out.print("Input: " + roman + " ==> Output: ");
            if(decimal == -1 || !decimalToRoman(upperRoman, decimal))
                System.out.println("invalid");
            else
                System.out.println(decimal);
        }
    }
}
