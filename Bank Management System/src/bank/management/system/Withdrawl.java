
package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Withdrawl extends JFrame implements ActionListener
{
    JButton backButton,withdrawButton;
    JTextField amount;
    JLabel withdraw;
    String pinNumber;
    
    Withdrawl(String pinNumber){
        this.pinNumber = pinNumber;
        setSize(900,900);
        //setUndecorated(true);
        setVisible(true);
        setLocation(300,0);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        withdraw = new JLabel("Enter the Amount you want to Withdraw :");
        withdraw.setFont(new Font("Raleway" , Font.BOLD,16));
        withdraw.setForeground(Color.WHITE);
        withdraw.setBounds(170,300,400,20);
        image.add(withdraw);
        
        amount  = new JTextField();
        amount.setFont(new Font("Raleway" , Font.BOLD,22));
        amount.setForeground(Color.BLACK);
        amount.setBounds(170,340,320,25);
        image.add(amount);
        
        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(355,520,150,30);
        withdrawButton.addActionListener(this);
        image.add(withdrawButton);
        
        backButton = new JButton("Back");
        backButton.setBounds(355,485,150,30);
        backButton.addActionListener(this);
        image.add(backButton);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == withdrawButton){
            String money = amount.getText();
            Date date = new Date();
            if (money.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter the Amount you want to withdraw:");
            }
            else{
                try{
                    Conn c = new Conn();
                    String query = "insert into bank values ('"+ pinNumber +"','"+ date +"','withdrawl','"+ money +"')";
                    c.st.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+money+" Withdrawl Successfully");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        else if(ae.getSource() == backButton){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
    public static void main(String[] args){
        new Withdrawl("");
    }
}

