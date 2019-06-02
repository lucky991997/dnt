/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AdminController;

import bean.AdminsFacadeLocal;
import entity.Admins;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "adminCheckAddEmailAccount", urlPatterns = {"/adminCheckAddEmailAccount"})
public class adminCheckAddEmailAccount extends HttpServlet {

    @EJB AdminsFacadeLocal adminFacade;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        List<Admins> adminList=adminFacade.findAll();
        int check=0;
        for (int i = 0; i < adminList.size(); i++) {
            if(adminList.get(i).getEmail().equals(email)){
                check++;
            }
        }
        if(check==0){
            response.getWriter().write("<label class=\"control-label pull-right\" id=\"email-resultError\" value=\"true\" style=\"color: #00ca6d\"><i class=\"fa fa-check\"></i></label>");
        }else{
            response.getWriter().write("<label class=\"control-label pull-right\" id=\"email-resultError\" value=\"false\" style=\"color: tomato\"><i class=\"fa fa-times-circle-o\"></i> Email already exists</label>");
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
