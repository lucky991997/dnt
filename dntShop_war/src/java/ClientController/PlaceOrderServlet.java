/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientController;

import bean.OrdersDetailsFacadeLocal;
import bean.OrdersFacadeLocal;
import entity.Cart;
import entity.Customers;
import entity.Items;
import entity.Orders;
import entity.OrdersDetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
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
@WebServlet(name = "PlaceOrderServlet", urlPatterns = {"/PlaceOrderServlet"})
public class PlaceOrderServlet extends HttpServlet {

    @EJB
    OrdersFacadeLocal ordersFacade;
    @EJB
    OrdersDetailsFacadeLocal ordersDetailsFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if(cart.countQty()==0){
            request.getRequestDispatcher("emptyCart.jsp").forward(request, response);
        }else{
        Customers cus = (Customers) session.getAttribute("login_account");
        int num = ordersFacade.count() + 1;
        String id = num + "";
        int lenNum = 7;
        int lenZero = lenNum - id.length();
        for (int i = 0; i < lenZero; i++) {
            id = "0" + id;
        }
        String orderid = "OD" + id;
        String Shipname = request.getParameter("first-name") +" "+ request.getParameter("last-name");
        String ShipPhone = request.getParameter("tel");
        String ShipAddress = request.getParameter("address");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String ShipDate = formatter.format(date);
        String Shipnote = request.getParameter("shipnote");
        String OrderDate = formatter.format(date);
        String processStt = "Pending";
        String payMethod = request.getParameter("payment");
        //Orders orders = new Orders(orderid,cart.totalCart(),Shipname,ShipPhone,ShipAddress,date,payMethod,processStt);
        Orders orders = new Orders();
        orders.setOrderID(orderid);
        orders.setCustomerID(cus);
        orders.setShipName(Shipname);
        orders.setShipPhone(ShipPhone);
        orders.setShipAddress(ShipAddress);
        orders.setShipDate(date);
        orders.setShipNote(Shipnote);
        orders.setPaymentMethod(payMethod);
        orders.setOrderDate(date);
        orders.setProcessStatus(processStt);
        orders.setTotal(cart.totalCart());
        orders.setIsStatus(true);
        ordersFacade.create(orders);

        for (Map.Entry<String, Items> list : cart.getCartItems().entrySet()) {
            int numOdd = ordersDetailsFacade.count() + 1;
            int orderDetailid = numOdd + 1;
            OrdersDetails ordersDetails = new OrdersDetails();
            ordersDetails.setOdID(orderDetailid);
            ordersDetails.setOrderID(orders);
            ordersDetails.setProductID(list.getValue().getProduct());
            ordersDetails.setQuantity(list.getValue().getQuantity());
            ordersDetails.setSellingPrice(list.getValue().getProduct().getPrice()*(100-list.getValue().getProduct().getDiscountProduct())/100);
            ordersDetails.setIsStatus(true);
            ordersDetailsFacade.create(ordersDetails);
        }
        session.removeAttribute("cart");
        request.getRequestDispatcher("orderComplete.jsp").forward(request, response);
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
