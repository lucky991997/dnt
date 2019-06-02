/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AdminController;

import bean.CustomersFacadeLocal;
import bean.OrdersFacadeLocal;
import entity.Orders;
import entity.Report;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "adminReportCustomer", urlPatterns = {"/adminReportCustomer"})
public class adminReportCustomer extends HttpServlet {

    @EJB CustomersFacadeLocal cusFacade;
    @EJB OrdersFacadeLocal orderFacade;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        request.setAttribute("cusList", cusFacade.findAll());
        request.getRequestDispatcher("adminReportCustomer.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String cusid = request.getParameter("customerID");
        String daterange = request.getParameter("dateRange");

        String dateValue1 = daterange.substring(0, 10);
        String dateValue2 = daterange.substring(13, 23);

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date Startdate = new Date();
        Date Enddate = new Date();
        try {
            Startdate = formatter.parse(dateValue1);
            Enddate = formatter.parse(dateValue2);

        } catch (ParseException e) {
        }
        List<Orders> reportList = orderFacade.CustomerReport(cusid, Startdate, Enddate);
        int totalProfit = 0;
        for (int i = 0; i < reportList.size(); i++) {
            if (!reportList.get(i).getProcessStatus().equals("Canceled")) {
                totalProfit += reportList.get(i).getTotal();
            }
        }
        request.setAttribute("totalProfit", totalProfit);
        request.setAttribute("dateRange", daterange);
        request.setAttribute("cus", cusFacade.find(cusid));
        request.setAttribute("reportList", reportList);
        request.getRequestDispatcher("adminViewReportCustomer.jsp").forward(request, response);
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
