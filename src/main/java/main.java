
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.beans.EventHandler;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Malek Hammou
 */
public class main  {

    private static String Operation;
    public static void main(String[] args) {
        String operator="";
        /*NEW FRAME*/
        JFrame mainFrame=new JFrame();
        mainFrame.setTitle("CALCULATOR");
        mainFrame.setSize(300,200);
        mainFrame.setLayout(new BorderLayout());
        /*USED FOR DISPLAY*/
        JTextField ioField=new JTextField();
        mainFrame.add(ioField,BorderLayout.NORTH);
        JPanel digitsPanel=new JPanel();
        digitsPanel.setLayout(new GridLayout(4, 3));
        for (int i = 1; i < 10; i++) {
            JButton button=new JButton(""+i);
            button.setForeground(Color.blue);
            button.addActionListener(actionEvent ->  {
                
                ioField.setText(ioField.getText()+((JButton)actionEvent.getSource()).getText());
});
            digitsPanel.add(button);
        }
      
        
        /*ADD ZERO BUTTON*/
        JButton zeroButton=new JButton(""+0);
  
        zeroButton.setForeground(Color.blue);
        digitsPanel.add(zeroButton);
        /*ADD SIGN BUTTON*/
        JButton signButton=new JButton("+/-");
        signButton.addActionListener(actionEvent ->  {
            int nb = Integer.parseInt(ioField.getText().toString());
            nb=-nb;   
                ioField.setText(String.valueOf(nb));
});
        signButton.setForeground(Color.blue);
        digitsPanel.add(signButton);
        /* ADD CLEAR ALL BUTTON*/
        JButton clearAllButton=new JButton("CLEAR");
        clearAllButton.setForeground(Color.PINK);
        clearAllButton.addActionListener(actionEvent ->  {
                ioField.setText("");
});
        digitsPanel.add(clearAllButton);
        
        mainFrame.add(digitsPanel,BorderLayout.CENTER);
        JPanel operationsPanel=new JPanel();
        operationsPanel.setLayout(new GridLayout(4,1));
        /*ADDITION*/
        JButton additionButton=new JButton("+");
        additionButton.addActionListener(actionEvent ->  {
            Operation="-";
            ioField.setText(ioField.getText()+"+");
});
        /*SUBSTRACTION*/
        JButton substractionButton=new JButton("-");
        substractionButton.addActionListener(actionEvent ->  {
            Operation="-";
            ioField.setText(ioField.getText()+"-");
});
        /* DIVISION*/
        JButton divisionButton=new JButton("/");
        divisionButton.addActionListener(actionEvent ->  {
            Operation="/";
            ioField.setText(ioField.getText()+"/");
});
        /*MULTIPLICATION*/
        JButton multiplicationButton=new JButton("*");
        multiplicationButton.addActionListener(actionEvent ->  {
            Operation="*";
            ioField.setText(ioField.getText()+"*");
});
        operationsPanel.add(additionButton);
        operationsPanel.add(substractionButton);
        operationsPanel.add(multiplicationButton);
        operationsPanel.add(divisionButton);
        additionButton.setForeground(Color.red);
        divisionButton.setForeground(Color.red);
        substractionButton.setForeground(Color.red);
        multiplicationButton.setForeground(Color.red);
           
        mainFrame.add(operationsPanel,BorderLayout.EAST);
        mainFrame.add(new JButton("ENTER"),BorderLayout.SOUTH);
        mainFrame.setVisible(true);

   
    }

    }

