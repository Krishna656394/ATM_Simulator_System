package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PinChange extends JFrame implements ActionListener
{
    JPasswordField npin,repin;
    JButton changeButton,backButton;
    String pinNumber ;
    PinChange(String pinNumber){
        this.pinNumber = pinNumber;
        setSize(900, 900);
        setLocation(300, 0);
        setLayout(null);
        setVisible(true);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("CHANE YOUR PIN");
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(250, 290, 500, 35);
        image.add(text);
        
        JLabel newPin1 = new JLabel("NEW PIN:");
        newPin1.setFont(new Font("Raleway", Font.BOLD, 16));
        newPin1.setForeground(Color.WHITE);
        newPin1.setBounds(165, 330, 180, 25);
        image.add(newPin1);
        
        npin = new JPasswordField();
        npin.setFont(new Font("Raleway" , Font.BOLD,22));
        npin.setForeground(Color.BLACK);
        npin.setBounds(330,330,180,25);
        image.add(npin);
        
        JLabel rePin = new JLabel("Re-Enter NEW PIN:");
        rePin.setFont(new Font("Raleway", Font.BOLD, 16));
        rePin.setForeground(Color.WHITE);
        rePin.setBounds(165, 360, 180, 25);
        image.add(rePin);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway" , Font.BOLD,22));
        repin.setForeground(Color.BLACK);
        repin.setBounds(330,360,180,25);
        image.add(repin);
        
        changeButton = new JButton("CHANGE");
        changeButton.setBounds(355,510,150,30);
        changeButton.addActionListener(this);
        image.add(changeButton);
        
        backButton = new JButton("BACK");
        backButton.setBounds(355,475,150,30);
        backButton.addActionListener(this);
        image.add(backButton);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == changeButton){
            try{
                String pin = npin.getText();
                String rpin = repin.getText();
                if (!pin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"Enter PIN does not match");
                    return;
                }
                if (pin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter PIN");
                    return;
                }
                if (rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Re-Enter PIN");
                    return;
                }
                String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinNumber+"'";
                String query2 = "update login set Pin_No  = '"+rpin+"' where Pin_No = '"+pinNumber+"'";
                String query3 = "update signupthree set Pin_No = '"+rpin+"' where Pin_No = '"+pinNumber+"'";
                
                Conn c = new Conn();
                c.st.executeUpdate(query1);
                c.st.executeUpdate(query2);
                c.st.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null,"PIN Change Successfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);
                
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else{
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
    public static void main(String[] args){
        new PinChange("").setVisible(true);
    }
}
