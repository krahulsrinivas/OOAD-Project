package com.project.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
// import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;

//All Database related operations happens here
public class DBService {

    public ArrayList<User> getAllUsers()
    {
        ArrayList<User> users = new ArrayList<User>();
        try {
            //Establish DB connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/swiggy", "root", "krahul2001");
            //Execute SQl Query
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM swiggy.Users");
            //Add users to collection and return collection
            while(rs.next())
            {
                User user = new User();
                // String username = rs.getString("iduser");
                // String password = rs.getString("pwduser");
                user.setUsername(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                // System.out.println(username + "\t" + password + "\n");
                users.add(user);
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return users;
    }

    public ArrayList<ArrayList<String>> getAllItems()
    {
        ArrayList<ArrayList<String>> items = new ArrayList<ArrayList<String>>();
        try {
            //Establish DB connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/swiggy", "root", "krahul2001");
            //Execute SQl Query
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM swiggy.Cart");
            //Add users to collection and return collection
            while(rs.next())
            {
                ArrayList<String> item = new ArrayList<String>();
                item.add(rs.getString("name").toString());
                item.add(rs.getString("cost").toString());
                item.add(rs.getString("image").toString());
                // System.out.println(username + "\t" + password + "\n");
                items.add(item);
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return items;
    }

    //Add user to DB
    public void addUser(String username, String password)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/swiggy", "root", "krahul2001");
            //Execute SQl Query
            PreparedStatement stmt = null;
            String query = "INSERT INTO swiggy.Users(name, password) VALUES (?,?)";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            int row = stmt.executeUpdate();
            System.out.println(row);
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }
    
    public void addItem(String name, int cost, String image)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/swiggy", "root", "krahul2001");
            //Execute SQl Query
            PreparedStatement stmt = null;
            String query = "INSERT INTO swiggy.Cart(name, cost, image) VALUES (?,?,?)";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setInt(2, cost);
            stmt.setString(3, image);
            int row = stmt.executeUpdate();
            System.out.println(row);
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }
    public void clearCart()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/swiggy", "root", "krahul2001");
            //Execute SQl Query
            PreparedStatement stmt = null;
            String query = "TRUNCATE TABLE swiggy.cart";
            stmt = conn.prepareStatement(query);
            int row = stmt.executeUpdate();
            System.out.println(row);
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }
}
