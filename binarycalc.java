//this is a project that takes user input as binary and then converts it to decimal, it first asks whether the user wants it to be a binary to decimal converter or a decimal to binary converter, then it takes the input and converts it accordingly
// lets make it so the person can convert many numbers without having to restart the program, we can use a while loop to keep the program running until the user decides to exit

import java.util.Scanner;
public class binarycalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice = "";
        while (!choice.equals("exit")) {
            System.out.println("Do you want to convert binary to decimal or decimal to binary? (type 'binary to decimal' or 'decimal to binary' or 'exit' to quit)");
            choice = scanner.nextLine();
            if (choice.equals("binary to decimal")) {
                System.out.println("Enter a binary number:");
                String binary = scanner.nextLine();
                int decimal = Integer.parseInt(binary, 2);
                System.out.println("The decimal value is: " + decimal);
            } else if (choice.equals("decimal to binary")) {
                System.out.println("Enter a decimal number:");
                int decimal = scanner.nextInt();
                scanner.nextLine(); // consume the newline
                String binary = Integer.toBinaryString(decimal);
                System.out.println("The binary value is: " + binary);
            } else if (!choice.equals("exit")) {
                System.out.println("Invalid choice, please try again.");
            }
        }
        System.out.println("Goodbye!");
        scanner.close();
    }
}
