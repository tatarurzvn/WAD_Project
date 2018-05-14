package DAO;

import Utility.DBConnection;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

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



    public void insertImage(String name, InputStream in, String desc, String user) throws FileNotFoundException, SQLException{
        Connection con = new DBConnection().getConnection();

  
            // connects to the database
            // constructs SQL statement
            String sql = "INSERT INTO emojo.emoji (name, image, description, user) values (?, ?, ?, ?)";
            //Using a PreparedStatement to save the file
            PreparedStatement pstmtSave = con.prepareStatement(sql);
            pstmtSave.setString(1, name);
            pstmtSave.setString(3, desc);
            pstmtSave.setString(4, user);
            if (in != null)
                pstmtSave.setBlob(2, in);

            //sends the statement to the database server
            pstmtSave.executeUpdate();

    }
    
    public HashMap<Integer, String> getImageList() throws FileNotFoundException, SQLException{
        Connection con=new DBConnection().getConnection();
        String sql = "SELECT * FROM emojo.emoji";
        Statement instr = con.createStatement();
        HashMap<Integer,String> images=new HashMap<>();
        ResultSet rs = instr.executeQuery(sql);
        while (rs.next()) {
            images.put(Integer.parseInt(rs.getString(1)),rs.getString(2));
        }
        for(HashMap.Entry<Integer, String> i : images.entrySet())
        {
            System.out.println(i.getKey()+" "+i.getValue());
        }
        return images;
    }

}
