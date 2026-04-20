package com.airmanagement;

import javax.swing.*;
import java.awt.*;

public class Home extends JFrame {

    public Home() {
        setTitle("Home Page");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // 1. Load and add the image FIRST
        java.net.URL url = ClassLoader.getSystemResource("icons/front.jpg");
        JLabel image = null;
        if (url != null) {
            ImageIcon i1 = new ImageIcon(url);
            image = new JLabel(i1);
            image.setBounds(0, 0, 1600, 800);
            add(image);
        } else {
            System.out.println("Resource not found. Check if icons folder is in src/main/resources");
        }

        // 2. Set visible LAST
        setVisible(true);
        // 1. Shadow (Add this first)
        JLabel shadow = new JLabel("Sagarmatha Airlines Welcomes You");
        shadow.setFont(new Font("Poppins", Font.PLAIN, 40));
        shadow.setForeground(Color.BLACK);
        shadow.setBounds(400, 63, 1000, 50); // 3 pixel offset
        image.add(shadow);

// 2. Main Text (Add this second)
        JLabel heading = new JLabel("Sagarmatha Airlines Welcomes You");
        heading.setFont(new Font("Poppins", Font.PLAIN, 40));
        heading.setForeground(Color.YELLOW);
        heading.setBounds(398, 63, 1000, 50);
        image.add(heading);

        // 1. Create the Menu Bar
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);

// 2. Create the first Menu: "Details"
        JMenu details = new JMenu("Details");
        menubar.add(details);

// Add Menu Items to "Details"
        JMenuItem flightDetails = new JMenuItem("Flight Details");
        details.add(flightDetails);

        JMenuItem customerDetails = new JMenuItem("Add Customer Details");
        details.add(customerDetails);

        JMenuItem bookFlight = new JMenuItem("Book Flight");
        details.add(bookFlight);

        JMenuItem journeyDetails = new JMenuItem("Journey Details");
        details.add(journeyDetails);

        JMenuItem ticketCancellation = new JMenuItem("Cancel Ticket");
        details.add(ticketCancellation);

// 3. Create the second Menu: "Ticket"
        JMenu ticket = new JMenu("Ticket");
        menubar.add(ticket);

// Add Menu Item to "Ticket"
        JMenuItem boardingPass = new JMenuItem("Boarding Pass");
        ticket.add(boardingPass);

        setVisible(true);
    }




    public static void main(String[] args) {
      Home home = new Home();
    }
}