import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textfield;
    // this array is for the numbers
    JButton[] numberButtons = new JButton[10];
    // this array holds the operation and functional buttons.
    JButton[] functionButtons = new JButton[8];
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton, equButton, delButton, clrButton;
    JPanel panel;

    //Font
    Font myFont = new Font("Ink Free",Font.BOLD,30);

    double num1 = 0,num2=0,result=0;
    char operator;
    Calculator(){
        /** frame methods */
        frame = new JFrame("Calculator");
        /** allows us to exit */
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);
        /** textfield that shows the numbers and other functions */
        textfield = new JTextField();
        textfield.setBounds(50,25,300,50);
        textfield.setFont(myFont);
        textfield.setEditable(false);

        /** add button */
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");


        /** adding the buttons to the array */
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        for(int i = 0; i<8;i++)
        {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            // to remove the annoying thing around the button
            functionButtons[i].setFocusable(false);
        }
        for(int i = 0; i<10;i++)
        {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            // to remove the annoying thing around the button
            numberButtons[i].setFocusable(false);
        }
        /** the delButton and clrButton */
        delButton.setBounds(50,430,145,50);
        clrButton.setBounds(205,430,145,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.GRAY);

        /** adding the numbers and function buttons to the panel */
        /**first row*/
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        /** second row */
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        /** third row */
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);


        /** adding everything to the frame */
        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }
/** This method has the functioality when we press on the buttons what happens */
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0; i<10;i++)
        {

            if(e.getSource() == numberButtons[i])
            {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        /** this concatenats the number with a . (decimal). */
        if(e.getSource() == decButton)
        {
            textfield.setText(textfield.getText().concat("."));
        }
        /** Here we made the textfield to "" so we can inser the second number */
        if(e.getSource() == addButton)
        {
           num1 = Double.parseDouble(textfield.getText());
           operator = '+';
           textfield.setText("");
        }
        if(e.getSource() == subButton)
        {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if(e.getSource() == mulButton)
        {
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if(e.getSource() == divButton)
        {
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        if(e.getSource()==equButton)
        {
            num2 = Double.parseDouble(textfield.getText());
            /** this switch does what the operations do */
            switch(operator)
            {
                case '+':
                    result = num1+num2;
                    break;
                case '-':
                    result = num1-num2;
                    break;
                case '*':
                    result = num1*num2;
                    break;
                case '/':
                    result = num1/num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            /** if we want to use the result to do operations on.*/
            num1 = result;
        }
        /** Clear button */
        if(e.getSource() == clrButton)
        {
            textfield.setText("");
        }
        /** deletion button */

        if(e.getSource() == delButton)
        {
            String string = textfield.getText();
            textfield.setText("");
            for (int i=0;i<string.length()-1;i++)
            {
                textfield.setText(textfield.getText()+string.charAt(i));
            }
        }

    }
}