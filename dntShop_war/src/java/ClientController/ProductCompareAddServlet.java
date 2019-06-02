/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientController;

import bean.ProductsDetailsFacadeLocal;
import bean.ProductsFacadeLocal;
import entity.ComparedDetailProduct;
import entity.ComparedProduct;
import entity.Items;
import entity.Products;
import entity.ProductsDetails;
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
 * @author Nam_Nguyen
 */
@WebServlet(name = "ProductCompareAddServlet", urlPatterns = {"/ProductCompareAddServlet"})
public class ProductCompareAddServlet extends HttpServlet {

    @EJB
    private ProductsFacadeLocal productsFacade;
    @EJB
    private ProductsDetailsFacadeLocal productDetailsFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String productID = request.getParameter("productID");
        ComparedProduct compare = (ComparedProduct) session.getAttribute("compare");
        ComparedDetailProduct detailProduct = (ComparedDetailProduct) session.getAttribute("details");
        if (compare == null) {
            compare = new ComparedProduct();
            detailProduct = new ComparedDetailProduct();
        }
        try {

            Products product = productsFacade.find(productID);
            ProductsDetails productDetail = productDetailsFacade.FindProductDetailsByProID(productID).get(0);
            if (compare.getComparedProducts().size() == 0) {
                if (compare.getComparedProducts().size() < 5) {
                    compare.addToComparedList(product);
                    detailProduct.addToDetailsList(productDetail);
                }
            }else{
                if (compare.getComparedProducts().size() < 5 && compare.getComparedProducts().get(0).getCategoryID().getCategoryID().equals(product.getCategoryID().getCategoryID())) {
                    compare.addToComparedList(product);
                    detailProduct.addToDetailsList(productDetail);
                }
            }


            /* if (compare.getComparedProducts().contains(product)) {
             messasge = "product already exists";
             } else {
             compare.addToComparedList(product);
             messasge = "The product has been added to the comparison list";
             }*/
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("index.jsp");
        }
        session.setAttribute("compare", compare);
        session.setAttribute("details", detailProduct);
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
