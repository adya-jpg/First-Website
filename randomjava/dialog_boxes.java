import javax.swing.JOptionPane;
public class dialog_boxes {
    public static void main(String[] args) {
        
        // shows a simple message dialog.
        JOptionPane.showMessageDialog(null, "welcome to java dialog boxes.");

        // shows an input dialog and capture user input.
        String name = JOptionPane.showInputDialog("enter your name:");
        JOptionPane.showMessageDialog(null, "hello, " + name + ".");

        // shows a confirmation dialog and captures user response.
        int response = JOptionPane.showConfirmDialog(null, "is your name " + name + "?", "confirm", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "that's nice. here are a few questions " + name + ".");
        } else {
            JOptionPane.showMessageDialog(null, "apologies for the mistake, re-start the program to re-input your name.");
        }
        
        // other options: YES_NO_CANCEL_OPTION, OK_CANCEL_OPTION, etc, use the java docs for more options.
        
        //to convert a string input to an integer.
        String ageInput = JOptionPane.showInputDialog("hello " + name + " enter your age:");
        
        int age = Integer.parseInt(ageInput);
        JOptionPane.showMessageDialog(null, "you are " + age + " years old.");

        //now we are going to tell everyone over 18 that they are old.
        if (Integer.parseInt(ageInput) >= 18) {
            JOptionPane.showMessageDialog(null, "wow... " + name + ", you are OLD.");
        }
        else {
            JOptionPane.showMessageDialog(null, "you are still young " + name + ".");
        }


        // to convert a string input to a double.
        String heightInput = JOptionPane.showInputDialog("enter your height in meters:");
        double height = Double.parseDouble(heightInput);

        //now we will tell everyone taller than 2.7 meters that they are freakishly tall and anyone under 1.0 meters that they are a hobbit and else that they are normal.
        if (height >= 2.7) {
            JOptionPane.showMessageDialog(null, "wow " + name + ", you are freakishly tall.");
        }
        else if (height <= 1.0) {
            JOptionPane.showMessageDialog(null, "you are a hobbit, how's being santa's elf like " + name + "?");
        }
        else {
            JOptionPane.showMessageDialog(null, "you have a normal height, BRAVO. " + name + ".");
        }

        // performing an operation on two numbers from input dialogs.
        String num1 = JOptionPane.showInputDialog("enter first number:");
        String num2 = JOptionPane.showInputDialog("enter second number:");
        double number1 = Double.parseDouble(num1);
        double number2 = Double.parseDouble(num2);
        
        //putting in an elif statement to perform the operation.
        String operation = JOptionPane.showInputDialog("what operation do you want to perform? (+, -, *, /)");
        double result = 0;
        
        // performing the operation based on user input.
        //note the difference between else if and if else is that: 

        //else if is used after an if statement, while if else is not valid syntax.
        if (operation.equals("+")) {
            result = number1 + number2;
        } else if (operation.equals("-")) {
            result = number1 - number2;
        } else if (operation.equals("*")) {
            result = number1 * number2;
        } else if (operation.equals("/")) {
            result = number1 / number2;
        } else {
            JOptionPane.showMessageDialog(null, "invalid operation.");
        }
        JOptionPane.showMessageDialog(null, "the result of " + number1 + " " + operation + " " + number2 + " is: " + result);

        //now let's try more elif statements.
        String gradeInput = JOptionPane.showInputDialog("enter your grade (0-100):");
        int score = Integer.parseInt(gradeInput);
        String grade;
        if (score >= 90) {
            grade = "A: " + "good.";
        } else if (score >= 80) {
            grade = "B: " + "are you aiming for mediocrity?";
        } else if (score >= 70) {
            grade = "C: " + "you can do better.";
        } else if (score >= 60) {
            grade = "D: " + "my asian mother is traumatised.";
        } else {
            grade = "F: " + "your 2 brain cells are fighting for third place.";
        }
        JOptionPane.showMessageDialog(null, "your grade is: " + grade);

        //now lets check an average of three test scores.
        String test1Input = JOptionPane.showInputDialog("enter your first test score:");
        String test2Input = JOptionPane.showInputDialog("enter your second test score:");
        String test3Input = JOptionPane.showInputDialog("enter your third test score:");
        double test1 = Double.parseDouble(test1Input);
        double test2 = Double.parseDouble(test2Input);
        double test3 = Double.parseDouble(test3Input);
        double average = (test1 + test2 + test3) / 3;
        JOptionPane.showMessageDialog(null, "your average score is: " + average + ".");
        if (average >= 90) {
            JOptionPane.showMessageDialog(null, "good. " + name + ", it's average.");
        } else if (average >= 75) {
            JOptionPane.showMessageDialog(null, "hmm... are you aiming for mediocrity? " + name + ", you can do better.");
        } else {
            JOptionPane.showMessageDialog(null, "you FAILURE " + name + ", my asian mother is disappointed.");
        }

        //now let's end with a password check.
        //the differece between .equals and == is that .equals checks for value equality while == checks for reference equality, and = is used for assignment.
        String correctUsername = "adya";
        String usernameInput = JOptionPane.showInputDialog("enter the password:");
        if (usernameInput.equals(correctUsername)) {
            JOptionPane.showMessageDialog(null, "access granted. welcome " + correctUsername + ".");
        } else {
            JOptionPane.showMessageDialog(null, "access denied. incorrect password, stop trying to use brute force to get into my account BUFF AVA.");
        }
    }
}