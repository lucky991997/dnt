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
import java.util.Date;
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
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {

    @EJB
    CustomersFacadeLocal cusFacade;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Customers cus = new Customers();
        //auto create brand_id 
        int num = cusFacade.count() + 1;
        String id = num + "";
        int lenNum = 3;
        int lenZero = lenNum - id.length();
        for (int i = 0; i < lenZero; i++) {
            id = "0" + id;
        }
        String cus_id = "CS" + id;
        cus.setCustomerID(cus_id);
        String fname=request.getParameter("first-name");
        cus.setFirstName(fname);
        String lname=request.getParameter("last-name");
        cus.setLastName(lname);
        String email=request.getParameter("email");
        cus.setEmail(email);
        String pass=request.getParameter("password");
        cus.setPassword(pass);
        String address=request.getParameter("address");
        cus.setAddress(address);
        String phone=request.getParameter("tel");
        cus.setPhone(phone);
        String gender=request.getParameter("gender");
        if(gender.equals("Male")){
             cus.setGender(Boolean.TRUE); 
        }else{
             cus.setGender(Boolean.FALSE); 
        }          
        Date createDate = new Date();
        cus.setCreatedDate(createDate);
        cus.setIsStatus(Boolean.TRUE);
        String avatar="images/Avatars/avatar.png";
        cus.setAvatar(avatar);
        cusFacade.create(cus);
        request.getRequestDispatcher("registerSuccess.jsp").forward(request, response);
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
