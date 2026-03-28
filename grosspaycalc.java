import java.util.Scanner;
public class grosspaycalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.print("enter your name: ");
        
        String name = scanner.nextLine();
        System.out.print("enter your hours worked this week: ");
        
        double hoursWorked = scanner.nextFloat();
        System.out.print("enter your hourly pay rate: ");
        
        double payRate = scanner.nextFloat();
        
        //calculating gross pay for the week & approx for the month
        double weeklyGross = hoursWorked * payRate;
        
        //simple 4 weeks in a month calculation
        double monthlyGross = weeklyGross * 4; 
        
        //printing results :P
        System.out.println("hello " + name + ", your gross pay for the week is: $" + weeklyGross);
        System.out.println(" your approximate gross pay for the month is: $" + monthlyGross);

        if (monthlyGross < 0){
            System.out.println(" you are in debt!");
        }
            else if (monthlyGross == 0){
                System.out.println(" you are broke!");
            }
            else {
                System.out.println(" you are not in debt!");
        }
        
        //closing the scanner object, preventing resource leaks and potential issues.
        scanner.close();
    }
}