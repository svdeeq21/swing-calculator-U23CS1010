import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
// These are the libraries that will be used in creating this app

public class App {
    //App class is now defined it will contain the calculator application's logic
    private JFrame frame;
    // Main Window of the Application
    private JTextField num1Field;
    private JTextField num2Field;
    private JTextField operationField;
    private JTextField resultField;
    private JTextField infoField;
    // Text fields for inputting numbers, operation, and displaying the result


    public App() {
        //App constructor calls the createGUI method to set up the graphical user interface.
        createGUI();
    }

    // This method creates the calculator's GUI:

    private void createGUI() {
        // Creates a new JFrame (window) with the title "Calculator App
        frame = new JFrame("U23CS1010  @svdeeq21");
        frame.setSize(1055,500);
        // Sets the default close operation to exit the application when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Sets the layout manager to FlowLayout
        // frame.setLayout(new FlowLayout(5,5,5));
        frame.setLayout(null);
        ImageIcon image = new ImageIcon("Icon2.jpg");// Create Image Object
        frame.setIconImage(image.getImage());

        // Create text fields for inputting numbers, operation, and displaying the result
        JLabel num1Label = new JLabel("Number 1:");
        num1Label.setBounds(110, 30, 100, 30);
        num1Field = new JTextField(10);
        num1Field.setBounds(200, 30, 100, 30);

        JLabel num2Label = new JLabel("Number 2:");
        num2Label.setBounds(480, 30, 100, 30);
        num2Field = new JTextField(10);
        num2Field.setBounds(550, 30, 100, 30);

        JLabel operationLabel = new JLabel("Operation:");
        operationLabel.setBounds(330, 30, 100, 30);
        operationField = new JTextField(2);
        operationField.setBounds(400, 30, 50, 30);

        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setBounds(820, 30, 100, 30);
        resultField = new JTextField(15);
        resultField.setBounds(870, 30, 100, 30);


        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        calculateButton.setBounds(680, 30, 100, 30);

        JLabel information = new JLabel("Student Details:");
        information.setBounds(120, 70, 100, 30);
        infoField = new JTextField(20);
        infoField.setBounds(70, 90, 900, 100);
        

        resultField.setEditable(false);
        infoField.setEditable(false);
        infoField.setText("""
            Name: Sadiq Shehu Musa
            Matric Number: U23CS1010
            Course Code: CSC201
            Course Title: Introduction To Programming II
            Github Username: svdeeq21
        """);
                
       

        // Adds all the components to the frame
        frame.add(num1Label);
        frame.add(num1Field);
        frame.add(operationLabel);
        frame.add(operationField);
        frame.add(num2Label);
        frame.add(num2Field);
        frame.add(calculateButton);
        frame.add(resultLabel);
        frame.add(resultField);
        frame.add(information);
        frame.add(infoField);
        
       
        // Makes the frame visible
        frame.setVisible(true);
         // Packs the frame to set its size
        //  frame.pack();
    }

    // This inner class implements the ActionListener interface to handle the "Calculate" button click
    private class CalculateButtonListener implements ActionListener {
        @Override
        // Retrieves the input values from the text fields
        public void actionPerformed(ActionEvent e) {
            try {
                double num1 = Double.parseDouble(num1Field.getText());
                double num2 = Double.parseDouble(num2Field.getText());
                String operation = operationField.getText();
                // A switch stamement used instead of an IF statement
                // Used to try all calculation cases 
                double result = 0;
                switch (operation) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        // if statement used to check if num 2 not equals to 0
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            // Else return Undefined
                            resultField.setText("Error: Division by zero!");
                            return;
                        }
                        break;
                    default:
                        // If an opreation other than the ones used in the switch statement is used
                        //  Return Invalid Operation
                        resultField.setText("Error: Invalid operation!");
                        return;
                }
                // This Prints the answers to the result field
                
                resultField.setText(String.valueOf(result));
            } catch (NumberFormatException ex) {// If a number is not inputed then it prints invalid input 
                resultField.setText("Error: Invalid input!");
            }
        }
    }

    // Main Method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            // Runs the app at start
            public void run() {
                new App();
            }
        });
    }
}
