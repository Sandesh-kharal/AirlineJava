package com.airmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener {

    JTextField tfname, tfnationality, tfnid, tfaddress, tfphone;
    JRadioButton rbmale, rbfemale;

    public AddCustomer() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // 1. Shadow (Add this first)
        JLabel shadow = new JLabel("Add Customer Details");
        shadow.setFont(new Font("Poppins", Font.PLAIN, 40));
        shadow.setForeground(Color.BLACK);
        shadow.setBounds(170, 15, 1000, 50); // 3 pixel offset
       add(shadow);

// 2. Main Text (Add this second)
        JLabel heading = new JLabel("Add Customer Details");
        heading.setFont(new Font("Poppins", Font.PLAIN, 40));
        heading.setForeground(Color.YELLOW);
        heading.setBounds(168, 15, 1000, 50);
       add(heading);


        // --- Name ---
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 80, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);

        JLabel lblnameColon = new JLabel(":");
        lblnameColon.setBounds(180, 80, 20, 25); // Positioned between label and field
        add(lblnameColon);

        tfname = new JTextField();
        tfname.setBounds(200, 80, 150, 25);
        add(tfname);

// --- Nationality ---
        JLabel lbnationality = new JLabel("Nationality");
        lbnationality.setBounds(60, 130, 150, 25);
        lbnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbnationality);

        JLabel lbnatColon = new JLabel(":");
        lbnatColon.setBounds(180, 130, 20, 25);
        add(lbnatColon);

        tfnationality = new JTextField();
        tfnationality.setBounds(200, 130, 150, 25);
        add(tfnationality);

// --- NID Number ---
        JLabel lbnid = new JLabel("NID Number");
        lbnid.setBounds(60, 180, 150, 25);
        lbnid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbnid);

        JLabel lbnidColon = new JLabel(":");
        lbnidColon.setBounds(180, 180, 20, 25);
        add(lbnidColon);

        tfnid = new JTextField();
        tfnid.setBounds(200, 180, 150, 25);
        add(tfnid);

// --- Address ---
        JLabel lbaddress = new JLabel("Address");
        lbaddress.setBounds(60, 230, 150, 25);
        lbaddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbaddress);

        JLabel lbaddColon = new JLabel(":");
        lbaddColon.setBounds(180, 230, 20, 25);
        add(lbaddColon);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 230, 150, 25);
        add(tfaddress);

// --- Gender ---
        JLabel lbgender = new JLabel("Gender");
        lbgender.setBounds(60, 280, 150, 25);
        lbgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbgender);

        JLabel lbgenderColon = new JLabel(":");
        lbgenderColon.setBounds(180, 280, 20, 25);
        add(lbgenderColon);

        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200, 280, 70, 25);
        rbmale.setBackground(Color.WHITE);
        add(rbmale);

        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(280, 280, 80, 25);
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);

// --- Phone ---
        JLabel lbphone = new JLabel("Phone");
        lbphone.setBounds(60, 330, 150, 25);
        lbphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbphone);

        JLabel lbphoneColon = new JLabel(":");
        lbphoneColon.setBounds(180, 330, 20, 25);
        add(lbphoneColon);

        tfphone = new JTextField();
        tfphone.setBounds(200, 330, 150, 25);
        add(tfphone);

        // Save Button
        JButton save = new JButton("SAVE");
        save.setBackground(Color.BLACK);
        save.setForeground(Color.BLUE);
        save.setBounds(200, 380, 150, 30);
        save.addActionListener(this);
        add(save);

        // Image Icon
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icons/emp.png"));
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(450, 80, 280, 400);
        add(lblimage);

        setSize(800, 500);
        setLocation(300, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String name = tfname.getText();
        String nationality = tfnationality.getText();
        String phone = tfphone.getText();
        String address = tfaddress.getText();
        String nid = tfnid.getText();
        String gender = rbmale.isSelected() ? "Male" : "Female";

        try {
            Conn conn = new Conn();
            // Matching your SQL table: name, nationality, phone, Nid, gender
            String query = "insert into passenger values('"+name+"', '"+nationality+"', '"+phone+"', '"+nid+"', '"+gender+"')";

            conn.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
            setVisible(false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AddCustomer();
    }
}