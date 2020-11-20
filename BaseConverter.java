package unit2;
import java.io.*;
import java.util.Scanner;

/**
 * BaseConverter.java converts a number of any base between 2 and 16 to any other base between 2 and 16.
 * It takes input from a file and writes output to a new file.
 * I have an extra in the method favoriteNum(), which prompts the user after the code has completed.
 * @version 11-19-2020
 * @author tylerpowers
 */

public class BaseConverter {
    // Constructor for class.
    public BaseConverter() {}

    /**
     * EXTRA: prompts user for their favorite number and converts it into every base from 2 to 16
     */
    public void favoriteNum() {
        int favNum;
        Scanner in = new Scanner(System.in);
        System.out.print("Extra? (Y/N) ");
        if(! in.nextLine().toUpperCase().equals("Y"))
            System.exit(0);
        else {
            while(true) {
                System.out.println("What's your favorite number (in base 10 please)? ");
                try {
                    favNum = in.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Error, " + e);
                }
            }
            System.out.println("Here's your favorite number in every base: ");
            for(int x=2; x<=16; x++) {
                System.out.println("Base " + x + ": " + intToStr(favNum, x));
            }
        }
    }

    /**
     * Converts a String num in fromBase to base-10 int.
     * @param num a String, the original number that is to be converted
     * @param fromBase a String, the original base
     * @return newNum, the base-10 version of the original number
     */
    public int strToInt(String num, String fromBase) {
        String hex = "0123456789ABCDEF";
        int newNum = 0;
        int exp = 0;
        for(int x = num.length() - 1; x >= 0; x --) {
            int val = hex.indexOf(""+num.charAt(x));
            newNum += val * Math.pow(Integer.parseInt(fromBase), exp);
            exp++;
        }
        return newNum;
    }


    /**
     * Converts a base-10 int to a String number of base toBase.
     * @param num an int, the base-10 number made from strToInt
     * @param toBase an int, the new base
     * @return the final result of the converted number
     */
    public String intToStr(int num, int toBase) {
        String hex = "0123456789ABCDEF";
        StringBuilder output = new StringBuilder();
        if(num == 0)
            return "0";
        else {
            while (num != 0) {
                output.append(hex.charAt(num % toBase));
                num /= toBase;
            }
            return output.reverse().toString();
        }
    }


    /**
     * Opens the file stream, inputs data one line at a time, converts, prints the result
     * to the console window and writes data to the output stream.
     */
    public void inputConvertPrintWrite() {
        Scanner in;
        PrintWriter pw;
        try {
            pw = new PrintWriter("converted.dat");
            in = new Scanner(new File("src/unit2/datafiles/values30.dat"));
            String[] line;
            while(in.hasNext()) {
                line = in.nextLine().split("\t");
                if(Integer.parseInt(line[1]) < 2 || Integer.parseInt(line[1]) > 16)
                    System.out.println("invalid input base " + Integer.parseInt(line[1]));
                else if((Integer.parseInt(line[2]) < 2 || Integer.parseInt(line[2]) > 16))
                    System.out.println("Invalid output base " + Integer.parseInt(line[2]));
                else {
                    int base10 = strToInt(line[0], line[1]);
                    String converted = intToStr(base10, Integer.parseInt(line[2]));
                    System.out.println(line[0] + " base " + line[1]+ " = " + converted + " base " + line[2]);
                    pw.println(line[0] + "\t" + line[1] + "\t" + converted + "\t" + line[2]);
                }
            }
            in.close();
            pw.close();
            favoriteNum();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    /**
     * Main method for class BaseConverter
     * @param args command line arguments if needed
     */
    public static void main(String[] args) {
        BaseConverter app = new BaseConverter();
        app.inputConvertPrintWrite();
    }
}
