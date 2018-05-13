/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Utility.DBConnection;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    private static UserDAO instance;

    public static UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }

    private UserDAO() {
    }

    public boolean userExists(String name) throws SQLException, FileNotFoundException {

        Connection con = new DBConnection().getConnection();
        Statement instr = con.createStatement();
        String sql = "SELECT * FROM emojo.users;";
        ResultSet rs = instr.executeQuery(sql);

        while(rs.next()) {
            if(name.equals(rs.getString(4)))
                return true;
        }
        return false;
       // return false;
    }

    public void insertUser(String fname, String lname, String email, String uname, String pass) throws SQLException, FileNotFoundException {

        Connection con = new DBConnection().getConnection();
        Statement instr = con.createStatement();

        String sql = "INSERT INTO users (first_name, last_name, email, username, password) VALUES ('" + fname + "', '" + lname + "', '" + email + "', '" + uname + "', PASSWORD('" + pass + "'));";
        instr.executeUpdate(sql);
        System.out.println("user has been inserted");
    }

    public boolean login(String uname, String pass) throws SQLException, FileNotFoundException {

        Connection con = new DBConnection().getConnection();
        Statement instr = con.createStatement();
        String sql = "SELECT username, password FROM emojo.users WHERE password=PASSWORD('" + pass + "')";
        ResultSet rs = instr.executeQuery(sql);

        if (rs == null) {
            return false;
        }
        while (rs.next()) {
            if (uname.equals(rs.getString(1))) {
                return true;
            }
        }
        return false;
    }

}
