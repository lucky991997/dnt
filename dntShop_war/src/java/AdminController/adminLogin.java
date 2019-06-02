/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminController;

import bean.AdminsFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Duy
 */
@WebServlet(name = "adminLogin", urlPatterns = {"/adminLogin"})
public class adminLogin extends HttpServlet {

    @EJB
    AdminsFacadeLocal adminFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        HttpSession session = request.getSession();
        session.setAttribute("admin_login_message", "<p class=\"login-box-msg\">Sign in to start your Admin Page</p>");
        request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (adminFacade.login(email, password).size() > 0) {
            if (adminFacade.login(email, password).get(0).getIsStatus() == true) {
                session.setAttribute("admin_login", adminFacade.login(email, password).get(0));
                request.getRequestDispatcher("adminViewDashBoard").forward(request, response);
            } else {
                session.setAttribute("admin_login_message", "<p class=\"login-box-msg\" style=\"color:red\">your account is banned</p>");
                request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
            }
        } else {
            session.setAttribute("admin_login_message", "<p class=\"login-box-msg\" style=\"color:red\">email or password incorrect</p>");
            request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
        }
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
