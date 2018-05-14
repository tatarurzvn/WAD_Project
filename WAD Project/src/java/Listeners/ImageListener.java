
package Listeners;

import DAO.ImageDAO;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ImageListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            HashMap<Integer, String> images;
            images=ImageDAO.getInstance().getImageList();
            sce.getServletContext().setAttribute("images", images);
        } catch (SQLException | FileNotFoundException ex) {
            Logger.getLogger(ImageListener.class.getName()).log(Level.SEVERE, null, ex);
        }

    } 

    @Override
    public void contextDestroyed(ServletContextEvent sce) {}
}
