public class operators {
    public static void main(String[] args) {

        //operators definition:
        //an operator is a special symbol that performs a specific operation on one, two, or more operands.
        //operators are used to manipulate variables and values in expressions.
       
        //unary operators:
        //the unary minus operator negates the value of the operand.
        //it is used to change the sign of a number from positive to negative or vice versa.
        int number = 5;
        number = -number; // unary minus operator
        System.out.println("Unary minus applied: " + number); // Output: -5

        //the unary plus operator indicates a positive value.
        //it is often used to emphasize that a number is positive, although it has no effect on the value itself.
        number = +number; // unary plus operator
        System.out.println("Unary plus applied: " + number); // Output: -5 

        //binary operators:
        //binary operators operate on two operands and perform arithmetic operations.
        //examples of binary operators include: +, -, *, /, and %.

        //addition operator (+): adds two operands.
        int price = 10, tax = 5;
        int sum = price + tax; // addition operator
        System.out.println("Addition: " + sum); // Output: 15

        //subtraction operator (-): subtracts the second operand from the first.
        int total = 10, discount = 5;
        int sale = total - discount; // subtraction operator
        System.out.println("Subtraction: " + sale); // Output: 5

        //multiplication operator (*): multiplies two operands.
        double percent = 0.02, sales = 3; 
        //the double data type is used for decimal numbers, it has a higher precision than float.
        double commission = percent * sales; // multiplication operator
        System.out.println("Multiplication: " + commission); // Output: 0.06

        //division operator (/): divides the first operand by the second.
        double players = 11, maxEach = 3; //you can do operations in a variable too.
        // the double data type is used to ensure decimal division.
        double quotient = players / maxEach; // division operator
        System.out.println("Division: " + quotient); // Output: 3.6666666666666665

        //modulus operator (%): returns the remainder of the division of the first operand by the second.
        int leftover = 101, groupSize = 10;
        int remainder = leftover % groupSize; // modulus operator
        System.out.println("Modulus: " + remainder); // Output: 1

        //ternary operator:
        //the ternary operator is a shorthand way of expressing a conditional statement.
        //tenary operator syntax: condition ? value_if_true : value_if_false
        int age = 20;
        String eligibility = (age >= 18) ? "Eligible to vote" : "Not eligible to vote"; // ternary operator
        System.out.println("Ternary operator result: " + eligibility); // Output: Eligible to vote

        //integer division vs float vs double division:
        int a = 7, b = 3;
        int intDivision = a / b; // integer division
        float floatDivision = (float) a / b; // float division
        double doubleDivision = (double) a / b; // double division
        System.out.println("Integer division: " + intDivision); // Output: 2
        System.out.println("Float division: " + floatDivision); // Output: 2.3333333
        System.out.println("Double division: " + doubleDivision); // Output: 2.3333333333333335
        //the difference is that integer division removes the decimal part. 
        //while float and double division retain it.

        //operator precedence:
        //urnary operators have the highest precedence, 
        //followed by multiplication, division, and modulus, and finally addition and subtraction.

        //operator precedence determines the order in which operators are evaluated in an expression.
       
        int result = 10 + 5 * 2; // multiplication has higher precedence than addition
        System.out.println("Operator precedence result: " + result); // Output: 20
       
        //you can use parentheses to change the order of evaluation.
        result = (10 + 5) * 2; // parentheses change the order of evaluation.
        System.out.println("Operator precedence with parentheses result: " + result); // Output: 30
        
        //other examples: 
        //this basically uses BEDMAS/BODMAS rules 
        //(brackets, exponents, division/multiplication, addition/subtraction).

        int value1 = 5 + 2 * 4 - 3;
        System.out.println("Example 1 result: " + value1); // Output: 10

        int value2 = (5 + 2) * (4 - 3);
        System.out.println("Example 2 result: " + value2); // Output: 7

        int value3 = 20 / 4 + 3 * 2;
        System.out.println("Example 3 result: " + value3); // Output: 11
        
    }
}
