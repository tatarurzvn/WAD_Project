package DAO;

import Domain.Comment;
import Utility.DBConnection;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class CommentDAO {

    private static CommentDAO instance;

    public static CommentDAO getInstance() {
        if (instance == null) {
            instance = new CommentDAO();
        }
        return instance;
    }

    private CommentDAO() {
    }

    public void insertComment(String content, int user, int image) throws FileNotFoundException, SQLException {

        Connection con = new DBConnection().getConnection();
        String sql = "INSERT INTO emojo.comment (text, user, image) values (?, ?, ?)";
        PreparedStatement pstmtSave = con.prepareStatement(sql);
        pstmtSave.setString(1, content);
        pstmtSave.setInt(2, user);
        pstmtSave.setInt(3, image);

        pstmtSave.executeUpdate();
    }
    
    public ArrayList<Comment> getComments(int id) throws FileNotFoundException, SQLException{
        Connection con = new DBConnection().getConnection();
        String sql = "SELECT * FROM emojo.comment WHERE image='"+id+"'";
        Statement instr = con.createStatement();
        ArrayList<Comment>comments = new ArrayList<>();
        ResultSet rs = instr.executeQuery(sql);
        
        while(rs.next()){
            comments.add(new Comment(rs.getString(2), rs.getInt(3), rs.getInt(4)));
        }
        
        return comments;
    }

}
