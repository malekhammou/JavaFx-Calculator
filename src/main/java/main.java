
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.beans.EventHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.lang.ArithmeticException;
public class main  {

    private static String Operation="";
    private static int Operand_1=0;
    private static int Operand_2=0;

    public static void main(String[] args) {
        String operator="";
        /*NEW FRAME*/
        JFrame mainFrame=new JFrame();
        mainFrame.setTitle("CALCULATOR");
        mainFrame.setSize(300,200);
        mainFrame.setLayout(new BorderLayout());
        /* THIS FIELD IS USED FOR DISPLAY*/
        JTextField ioField=new JTextField();
        mainFrame.add(ioField,BorderLayout.NORTH);
        JPanel digitsPanel=new JPanel();
        digitsPanel.setLayout(new GridLayout(4, 3));
        for (int i = 1; i < 10; i++) {
            JButton button=new JButton(""+i);
            button.setForeground(Color.blue);
            /*ACTION LISTENER FOR NUMERICAL BUTTONS*/
            button.addActionListener(actionEvent ->  {
                ioField.setText(ioField.getText()+((JButton)actionEvent.getSource()).getText());
});
            digitsPanel.add(button);
        }
      
        
        /*ADD ZERO BUTTON*/
        JButton zeroButton=new JButton(""+0);
        zeroButton.addActionListener(actionEvent ->  {
                ioField.setText(ioField.getText()+((JButton)actionEvent.getSource()).getText());
});
        zeroButton.setForeground(Color.blue);
        digitsPanel.add(zeroButton);
        /*ADD SIGN BUTTON, THIS BUTTON INVERTS THE SIGN OF THE ENTERED OPERATOR.*/
        JButton signButton=new JButton("+/-");
        signButton.addActionListener(actionEvent ->  {
            if(Operation.equalsIgnoreCase("")){
            int nb = Integer.parseInt(ioField.getText().toString());
            nb=-nb;
            ioField.setText(String.valueOf(nb));
            }
            else{
                String noParentheses=ioField.getText().toString().replace("(","").replace(")","");
                String[] split = noParentheses.split("\\"+Operation);

                
                int scnd = Integer.parseInt(split[split.length-1]);
                scnd=-scnd;
                if("-".equals(noParentheses.split("")[0])&&Operation=="-"){
                    
                    System.out.println("HERE");
                     ioField.setText("(-"+split[1]+")"+Operation+"("+String.valueOf(scnd)+")");

                }
                else{
             ioField.setText("("+split[0]+")"+Operation+"("+String.valueOf(scnd)+")");

                }
            }
                
});
        signButton.setForeground(Color.blue);
        digitsPanel.add(signButton);
        /* ADD CLEAR ALL BUTTON*/
        JButton clearAllButton=new JButton("CLEAR");
        clearAllButton.setForeground(Color.PINK);
        clearAllButton.addActionListener(actionEvent ->  {
                Operation="";
                ioField.setText("");
});
        digitsPanel.add(clearAllButton);
        
        mainFrame.add(digitsPanel,BorderLayout.CENTER);
        JPanel operationsPanel=new JPanel();
        operationsPanel.setLayout(new GridLayout(4,1));
        /*ADDITION*/
        JButton additionButton=new JButton("+");
        additionButton.addActionListener(actionEvent ->  {
            if(Operation.equalsIgnoreCase("")){
               Operation="+";
            ioField.setText("("+ioField.getText()+")"+"+");
            }
});
        /*SUBSTRACTION*/
        JButton substractionButton=new JButton("-");
        substractionButton.addActionListener(actionEvent ->  {
            if(Operation.equalsIgnoreCase("")){
               Operation="-";
            ioField.setText("("+ioField.getText()+")"+"-");
            }
            

});
        /* DIVISION*/
        JButton divisionButton=new JButton("/");
        divisionButton.addActionListener(actionEvent ->  {
            if(Operation.equalsIgnoreCase("")){
               Operation="/";
            ioField.setText("("+ioField.getText()+")"+"/");
            }

});
        /*MULTIPLICATION*/
        JButton multiplicationButton=new JButton("*");
        multiplicationButton.addActionListener(actionEvent ->  {
           if(Operation.equalsIgnoreCase("")){
               Operation="*";
            ioField.setText("("+ioField.getText()+")"+"*");
            }
});
        operationsPanel.add(additionButton);
        operationsPanel.add(substractionButton);
        operationsPanel.add(multiplicationButton);
        operationsPanel.add(divisionButton);
        additionButton.setForeground(Color.red);
        divisionButton.setForeground(Color.red);
        substractionButton.setForeground(Color.red);
        multiplicationButton.setForeground(Color.red);
        /*EVALUATION BUTTON*/
        JButton enterButton=new JButton("Enter");
        mainFrame.add(operationsPanel,BorderLayout.EAST);
        mainFrame.add(enterButton,BorderLayout.SOUTH);
        enterButton.addActionListener(actionEvent ->  {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        String strToEval=ioField.getText().toString();
            try {
                ioField.setText(String.valueOf(engine.eval(strToEval)));
            } catch (ScriptException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            } 
        
           
});
        
        mainFrame.setVisible(true);

   
    }

    }

