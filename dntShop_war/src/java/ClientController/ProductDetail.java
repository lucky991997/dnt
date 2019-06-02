/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientController;

import bean.ProductsDetailsFacadeLocal;
import bean.ProductsFacadeLocal;
import bean.RatingsFacadeLocal;
import entity.Ratings;
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
@WebServlet(name = "ProductDetail", urlPatterns = {"/ProductDetail"})
public class ProductDetail extends HttpServlet {

    @EJB
    ProductsFacadeLocal proFacade;
    @EJB
    ProductsDetailsFacadeLocal prodetailFacade;
    @EJB
    RatingsFacadeLocal ratingsFacade;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String pro_id = request.getParameter("proid");
        request.setAttribute("pro", proFacade.find(pro_id));
        request.setAttribute("prodetail", prodetailFacade.FindProductDetailsByProID(pro_id).get(0));
        
        List<Ratings> ratingList = ratingsFacade.AllRatingByProductID(pro_id);     
        if (ratingList.isEmpty()) {
            request.setAttribute("avgRating", null);
            request.setAttribute("avgStar", null);
            request.setAttribute("ratingList", null);
            request.setAttribute("ratingListCount", 0);
            request.setAttribute("ratingListCountR1", 0);
            request.setAttribute("ratingListCountR2", 0);
            request.setAttribute("ratingListCountR3", 0);
            request.setAttribute("ratingListCountR4", 0);
            request.setAttribute("ratingListCountR5", 0);
        } else {
            Collections.reverse(ratingList);            
            request.setAttribute("ratingList", ratingList);
            request.setAttribute("ratingListCount", ratingList.size());
            float TotalRating=0;
            int TotalStar=0;
            int r1 = 0;
            int r2 = 0;
            int r3 = 0;
            int r4 = 0;
            int r5 = 0;
            for (int i = 0; i < ratingList.size(); i++) {
                if (ratingList.get(i).getRate() == 1) {
                    r1++;
                    TotalRating+=ratingList.get(i).getRate();
                    TotalStar+=ratingList.get(i).getRate();
                }
                if (ratingList.get(i).getRate() == 2) {
                    r2++;
                    TotalRating+=ratingList.get(i).getRate();
                    TotalStar+=ratingList.get(i).getRate();
                }
                if (ratingList.get(i).getRate() == 3) {
                    r3++;
                    TotalRating+=ratingList.get(i).getRate();
                    TotalStar+=ratingList.get(i).getRate();
                }
                if (ratingList.get(i).getRate() == 4) {
                    r4++;
                    TotalRating+=ratingList.get(i).getRate();
                    TotalStar+=ratingList.get(i).getRate();
                }
                if (ratingList.get(i).getRate() == 5) {
                    r5++;
                    TotalRating+=ratingList.get(i).getRate();
                    TotalStar+=ratingList.get(i).getRate();
                }
            }
            float avgRating= TotalRating/ratingList.size();
            int avgStar= TotalStar/ratingList.size();
            request.setAttribute("ratingListCountR1", r1);
            request.setAttribute("ratingListCountR2", r2);
            request.setAttribute("ratingListCountR3", r3);
            request.setAttribute("ratingListCountR4", r4);
            request.setAttribute("ratingListCountR5", r5);
            request.setAttribute("avgRating", avgRating);
            request.setAttribute("avgStar", avgStar);
        }
        request.getRequestDispatcher("productdetail.jsp").forward(request, response);
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
