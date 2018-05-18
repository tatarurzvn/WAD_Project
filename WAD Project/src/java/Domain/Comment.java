
package Domain;

import DAO.UserDAO;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Comment {
    public String content;
    public int image;
    public int user;
    
    public Comment(String c, int u, int i){
        this.content=c;
        this.user=u;
        this.image=i;
    }
    
    public String getContent(){
        return this.content;
    }
    public String getUser() throws SQLException, FileNotFoundException{
        return UserDAO.getInstance().getUsername(user);
    }
}
