package unit2;
import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * A simple BMI calculator which implements string parsing and decimal formatting
 * @version 11-10-2020
 * @author tylerpowers
 */

public class BMICalculator {
    /** Convert English to metric units, perform the BMI calculation.
     * NOTE: this method must properly handle bad data
     * @param inches the user's height in inches, an int.
     * @param pounds the user's weight in pounds, an int.
     * @return a double containing the user's BMI
     */
    public static double computeBMI(int inches, int pounds) {
        if(inches <= 0 || pounds <= 0)
            return 0;
        double meters = inches * 0.0254;
        double kg = pounds * 0.454;
        return kg / Math.pow(meters, 2);
    }

    /** Uses a Scanner to prompt the user for info, process the
     * feet/inches conversion, calls the computeBMI method and prints the
     * correct information.
     * @param args arguments from the command line
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");
        int weight; int feet; int inches; String rawHeight; boolean x = false;
        while (true) {
            try {
                x = false;
                System.out.print("Enter your height in feet and inches (format: 6'2\") or Q to quit: ");
                rawHeight = in.nextLine();
                if (rawHeight.toUpperCase().equals("Q")) {
                    System.out.println("Thank you!");
                    System.exit(0);
                }
                feet = Integer.parseInt(rawHeight.substring(0, rawHeight.indexOf("'")));
                System.out.print("Enter your weight in pounds: ");
                x = true;
                weight = in.nextInt();
                inches = Integer.parseInt(rawHeight.substring(rawHeight.indexOf("'") + 1, rawHeight.indexOf("\"")));
                String formattedBMI = df.format(BMICalculator.computeBMI(feet * 12 + inches, weight));
                System.out.println("Your BMI, expressed as weight (kg) / height (m^2): " + formattedBMI);
                in.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input, please retry. ");
                if(x) in.nextLine();  // discard the return key
            }
        }
    }
}
