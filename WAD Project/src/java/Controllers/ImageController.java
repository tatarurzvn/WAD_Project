
package Controllers;

import DAO.CommentDAO;
import DAO.ImageDAO;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        OutputStream oImage;
        response.setContentType("image");

        try {
            OutputStream out = new FileOutputStream("E:\\Glassfish\\glassfish-4.1.1\\glassfish\\domains\\domain1\\docroot\\tmp.jpg");
            InputStream in = ImageDAO.getInstance().getImage(Integer.parseInt(request.getParameter("id")));
            String name=request.getParameter("name");
            int id=Integer.parseInt(request.getParameter("id"));
            byte[] buff = new byte[1024];
            int bytesRead;
            while((bytesRead = in.read(buff)) !=-1)
                out.write(buff, 0, bytesRead);
            
            String path="E:\\Glassfish\\glassfish-4.1.1\\glassfish\\domains\\domain1\\docroot\\tmp.jpg";
            in.close();
            out.flush();
            out.close();
            
            response.setContentType("image");
            request.setAttribute("name", name);
            request.setAttribute("id", id);
            request.setAttribute("comments", CommentDAO.getInstance().getComments(id));
            request.setAttribute("imageRequest", "/tmp.jpg");
            request.getRequestDispatcher("ImageView.jsp").forward(request, response);

        } catch (FileNotFoundException | SQLException ex) {
            Logger.getLogger(ImageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(request.getParameter("id"));
        
        //}
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
