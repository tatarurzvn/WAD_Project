package DAO;

import Utility.DBConnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImageDAO {

    private static ImageDAO instance;

    public static ImageDAO getInstance() {
        if (instance == null) {
            instance = new ImageDAO();
        }
        return instance;
    }

    private ImageDAO() {
    }



    public void insertImage(String name, InputStream in, String desc) throws FileNotFoundException, SQLException{
        Connection con = new DBConnection().getConnection();

  
            // connects to the database
            // constructs SQL statement
            String sql = "INSERT INTO emojo.emoji (name, image, description) values (?, ?, ?)";
            //Using a PreparedStatement to save the file
            PreparedStatement pstmtSave = con.prepareStatement(sql);
            pstmtSave.setString(1, name);
            pstmtSave.setString(3, desc);
            if (in != null)
                pstmtSave.setBlob(2, in);

            //sends the statement to the database server
            pstmtSave.executeUpdate();

    }

}
