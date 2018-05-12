
package Controllers;

import DAO.UserDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "RegistrationController", urlPatterns = {"/RegistrationController"})
public class RegistrationController extends HttpServlet {

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

        Enumeration en = request.getParameterNames();
        List<String> l = new ArrayList<>();
        boolean VALID = false;
        List<String> errors = new ArrayList<>();

        try {
            while (en.hasMoreElements()) {
                Object objOri = en.nextElement();
                String param = (String) objOri;
                String value = request.getParameter(param);
                System.out.println(value);
                if ("uname".equals(param) && UserDAO.getInstance().userExists(value)) {
                    VALID = false;
                }
                if ("uname".equals(param) && !UserDAO.getInstance().userExists(value)) {
                    VALID = true;
                }
                
                l.add(value);


            }
            for(String s : l)
                System.out.println(s);
            if (VALID) {
                UserDAO.getInstance().insertUser(l.get(0), l.get(1), l.get(2), l.get(3), l.get(4));
                request.getRequestDispatcher("LoginView.jsp").forward(request, response);
            }
            if (!VALID) {
                errors.add("Username already exists!");
                request.setAttribute("RegistrationErrors", errors);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }

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
