/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientController;

import bean.CustomersFacadeLocal;
import bean.ProductsFacadeLocal;
import bean.RatingsFacadeLocal;
import entity.Ratings;
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
@WebServlet(name = "AddYourReview", urlPatterns = {"/AddYourReview"})
public class AddYourReview extends HttpServlet {

    @EJB
    RatingsFacadeLocal ratingFacade;
    @EJB
    ProductsFacadeLocal proFacade;
    @EJB
    CustomersFacadeLocal cusFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String cusid = request.getParameter("cusid");
        String proid = request.getParameter("proid");
        String content = request.getParameter("content");
        int rating = Integer.parseInt(request.getParameter("rating"));
        try {
            Ratings ra = new Ratings();
            ra.setProductID(proFacade.find(proid));
            ra.setCustomerID(cusFacade.find(cusid));
            ra.setContent(content);
            ra.setRate(rating);
            Date date = new Date();
            ra.setRatingDate(date);
            ratingFacade.create(ra);
        } catch (Exception e) {
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
