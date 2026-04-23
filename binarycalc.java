//this is a project that takes user input as binary and then converts it to decimal

import java.util.Scanner;

public class binarycalc {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a binary number: ");
            String binaryString = scanner.nextLine();
            int decimalValue = Integer.parseInt(binaryString, 2);
            System.out.println("The decimal value is: " + decimalValue);
        }
    }
}
