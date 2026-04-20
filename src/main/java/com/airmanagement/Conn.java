package com.airmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    public Connection c;
    public Statement s;

    public Conn() {
        try {
            // Updated Driver String
            Class.forName("com.mysql.cj.jdbc.Driver");

            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root", "Oxygen@100");
            s = c.createStatement();

            System.out.println("Database Connected Successfully!");
        } catch (Exception e) {
            // This will tell us EXACTLY why it failed (Driver issue or Password issue)
            e.printStackTrace();
        }
    }
}