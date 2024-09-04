package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener {
    JLabel l1, l2, l3;
    JTextField cardTextField;
    JPasswordField pinTextField;//numers dont show up
    JButton login, clear, signup;

    Login() {
        // Creating frame
        JLabel l11 = new JLabel(new ImageIcon("path_to_image")); // Replace "path_to_image" with the actual path
        l11.setBounds(70, 10, 100, 100);
        add(l11);

        l1 = new JLabel("WELCOME TO ATM");
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        l1.setBounds(200, 40, 450, 40);
        add(l1);

        l2 = new JLabel("Card No:");
        l2.setFont(new Font("Raleway", Font.BOLD, 28));
        l2.setBounds(125, 150, 375, 30);
        add(l2);

        cardTextField = new JTextField(15);
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);

        l3 = new JLabel("PIN:");
        l3.setFont(new Font("Raleway", Font.BOLD, 28));
        l3.setBounds(125, 220, 375, 30);
        add(l3);

        pinTextField = new JPasswordField(15);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        pinTextField.setBounds(300, 220, 230, 30);
        add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        
        clear = new JButton("CLEAR");
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        
        signup = new JButton("SIGN UP");
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        
        setLayout(null);
        
        login.setFont(new Font("Arial", Font.BOLD, 14));
        login.setBounds(300, 300, 100, 30);
        add(login);
        
        clear.setFont(new Font("Arial", Font.BOLD, 14));
        clear.setBounds(430, 300, 100, 30);
        add(clear);
        
        signup.setFont(new Font("Arial", Font.BOLD, 14));
        signup.setBounds(300, 350, 230, 30);
        add(signup);
        
        login.addActionListener(this);
        clear.addActionListener(this);
        signup.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800, 480);
        setLocation(550, 200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
                
        if(ae.getSource() == clear){
                cardTextField.setText("");
                pinTextField.setText("");
            }
        else if(ae.getSource() == login){
                Conn conn = new Conn();
                String cardnumber  = cardTextField.getText();
                String pinnumber  = pinTextField.getText();
                String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";

                try{
                    ResultSet rs =conn.s.executeQuery(query);
                    if(rs.next()){
                        setVisible(false);
                        new Transactions(pinnumber).setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Incorrect Card or Pin");
                    }
                }
                    
            
     catch(Exception e){
           System.out.println(e);
        }
}  else if(ae.getSource() == signup){
                setVisible(false);
                new SignupOne().setVisible(true);
            }
        } 
    

    public static void main(String[] args){
        new Login().setVisible(true);
    }
}






