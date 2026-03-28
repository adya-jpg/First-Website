public class math_scanner_class {
    public static void main (String[] args)
    {
        //importing the scanner class
        //the scanner class allows us to take input from the user.
        //to use the scanner class, we must first import it at the top of our program.
        //import java.util.Scanner;

        //creating a scanner object
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        //prompting the user for input
        System.out.println("Please enter a number:");

        //taking input from the user
        int userInput = scanner.nextInt();

        //performing a mathematical operation
        int result = userInput * 2;

        //displaying the result
        System.out.println("The result is: " + result);

        //closing the scanner
        scanner.close();

        //we use system.in.print and not system.out.print.ln because
        //system.in is used for input (taking data from the user) and
        //system.out is used for output (displaying data to the user). 
        //print.ln is a method of the system.out class that prints data to the console with a new line at the end.
        
    }

    //importing the math class
    //the math class provides various mathematical functions and constants.
    public static void mathExample() {
        //using the math class to perform mathematical operations
        double squareRoot = Math.sqrt(16);
        double power = Math.pow(2, 3);
        double absoluteValue = Math.abs(-10);

        //displaying the results
        System.out.println("Square root of 16: " + squareRoot);
        System.out.println("2 raised to the power of 3: " + power);
        System.out.println("Absolute value of -10: " + absoluteValue);

        //using math constants
        double piValue = Math.PI;
        System.out.println("Value of Pi: " + piValue);

        //using rounding functions
        double roundedValue = Math.round(3.6);
        System.out.println("Rounded value of 3.6: " + roundedValue);

        //using max and min functions
        int maxValue = Math.max(10, 20);
        int minValue = Math.min(10, 20);
        System.out.println("Maximum value between 10 and 20: " + maxValue);
        System.out.println("Minimum value between 10 and 20: " + minValue);

        //using trigonometric functions
        double sineValue = Math.sin(Math.toRadians(30));
        System.out.println("Sine of 30 degrees: " + sineValue);
        
        //you can explore more functions in the Math class as needed.
        //refer to the official Java documentation for a complete list of Math class methods.

        //math class is a built-in class in java that provides methods for-
        //performing basic numeric operations such as exponentiation, logarithms, 
        //square roots, and trigonometric functions.

        //math.cieling() - rounds a decimal number UP to the nearest whole number.
        double num1 = 4.3;
        System.out.println("Ceiling of " + num1 + " is: " + Math.ceil(num1));
        
        //math.floor() - rounds a decimal number DOWN to the nearest whole number.
        double num2 = 4.7;
        System.out.println("Floor of " + num2 + " is: " + Math.floor(num2));
        
        //math.round() - rounds a decimal number to the nearest whole number.
        double num3 = 4.5;
        System.out.println("Round of " + num3 + " is: " + Math.round(num3));
        
        //math.pow(base, exponent) - raises a number (base) to the power of (exponent).
        double base = 2;
        double exponent = 3;
        System.out.println(base + " raised to the power of " + exponent + " is: " + Math.pow(base, exponent));
    }
    
}
