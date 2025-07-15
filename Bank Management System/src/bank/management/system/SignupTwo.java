package bank.management.system;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static java.awt.Color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import javax.swing.JRadioButton;

public class SignupTwo extends JFrame implements ActionListener
{
    
    JTextField panText ,aadharText;
    JComboBox religon,categoryCombo ,income ,occ,edu;
    JRadioButton s_yes,s_no,EA_yes,EA_no;
    JButton next;
    String formno;
    
    SignupTwo(String formno){
        this.formno = formno;
        setSize(850 , 800);
        setVisible(true);
        setLocation(350,10);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE:-02");
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD ,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        JLabel Religon = new JLabel("Religion:");
        Religon.setFont(new Font("Raleway",Font.BOLD ,20));
        Religon.setBounds(100,140,100,30);
        add(Religon);
        
        String valReligion[] = {"Hindu","Muslim","Sikh","Christian" , "Other"};
        religon = new JComboBox(valReligion);
        religon.setFont(new Font("Raleway",Font.BOLD ,14));
        religon.setBounds(300,140,400,30);
        religon.setBackground(Color.WHITE);
        add(religon);
        
        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway",Font.BOLD ,20));
        category.setBounds(100,190,150,30);
        add(category);
        
        String valCategory[] = {"General","OBC","SC","ST" , "Other"};
        categoryCombo = new JComboBox(valCategory);
        categoryCombo.setFont(new Font("Raleway",Font.BOLD ,14));
        categoryCombo.setBounds(300,190,400,30);
        categoryCombo.setBackground(Color.WHITE);
        add(categoryCombo);
        
        JLabel in = new JLabel("Income:");
        in.setFont(new Font("Raleway",Font.BOLD ,20));
        in.setBounds(100,240,150,30);
        add(in);
        
        String valIncome[] = {"Nill","< 1 Lakh","< 3 Lakh","< 5 Lakh" , "< 10 Lakh"}; 
        income = new JComboBox(valIncome);
        income.setBounds(300,240,400,30);
        income.setFont(new Font("Raleway",Font.BOLD ,14));
        income.setBackground(Color.WHITE);
        add(income);
        
        
        JLabel education = new JLabel("Educational");
        education.setFont(new Font("Raleway",Font.BOLD ,20));
        education.setBounds(100,290,150,30);
        add(education);
        
       
        JLabel q1 = new JLabel("Qualification:");
        q1.setFont(new Font("Raleway",Font.BOLD ,20));
        q1.setBounds(100,320,150,30);
        add(q1);
        
        String educationVal[] = {"Non-Graduate","Graduate","Post Graduate","Doctrate" , "Other"};
        edu = new JComboBox(educationVal);
        edu.setBounds(300,310,400,30);
        edu.setFont(new Font("Raleway",Font.BOLD ,14));
        edu.setBackground(Color.WHITE);
        add(edu);
        
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway",Font.BOLD ,20));
        occupation.setBounds(100,390,150,30);
        add(occupation);
        
        String occuptionVal[] = {"Salaried","Self-Employed","Bussinessman","Student" ,"Retired", "Other"};
        occ = new JComboBox(occuptionVal);
        occ.setBounds(300,390,400,30);
        occ.setFont(new Font("Raleway",Font.BOLD ,14));
        occ.setBackground(Color.WHITE);
        add(occ);
        
        JLabel pan = new JLabel("PAN No:");
        pan.setFont(new Font("Raleway",Font.BOLD ,20));
        pan.setBounds(100,440,150,30);
        add(pan);
        
        panText = new JTextField();
        panText.setFont(new Font("Raleway",Font.BOLD ,14));
        panText.setBounds(300,440,400,30);
        add(panText);
        
        JLabel aadhar = new JLabel("Aadhar No:");
        aadhar.setFont(new Font("Raleway",Font.BOLD ,20));
        aadhar.setBounds(100,490,150,30);
        add(aadhar);
        
        aadharText = new JTextField();
        aadharText.setFont(new Font("Raleway",Font.BOLD ,14));
        aadharText.setBounds(300,490,400,30);
        add(aadharText);
        
        JLabel seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setFont(new Font("Raleway",Font.BOLD,20));
        seniorCitizen.setBounds(100,540,150,30);
        add(seniorCitizen);

        
        s_yes = new JRadioButton("YES");
        s_yes.setBounds(300,540,60,30);
        s_yes.setBackground(Color.WHITE);
        add(s_yes);
        
        s_no = new JRadioButton("NO");
        s_no.setBounds(450,540,120,30);
        s_no.setBackground(Color.WHITE);
        add(s_no);
        
        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(s_yes);
        seniorGroup.add(s_no); 
        
        JLabel acc = new JLabel("Existing Account:");
        acc.setFont(new Font("Raleway",Font.BOLD ,20));
        acc.setBounds(100,590,200,30);
        add(acc);
        
        EA_yes = new JRadioButton("YES");
        EA_yes.setBounds(300,590,60,30);
        EA_yes.setBackground(Color.WHITE);
        add(EA_yes);
        
        EA_no = new JRadioButton("NO");
        EA_no.setBounds(450,590,120,30);
        EA_no.setBackground(Color.WHITE);
        add(EA_no);
        
        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(EA_yes);
        accountGroup.add(EA_no);
        
        next = new JButton("Next");
        next.setBackground(BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway" , Font.BOLD,14));
        next.setBounds(620,640,80,30);
        next.addActionListener(this);
        add(next);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String sreligon = (String)religon.getSelectedItem();
        String scotegory = (String)categoryCombo.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation = (String)edu.getSelectedItem();
        String soccupation = (String)occ.getSelectedItem();
        String sformno = formno;
        String seniorCitizen = null;
        if (s_yes.isSelected()){
            seniorCitizen = "Yes";
        }
        else if(s_no.isSelected()){
            seniorCitizen = "No";
        }
        String existAccount = null;
        if (EA_yes.isSelected()){
            existAccount = "Yes";
        }
        else if(EA_no.isSelected()){
            existAccount = "No";
        }
        String span = panText.getText();
        String saadhar = aadharText.getText();
        //  PAN and Aadhar should not be empty
        if (span.equals("") || saadhar.equals("")) {
            JOptionPane.showMessageDialog(null, "PAN and Aadhar fields cannot be empty.");
            return;
        }
        // Aadhar should be exactly 12 digits and numeric
        if (!saadhar.matches("\\d{12}")) {
            JOptionPane.showMessageDialog(null, "Aadhar number must be exactly 12 digits and numeric.");
            return;
        }
        try{
            Conn c = new Conn();
            String query = "insert into signuptwo values ('"+ sformno+ "','"+ sreligon +"','"+ scotegory +"','"+ sincome +"','" + seducation +"','"+ soccupation +"','"+ span +"','"+ saadhar +"','"+ seniorCitizen +"','"+ existAccount +"')";

            c.st.executeUpdate(query);
            
            //signup three object here.
            setVisible(false);
            new SignupThree(formno).setVisible(true);
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }
    public static void main(String args[]){
        new SignupTwo("");
        
    }
}

