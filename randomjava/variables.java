public class variables {
    
    public static void main (String[] args)
    {
        //a variable is a container that holds data that can be changed later on in the program.
        //to declare a variable, you must first state the data type, then the name of the variable, and then assign it a value.

        //data types in java:
        //int and double are the most VERSATILE NUMERICAL data types.

        //numeric data types:
    
        //float = decimal numbers with less precision than double (up to 7 decimal digits).
        float decimalNumber;
        decimalNumber = 3.14f;
        System.out.println(decimalNumber);

        //double = decimal numbers with high precision (up to 15 decimal digits).
        double largeDecimalNumber;
        largeDecimalNumber = 3.141592653589793;
        System.out.println(largeDecimalNumber);

        //byte = -128 to 127 --> a byte holds smaller numbers on the scale.
        byte smallNumber;
        smallNumber = 100;
        System.out.println(smallNumber);

        //short = -32,768 to 32,767 --> a short holds medium-sized numbers on the scale.
        short mediumNumber;
        mediumNumber = 20000;
        System.out.println(mediumNumber);

        //int = -2,147,483,648 to 2,147,483,647 --> standard whole numbers. (most commonly used)
        int wholeNumber;
        wholeNumber = 150000;
        System.out.println(wholeNumber);

        //long = -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 --> a long holds larger numbers on the scale.
        long largeWholeNumber;
        largeWholeNumber = 5000000000L;
        System.out.println(largeWholeNumber);

        
        //mon-numeric data types:

        //boolean = true or false values only.
        boolean answer;
        answer = false;
        System.out.println(answer);

        //char - single character (letter, number, symbol)
        char letter;
        letter = 'x';
        System.out.println(letter);

        //String - sequence of characters (words, sentences)
        String text;
        text = "hello, robotics, my name is adya, i'm friends with serena and (buff) ava.";
        System.out.println(text);
        //after initializing a string variable, and just print it by putting it brackets. 
        
        //these are string literals. you can concatenate (join) strings using the + operator.
        String greeting = "hello, how are you";
        String name = "adya";
        System.out.println(greeting + " " + name + "?");

        //a thing to note about strings is that they are immutable, meaning once they are created, they cannot be changed.
        //however, you can create a new string based on modifications of the original string.

        //ANOTHER THING TO NOTE:
        //int unitsSold = 17; //correct way to declare and assign a variable.
        //int unitsSold = 17 18; //this will cause an error because you cannot re-declare a variable with the same name and use multiple values.

        //you can also use the .length() method to find the length of the string.
        //System.out.println(text.length());


           }
}

