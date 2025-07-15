
package bank.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import javax.swing.BorderFactory;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
import javax.swing.*;


public class Transactions extends JFrame implements ActionListener
{
    JButton deposit,withdrawl,fastcash,ministatement,pinchange,balanceEnquary,exit;
    String pinNumber;
    public Transactions(String pinNumber){
        this.pinNumber = pinNumber;
        setSize(900,900);
        //setUndecorated(true);//for removing abole white line 
        setVisible(true);
        setLocation(300,0);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setFont(new Font("Raleway" , Font.BOLD,16));
        text.setForeground(Color.WHITE);
        text.setBounds(230,310,700,32);
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.setFont(new Font("Raleway" , Font.BOLD,14));
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(355,415,150,30);
        withdrawl.setFont(new Font("Raleway" , Font.BOLD,14));
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170,450,150,30);
        fastcash.setFont(new Font("Raleway" , Font.BOLD,14));
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement = new JButton("Mini-Statement");
        ministatement.setBounds(355,450,150,30);
        ministatement.setFont(new Font("Raleway" , Font.BOLD,14));
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(170,485,150,30);
        pinchange.setFont(new Font("Raleway" , Font.BOLD,14));
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceEnquary = new JButton("Balance Enquiry");
        balanceEnquary.setBounds(355,485,150,30);
        balanceEnquary.setFont(new Font("Raleway" , Font.BOLD,14));
        balanceEnquary.addActionListener(this);
        image.add(balanceEnquary);
        
        exit = new JButton("Exit");
        exit.setBounds(355,520,150,30);
        exit.setFont(new Font("Raleway" , Font.BOLD,14));
        exit.addActionListener(this);
        image.add(exit);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == exit){
            System.exit(0);
        }
        else if (ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        }
        else if (ae.getSource() == withdrawl){
            setVisible(false);
            new Withdrawl(pinNumber).setVisible(true);
        }
        else if (ae.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        }
        else if (ae.getSource() == pinchange){
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        }
        else if (ae.getSource() == balanceEnquary){
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
        }
        else if (ae.getSource() == ministatement){
            
            new MiniStatement(pinNumber).setVisible(true);
        }
    }
    public static void main(String [] args){
        new Transactions("");
    }
}
