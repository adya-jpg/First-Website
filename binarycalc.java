//this is a project that takes user input as binary and then converts it to decimal, it first asks whether the user wants it to be a binary to decimal converter or a decimal to binary converter, then it takes the input and converts it accordingly

import java.util.Scanner;
public class binarycalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to convert binary to decimal or decimal to binary? (Enter 'binary to decimal' or 'decimal to binary')");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("binary to decimal")) {
            System.out.println("Enter a binary number:");
            String binaryInput = scanner.nextLine();
            int decimalOutput = Integer.parseInt(binaryInput, 2);
            System.out.println("The decimal equivalent of " + binaryInput + " is: " + decimalOutput);
        } else if (choice.equalsIgnoreCase("decimal to binary")) {
            System.out.println("Enter a decimal number:");
            int decimalInput = scanner.nextInt();
            String binaryOutput = Integer.toBinaryString(decimalInput);
            System.out.println("The binary equivalent of " + decimalInput + " is: " + binaryOutput);
        } else {
            System.out.println("Invalid choice. Please enter 'binary to decimal' or 'decimal to binary'.");
        }

        scanner.close();
    }
}
