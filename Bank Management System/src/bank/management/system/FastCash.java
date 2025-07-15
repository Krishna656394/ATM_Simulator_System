package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton rs100, rs500, rs1000, rs2000, rs5000, rs10000, backButton;
    String pinNumber;

    public FastCash(String pinNumber) {
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

        JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(237, 300, 700, 32);
        image.add(text);

        rs100 = new JButton("Rs 100");
        rs100.setBounds(170, 415, 150, 30);
        rs100.setFont(new Font("Raleway", Font.BOLD, 14));
        rs100.addActionListener(this);
        image.add(rs100);

        rs500 = new JButton("Rs 500");
        rs500.setBounds(355, 415, 150, 30);
        rs500.setFont(new Font("Raleway", Font.BOLD, 14));
        rs500.addActionListener(this);
        image.add(rs500);

        rs1000 = new JButton("Rs 1000");
        rs1000.setBounds(170, 450, 150, 30);
        rs1000.setFont(new Font("Raleway", Font.BOLD, 14));
        rs1000.addActionListener(this);
        image.add(rs1000);

        rs2000 = new JButton("Rs 2000");
        rs2000.setBounds(355, 450, 150, 30);
        rs2000.setFont(new Font("Raleway", Font.BOLD, 14));
        rs2000.addActionListener(this);
        image.add(rs2000);

        rs5000 = new JButton("Rs 5000");
        rs5000.setBounds(170, 485, 150, 30);
        rs5000.setFont(new Font("Raleway", Font.BOLD, 14));
        rs5000.addActionListener(this);
        image.add(rs5000);

        rs10000 = new JButton("Rs 10000");
        rs10000.setBounds(355, 485, 150, 30);
        rs10000.setFont(new Font("Raleway", Font.BOLD, 14));
        rs10000.addActionListener(this);
        image.add(rs10000);

        backButton = new JButton("BACK");
        backButton.setBounds(355, 520, 150, 30);
        backButton.setFont(new Font("Raleway", Font.BOLD, 14));
        backButton.addActionListener(this);
        image.add(backButton);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backButton) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        } else {
            String amount = ((JButton) ae.getSource()).getText().substring(3); // Remove "Rs "

            try {
                Conn c = new Conn();
                ResultSet rs = c.st.executeQuery("select * from bank where pin = '" + pinNumber + "'");
                int bal = 0;

                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        bal += Integer.parseInt(rs.getString("amount"));
                    } else {
                        bal -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if (bal < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                Date date = new Date();
                String query = "insert into bank values ('" + pinNumber + "','" + date + "','Withdrawl','" + amount + "')";
                c.st.executeUpdate(query);

                // Show message
                JOptionPane.showMessageDialog(null, "Rs " + amount + " Withdrawn Successfully");

                setVisible(false);
                new Transactions(pinNumber).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
