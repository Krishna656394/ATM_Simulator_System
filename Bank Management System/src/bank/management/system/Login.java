package bank.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener
{
    JLabel l1,l2,l3;
    JTextField tf1;
    JPasswordField pf1;
    JButton signin,clear,signup;
    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        setSize(800 , 480);
        setVisible(true);
        setLocation(350,200);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT );
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(10 , 10 , 100,100);
        add(label);
        
        getContentPane().setBackground(Color.WHITE);
        
        
        l1 = new JLabel("WELCOME TO ATM");
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        l1.setBounds(200,40,450,40);
        add(l1);
        
        l2 = new JLabel("Card No:");
        l2.setFont(new Font("Raleway", Font.BOLD, 28));
        l2.setBounds(125,150,375,30);
        add(l2);
        
        tf1 = new JTextField(15);
        tf1.setBounds(300,150,230,30);
        tf1.setFont(new Font("Arial", Font.BOLD, 14));
        add(tf1);
        
        l3 = new JLabel("PIN:");
        l3.setFont(new Font("Raleway", Font.BOLD, 28));
        l3.setBounds(125,220,250,30);
        add(l3);
        
        pf1 = new JPasswordField(15);
        pf1.setFont(new Font("Arial", Font.BOLD, 14));
        pf1.setBounds(300,220,230,30);
        add(pf1);
        
        signin = new JButton("SIGN IN");
        signin.setBounds(300,290,100,30);
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        signin.addActionListener(this);
        add(signin);
        
        clear = new JButton("CLEAR");
        clear.setBounds(430,290,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300,360,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
           
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear){
            tf1.setText(" ");
            pf1.setText("");
        }
        else if(ae.getSource() == signin){
            Conn c = new Conn();
            String cardNumber = tf1.getText();
            String pinNumber = pf1.getText();
            
            String query = "select * from login where Card_No = '"+ cardNumber +"'and Pin_No = '"+ pinNumber +"'";
            
            try{
                ResultSet rs = c.st.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin Number");
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
            
            
        }
        else if (ae.getSource() == signup){
            setVisible(false);
            SignupOne s1 = new SignupOne();
            s1.setVisible(true);
        }
    }
    public static void main(String[] args){
        new Login();
    }

}
