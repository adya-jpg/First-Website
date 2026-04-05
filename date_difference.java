//here we will create code a program that calculates the number of days between two dates
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
public class date_difference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input first date
        System.out.print("enter the first date (YYYY-MM-DD): ");
        String firstDateInput = scanner.nextLine();
        LocalDate firstDate = LocalDate.parse(firstDateInput);

        // Input second date
        System.out.print("enter the second date (YYYY-MM-DD): ");
        String secondDateInput = scanner.nextLine();
        LocalDate secondDate = LocalDate.parse(secondDateInput);

        // Calculate the number of days between the two dates
        long daysBetween = ChronoUnit.DAYS.between(firstDate, secondDate);

        // Output the result
        System.out.println("number of days between " + firstDate + " and " + secondDate + " is: " + Math.abs(daysBetween) + " days.");
        
        scanner.close();
        //
    }
}