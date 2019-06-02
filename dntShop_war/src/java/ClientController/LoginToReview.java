/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientController;

import bean.CustomersFacadeLocal;
import bean.WishlistFacadeLocal;
import entity.Products;
import entity.Wishlist;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "LoginToReview", urlPatterns = {"/LoginToReview"})
public class LoginToReview extends HttpServlet {

    @EJB
    CustomersFacadeLocal cusFacade;
    @EJB
    WishlistFacadeLocal wishlistFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (cusFacade.login(email, password).size() > 0) {
            if (cusFacade.login(email, password).get(0).getIsStatus() == true) {
                session.setAttribute("login_account", cusFacade.login(email, password).get(0));
                session.setAttribute("login_msgReview", null);
                session.setAttribute("countWishlist", wishlistFacade.findbyCustomer(cusFacade.login(email, password).get(0).getCustomerID()).size());
                List<Products> productList = new ArrayList<>();

                for (Wishlist item : wishlistFacade.findbyCustomer(cusFacade.login(email, password).get(0).getCustomerID())) {
                    productList.add(item.getProductID());

                }
                session.setAttribute("wishlist", productList);
            } else {
                session.setAttribute("login_msgReview", "<p class=\"login-box-msg\" style=\"color:red\">your account is banned</p>");
                
            }
        } else {
            session.setAttribute("login_msgReview", "<p class=\"login-box-msg\" style=\"color:red\">email or password incorrect</p>");
        
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
