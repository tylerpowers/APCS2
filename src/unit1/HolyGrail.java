package unit1;

/**
 * HolyGrail.java is the first lab I will write. It is a simple UI program that talks to the user.
 * 09/15/2020
 * @author tylerpowers
 */

import java.util.Scanner;

public class HolyGrail {
    public static void main(String[] args) {
        // main method that drives the program //
        System.out.println("* A chat with the bridge keeper *");
        System.out.println("Who would cross the Bridge of Death must answer me these questions three," +
                " ere the other side he see.");
        // user input collection //
        Scanner sc = new Scanner(System.in);
        System.out.print("Question 1: What is your name? ");
        String name = sc.nextLine();
        System.out.print("Question 2: What is your quest? ");
        String quest = sc.nextLine();
        System.out.print("Question 3: What is your favorite color? ");
        String color = sc.nextLine();
        // user input regurgitation //
        System.out.println("King Arthur says, \"You have to know these things when you're a king, you know.\"");
        System.out.printf("Your name is: %s\nYour quest is: %s\nYour favorite color is: %s\n", name, quest, color);
        System.out.println("*end of program*");
    }
}
