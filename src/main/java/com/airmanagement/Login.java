package com.airmanagement;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

public class Login extends JFrame {

    public Login() {
        // Frame Settings
        setTitle("Login Form");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Absolute positioning

        // Labels
        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(50, 50, 80, 25);
        add(userLabel);

        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(50, 100, 80, 25);
        add(passLabel);

        // Input Fields
        JTextField userText = new JTextField();
        userText.setBounds(150, 50, 220, 25);
        add(userText);

        JPasswordField passText = new JPasswordField();
        passText.setBounds(150, 100, 220, 25);
        add(passText);

        // Buttons
        JButton resetButton = new JButton("Reset");
        resetButton.setBounds(50, 160, 130, 30);
        add(resetButton);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(240, 160, 130, 30);
        add(submitButton);

        JButton closeButton = new JButton("Close");
        closeButton.setBounds(145, 210, 130, 30);
        add(closeButton);

        // --- Basic Button Actions ---

        resetButton.addActionListener(e -> {
            userText.setText("");
            passText.setText("");
        });

        closeButton.addActionListener(e -> System.exit(0));

        submitButton.addActionListener(e -> {
            String user = userText.getText();
            String password = new String(passText.getPassword());
            JOptionPane.showMessageDialog(this, "Login Attempt for: " + user);

            try{
               Conn c = new Conn();
                String query = "select * from login where username= '" + user + "' and password='" + password + "'";
                ResultSet rs= c.s.executeQuery(query);
                        if(rs.next()){
                         new Home();
                        } else {
                            JOptionPane.showMessageDialog(null, "invalid username or password");
                            setVisible(false);
                        }

            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        });

        // Center on screen
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Run on Event Dispatch Thread
        SwingUtilities.invokeLater(Login::new);
    }
}