/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientController;

import bean.CustomersFacadeLocal;
import entity.Customers;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "EditMyProfile", urlPatterns = {"/EditMyProfile"})
public class EditMyProfile extends HttpServlet {

    @EJB
    CustomersFacadeLocal cusFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String cusid = request.getParameter("customerID");
        Customers cus = cusFacade.find(cusid);
        String fName = request.getParameter("first-name");
        cus.setFirstName(fName);
        String lName = request.getParameter("last-name");
        cus.setLastName(lName);
        String phone = request.getParameter("tel");
        cus.setPhone(phone);
        String address = request.getParameter("address");
        cus.setAddress(address);
        String gender = request.getParameter("gender");
        if (gender.equals("Male")) {
            cus.setGender(Boolean.TRUE);
        } else {
            cus.setGender(Boolean.FALSE);
        }
        cusFacade.edit(cus);
        session.setAttribute("login_account", cusFacade.find(cusid));
        request.getRequestDispatcher("myAccount.jsp").forward(request, response);
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
