/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AdminController;

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

/**
 *
 * @author Duy
 */
@WebServlet(name = "adminResetPasswordCustomer", urlPatterns = {"/adminResetPasswordCustomer"})
public class adminResetPasswordCustomer extends HttpServlet {
    String cus_id="";
    @EJB CustomersFacadeLocal cusFacade;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        cus_id=request.getParameter("cus_id");
        request.setAttribute("cus", cusFacade.find(cus_id));
        request.getRequestDispatcher("adminResetPasswordCustomer.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        Customers cus = cusFacade.find(cus_id);
        String password = request.getParameter("password");
        cus.setPassword(password);
        cusFacade.edit(cus);
        request.getRequestDispatcher("adminViewCustomer").forward(request, response);
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
