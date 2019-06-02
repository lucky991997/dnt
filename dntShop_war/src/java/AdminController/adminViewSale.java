/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AdminController;

import bean.OrdersFacadeLocal;
import entity.Orders;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
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
@WebServlet(name = "adminViewSale", urlPatterns = {"/adminViewSale"})
public class adminViewSale extends HttpServlet {

    @EJB OrdersFacadeLocal orderFacade;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        List<Orders> orderList = orderFacade.findAll();
        request.setAttribute("orderList", orderList);
        int totalCanceled=0;
        int totalPending=0;
        int totalShipping=0;
        int totalCompleted=0;
        for (int i = 0; i < orderList.size(); i++) {
            if(orderList.get(i).getProcessStatus().equals("Canceled")){
                totalCanceled++;
            }
            if(orderList.get(i).getProcessStatus().equals("Pending")){
                totalPending++;
            }
            if(orderList.get(i).getProcessStatus().equals("Completed")){
                totalCompleted++;
            }
            if(orderList.get(i).getProcessStatus().equals("Shipping")){
                totalShipping++;
            }
        }
        request.setAttribute("totalCanceled", totalCanceled);
        request.setAttribute("totalPending", totalPending);
        request.setAttribute("totalShipping", totalShipping);
        request.setAttribute("totalCompleted", totalCompleted);
        request.getRequestDispatcher("adminSale.jsp").forward(request, response);
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
