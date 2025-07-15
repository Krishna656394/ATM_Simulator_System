package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;



public class MiniStatement extends JFrame implements ActionListener {
    JLabel userName, cardLabel, balanceLabel;
    JTextArea statementArea;
    JButton back, download;

    // Constructor with pin input
    MiniStatement(String pin) {
        setTitle("Mini Statement");
        setSize(400, 600);
        setLocation(20, 20);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // Bank Title
        JLabel bankLabel = new JLabel("Indian Bank");
        bankLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        bankLabel.setBounds(140, 20, 200, 30);
        add(bankLabel);

        // Welcome message with name
        userName = new JLabel("Welcome, ");
        userName.setFont(new Font("Raleway", Font.PLAIN, 16));
        userName.setBounds(20, 60, 300, 20);
        add(userName);

        // Card number display
        cardLabel = new JLabel("Card Number:");
        cardLabel.setFont(new Font("Raleway", Font.PLAIN, 14));
        cardLabel.setBounds(20, 90, 300, 20);
        add(cardLabel);

        // Text area for transaction history
        statementArea = new JTextArea();
        statementArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        statementArea.setEditable(false);

        // Scrollable area for statement
        JScrollPane scroll = new JScrollPane(statementArea);
        scroll.setBounds(20, 130, 340, 300);
        add(scroll);

        // Label for balance
        balanceLabel = new JLabel("Your total balance is: Rs 0");
        balanceLabel.setFont(new Font("Raleway", Font.BOLD, 14));
        balanceLabel.setBounds(20, 440, 300, 20);
        add(balanceLabel);

        // Back Button
        back = new JButton("Back");
        back.setBounds(60, 480, 100, 30);
        back.addActionListener(this);
        add(back);

        // Download Button
        download = new JButton("Download");
        download.setBounds(200, 480, 120, 30);
        download.addActionListener(this);
        add(download);

        // Fetch and display data
        showUserDetails(pin);
        showCardNumber(pin);
        showTransactions(pin);
    }

    // Fetch and show user's name
    public void showUserDetails(String pin) {
        try {
            String formNo = "";
            Conn c = new Conn();

            // Get Form_No from login using Pin_No
            ResultSet rs1 = c.st.executeQuery("SELECT Form_No FROM login WHERE Pin_No = '" + pin + "'");
            if (rs1.next()) {
                formNo = rs1.getString("Form_No");
            }

            // Get name using Form_No from signup table
            ResultSet rs = c.st.executeQuery("SELECT name FROM signup WHERE formno = " + formNo  );
            if (rs.next()) {
                userName.setText("Welcome, " + rs.getString("name"));
            } else {
                userName.setText("Welcome,");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Fetch and show masked card number
    public void showCardNumber(String pin) {
        try {
            Conn c = new Conn();
            ResultSet rs = c.st.executeQuery("SELECT Card_No FROM login WHERE Pin_No = '" + pin + "'");
            if (rs.next()) {
                String cardNum = rs.getString("Card_No");
                // Mask card number
                cardLabel.setText("Card Number: " + cardNum.substring(0, 4) + "XXXXXXXX" + cardNum.substring(12));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Show transactions and calculate balance
    public void showTransactions(String pin) {
        try {
            Conn c = new Conn();
            ResultSet rs = c.st.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "'");
            int balance = 0;

            // Set table headers
            statementArea.setText(String.format("%-12s%-12s%-12s\n", "Date", "Type", "Amount"));
            statementArea.append("----------------------------------------\n");

            // Display each transaction and compute balance
            while (rs.next()) {
                String date = rs.getString("date");
                String type = rs.getString("type");
                String amount = rs.getString("amount");

                statementArea.append(String.format("%-12s%-12s%-12s\n", date, type, amount));

                if (type.equalsIgnoreCase("Deposit")) {
                    balance += Integer.parseInt(amount);
                } else {
                    balance -= Integer.parseInt(amount);
                }
            }

            // Set final balance
            balanceLabel.setText("Your total balance is: Rs " + balance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Handle button clicks
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            this.setVisible(false); // Close current frame
        } else if (ae.getSource() == download) {
            downloadStatement(); // Download mini statement
        }
    }

    // Save the mini statement as a text file
    
    public void downloadStatement() {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setSelectedFile(new java.io.File("MiniStatement.txt"));
            int option = fileChooser.showSaveDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                FileWriter writer = new FileWriter(fileChooser.getSelectedFile());
                writer.write(userName.getText() + "\n");
                writer.write(cardLabel.getText() + "\n\n");
                writer.write(statementArea.getText() + "\n");
                writer.write(balanceLabel.getText());
                writer.close();

                JOptionPane.showMessageDialog(this, "Mini Statement downloaded successfully.");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving file.");
            e.printStackTrace();
        }
    }

    // Main method to run the frame independently
    public static void main(String[] args) {
        new MiniStatement("").setVisible(true);
    }
}
