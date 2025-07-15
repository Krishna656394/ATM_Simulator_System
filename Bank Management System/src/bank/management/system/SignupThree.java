package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class SignupThree extends JFrame implements ActionListener
{
    JRadioButton b1,b2,b3,b4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7 ;
    JButton submitButton, cancelButton;
    String formno;
    JLabel cardno, pinno;
    SignupThree(String formno){
        this.formno = formno;
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
        setLayout(null);
        
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);
        
        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);
        
        
        b1 = new JRadioButton("Saving Account");
        b1.setBackground(Color.WHITE);
        b1.setFont(new Font("Raleway",Font.BOLD,16));
        b1.setBounds(100,180,150,20);
        add(b1);
        
        b2 = new JRadioButton("Fixed Deposit Account");
        b2.setBackground(Color.WHITE);
        b2.setFont(new Font("Raleway",Font.BOLD,16));
        b2.setBounds(350,180,250,20);
        add(b2);
        
        b3 = new JRadioButton("Current Account");
        b3.setBackground(Color.WHITE);
        b3.setFont(new Font("Raleway",Font.BOLD,16));
        b3.setBounds(100,220,150,20);
        add(b3);
        
        b4 = new JRadioButton("Recurring Deposit Account");
        b4.setBackground(Color.WHITE);
        b4.setFont(new Font("Raleway",Font.BOLD,16));
        b4.setBounds(350,220,250,20);
        add(b4);
        
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(b1);
        buttonGroup.add(b2);
        buttonGroup.add(b3);
        buttonGroup.add(b4);
        
        JLabel card = new JLabel("Card Number :");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);
        
        cardno = new JLabel("XXXX-XXXX-XXXX-9867");
        cardno.setFont(new Font("Raleway",Font.BOLD,22));
        cardno.setBounds(330,310,300,30);
        add(cardno);
        
        JLabel cardDetail = new JLabel("Your 16 Digit Card Number");
        cardDetail.setFont(new Font("Raleway",Font.BOLD,12));
        cardDetail.setBounds(100,330,300,20);
        add(cardDetail);
        
        JLabel pin = new JLabel("Pin Number :");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin);
        
        pinno = new JLabel("XXXX");
        pinno.setFont(new Font("Raleway",Font.BOLD,22));
        pinno.setBounds(330,380,200,30);
        add(pinno);
        
        JLabel pinDetail = new JLabel("Your 4 Digit Pin Number");
        pinDetail.setFont(new Font("Raleway",Font.BOLD,12));
        pinDetail.setBounds(100,400,300,20);
        add(pinDetail);
        
        JLabel service = new JLabel("Service Required :");
        service.setFont(new Font("Raleway",Font.BOLD,22));
        service.setBounds(100,450,300,30);
        add(service);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100 , 500, 200 , 30);
        c1.setBackground(Color.WHITE);
        add(c1);
        
        c2 = new JCheckBox("INTERNET BANKING");
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350 , 500, 200 , 30);
        c2.setBackground(Color.WHITE);
        add(c2);
        
        c3 = new JCheckBox("MOBILE BANKING");
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100 , 550, 200 , 30);
        c3.setBackground(Color.WHITE);
        add(c3);
        
        c4 = new JCheckBox("EMAIL & SMS Alerts");
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350 , 550, 200 , 30);
        c4.setBackground(Color.WHITE);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100 , 600, 200 , 30);
        c5.setBackground(Color.WHITE);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350 , 600, 200 , 30);
        c6.setBackground(Color.WHITE);
        add(c6);
        
        c7 = new JCheckBox("I HereBy declares that the above details are correct to the best of my knowledge");
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100 , 650, 500 , 30);
        c7.setBackground(Color.WHITE);
        add(c7);
        
        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Raleway",Font.BOLD,16));
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
        submitButton.setBounds(220 ,710,100,30);
        submitButton.addActionListener(this);
        add(submitButton);
        
        cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Raleway",Font.BOLD,16));
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBounds(420 ,710,100,30);
        cancelButton.addActionListener(this);
        add(cancelButton);
        
        getContentPane().setBackground(Color.WHITE); // for page color
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submitButton ){
            String accountType = null;
            if (b1.isSelected()){
                accountType = "Saving Account";
            }
            else if(b2.isSelected()){
                accountType = "Fixed Deposit Account";
            }
            else if(b3.isSelected()){
                accountType = "Current Account";
            }
            else if(b4.isSelected()){
                accountType = "Recurring Deposit Account";
            }
            if (accountType == null) {
                JOptionPane.showMessageDialog(null, "Account Type is Required");
                return;
            }

            if (!c7.isSelected()) {
                JOptionPane.showMessageDialog(null, "Please confirm the declaration by checking the checkbox.");
                return;
            }
            
            Random random = new Random();
            String cardnum = "" + Math.abs ( (random.nextLong() % 90000000L ) + 9024000100000000L);
            String pinnum = "" + Math.abs ( (random.nextLong() % 9000L ) + 1000L);
            
            String facility = "" ;
            if (c1.isSelected()){
                facility = facility + "ATM Card";
            }
            else if (c2.isSelected()){
                facility = facility + "Internet Banking";
            }
            else if (c3.isSelected()){
                facility = facility + "Mobile Banking";
            }
            else if (c4.isSelected()){
                facility = facility + " EMAIL & SMS Alerts ";
            }
            else if (c5.isSelected()){
                facility = facility + "Cheque Book";
            }
            else if (c6.isSelected()){
                facility = facility + "E-Statement";
            }
            
            try{
               if (accountType.equals("")){
                   JOptionPane.showMessageDialog(null, "Account Type is Required");
               } 
               else{
                   Conn c = new Conn();
                   String query1 = "insert into signupthree values ('"+ formno +"', '"+ accountType +"', '"+ cardnum +"', '"+ pinnum +"', '"+ facility +"')";
                   String query2 = "insert into login values ('"+ formno +"','"+ cardnum +"', '"+ pinnum +"')";
                   c.st.executeUpdate(query1);
                   c.st.executeUpdate(query2);
                   
                   JOptionPane.showMessageDialog(null,"Card Number:"+ cardnum +"'\n Pin Number:"+ pinnum);
                   
                   setVisible(false);
                    new Deposit(pinnum).setVisible(true);
               }
            }
            catch(Exception e){
                System.out.print(e);
            }
        }
        else if (ae.getSource() == cancelButton){
            // Inside actionPerformed method, add this code for cancelButton
            setVisible(false);
            new Login().setVisible(true); // If you want to go back to login screen
            // Or simply: System.exit(0); // If you want to exit the application

        }
    }
     public static void main(String []args){
        new SignupThree("");
    }
}
