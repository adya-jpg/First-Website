//this is a project that takes user input as binary and then converts it to decimal
//it uses dialog boxes to get the input and display the output

import javax.swing.JOptionPane;

public class binarycalc {

    public static void main(String[] args) {

        //get user input
        String binary = JOptionPane.showInputDialog("Enter a binary number: ");

        //convert binary to decimal
        int decimal = Integer.parseInt(binary, 2);
        
        //display the result
        JOptionPane.showMessageDialog(null, "The decimal value of " + binary + " is: " + decimal);
    }
}
