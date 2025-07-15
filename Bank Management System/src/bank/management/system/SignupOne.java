package bank.management.system;
import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import static java.awt.Color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class SignupOne extends JFrame implements ActionListener
{
    Long random;
    JTextField ntext,fntext,emailtext ,addressText ,cityText,stateText,countryText,pinText;
    JDateChooser dobChooser;
    JRadioButton male,female,maritalButton,unmarried,other;
    JButton next;
    
    
    SignupOne(){
        setTitle("Page:- 01");
        setSize(850 , 800);
        setVisible(true);
        setLocation(350,10);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        
        JLabel formno = new JLabel("APPLICATION FORM NO. "+ random);
        formno.setFont(new Font("Raleway",Font.BOLD ,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD ,22));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);
        
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD ,20));
        name.setBounds(100,140,100,30);
        add(name);
        
        ntext = new JTextField();
        ntext.setFont(new Font("Raleway",Font.BOLD ,14));
        ntext.setBounds(300,140,400,30);
        add(ntext);
        
        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD ,20));
        fname.setBounds(100,190,150,30);
        add(fname);
        
        fntext = new JTextField();
        fntext.setFont(new Font("Raleway",Font.BOLD ,14));
        fntext.setBounds(300,190,400,30);
        add(fntext);
        
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD ,20));
        dob.setBounds(100,240,150,30);
        add(dob);
      
        dobChooser = new JDateChooser();
        dobChooser.setBounds(300,240,400,30);
        dobChooser.setFont(new Font("Raleway",Font.BOLD ,14));
        dobChooser.setForeground(Color.BLACK);
        add(dobChooser);
        
        
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD ,20));
        gender.setBounds(100,290,150,30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        
        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway",Font.BOLD ,20));
        email.setBounds(100,340,150,30);
        add(email);
        
        emailtext = new JTextField();
        emailtext.setFont(new Font("Raleway",Font.BOLD ,14));
        emailtext.setBounds(300,340,400,30);
        add(emailtext);
        
        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway",Font.BOLD ,20));
        marital.setBounds(100,390,150,30);
        add(marital);
        
        maritalButton = new JRadioButton("Married");
        maritalButton.setBounds(300,390,100,30);
        maritalButton.setBackground(Color.WHITE);
        add(maritalButton);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,110,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        other = new JRadioButton("Other");
        other.setBounds(630,390,100,30);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(maritalButton);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);
        
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD ,20));
        address.setBounds(100,440,150,30);
        add(address);
        
        addressText = new JTextField();
        addressText.setFont(new Font("Raleway",Font.BOLD ,14));
        addressText.setBounds(300,440,400,30);
        add(addressText);
        
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD ,20));
        city.setBounds(100,490,150,30);
        add(city);
        
        cityText = new JTextField();
        cityText.setFont(new Font("Raleway",Font.BOLD ,14));
        cityText.setBounds(300,490,400,30);
        add(cityText);
        
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD ,20));
        state.setBounds(100,540,150,30);
        add(state);
        
        stateText = new JTextField();
        stateText.setFont(new Font("Raleway",Font.BOLD ,14));
        stateText.setBounds(300,540,400,30);
        add(stateText);
        
        JLabel country = new JLabel("Country:");
        country.setFont(new Font("Raleway",Font.BOLD ,20));
        country.setBounds(100,590,150,30);
        add(country);
        
        countryText = new JTextField();
        countryText.setFont(new Font("Raleway",Font.BOLD ,14));
        countryText.setBounds(300,590,400,30);
        add(countryText);
        
        JLabel pincode = new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway",Font.BOLD ,20));
        pincode.setBounds(100,640,150,30);
        add(pincode);
        
        pinText = new JTextField();
        pinText.setFont(new Font("Raleway",Font.BOLD ,14));
        pinText.setBounds(300,640,400,30);
        add(pinText);
        
        next = new JButton("Next");
        next.setBackground(BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway" , Font.BOLD,14));
        next.setBounds(620,680,80,30);
        next.addActionListener(this);
        add(next);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String formno = "" + random;
        String name = ntext.getText();
        String fname = fntext.getText();
        String dob = ((JTextField) dobChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()){
            gender = "Male";
        }
        else if (female.isSelected()){
            gender = "Female";
        }
        String email = emailtext.getText();
        String marital = null;
        if (maritalButton.isSelected()){
            marital = "Married";
        }
        else if (unmarried.isSelected()){
            marital = "Unmarried";
        }
        else if (other.isSelected()){
            marital = "Other";
        }
        
        String address = addressText.getText();
        String city = cityText.getText();
        String state = stateText.getText();
        String country = countryText.getText();
        String pinCode = pinText.getText();
        
        try{
            if (name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }
            else if (fname.equals("")){
                JOptionPane.showMessageDialog(null,"Father's Name is Required");
            }
            else if (dob.equals("")){
                JOptionPane.showMessageDialog(null,"DOB is Required");
            }
            else if (!male.isSelected() && !female.isSelected()) {
                JOptionPane.showMessageDialog(null, "Select Gender");
            }
            else if (email.equals("")){
                JOptionPane.showMessageDialog(null,"Email is Required");
            }
            else if (!unmarried.isSelected() && !maritalButton.isSelected() && !other.isSelected()){
                JOptionPane.showMessageDialog(null,"Select Marital Status");
            }else if (address.equals("")){
                JOptionPane.showMessageDialog(null,"Address is Required");
            }else if (city.equals("")){
                JOptionPane.showMessageDialog(null,"City is Required");
            }
            else if (state.equals("")){
                JOptionPane.showMessageDialog(null,"State is Required");
            }
            else if (country.equals("")){
                JOptionPane.showMessageDialog(null,"Country is Required");
            }
            else if (pinCode.equals("")){
                JOptionPane.showMessageDialog(null,"Pin Code is Required");
            }
            else{
                Conn c = new Conn();
                String query = "insert into signup values (' "+formno+" ',' "+name+" ',' "+fname+" ',' "+dob+" ',' "+gender+" ',' "+email+" ',' "+marital+" ',' "+address+" ',' "+city+" ',' "+state+" ',' "+country+" ',' "+pinCode+" ')";
                c.st.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
            
            
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }
    public static void main(String args[]){
        new SignupOne();
        
    }
}
