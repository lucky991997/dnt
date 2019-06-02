/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientController;

import bean.BrandsFacadeLocal;
import bean.CategoriesFacadeLocal;
import bean.ProductsFacadeLocal;
import entity.Brands;
import entity.Categories;
import entity.Products;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Duy
 */
@WebServlet(name = "initPage", urlPatterns = {"/initPage"})
public class initPage extends HttpServlet {

    @EJB
    ProductsFacadeLocal proFacade;
    @EJB
    CategoriesFacadeLocal cateFacade;
    @EJB
    BrandsFacadeLocal brandFacade;

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
        List<Categories> categoriesList = cateFacade.AllCategories();
        session.setAttribute("categoriesList", categoriesList);
        List<Brands> brandsList = brandFacade.AllBrands();
        session.setAttribute("brandsList", brandsList);
        List<Products> newProductList = proFacade.AllProductNew();
        Collections.reverse(newProductList);
        session.setAttribute("newProductList", newProductList);
        session.setAttribute("topRatingList", proFacade.TopRatingThisYear());
        session.setAttribute("topSellingList", proFacade.TopSellingThisYear());
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
