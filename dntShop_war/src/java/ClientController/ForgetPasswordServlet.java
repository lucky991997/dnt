/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientController;

import bean.CustomersFacadeLocal;
import entity.Products;
import entity.Wishlist;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tools.SendMail;

/**
 *
 * @author Nam_Nguyen
 */
@WebServlet(name = "ForgetPasswordServlet", urlPatterns = {"/ForgetPasswordServlet"})
public class ForgetPasswordServlet extends HttpServlet {

    @EJB
    CustomersFacadeLocal cusFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
      
        if (cusFacade.findByMail(email).size() > 0) {
                session.setAttribute("findUser_message", null);
                Random rd = new Random();
                int number =100000+ rd.nextInt(99999);
                System.out.println(""+number);
                session.setAttribute("numberResetPass", number);
                session.setAttribute("userResetPass", cusFacade.findByMail(email).get(0));
                  String content="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
"\n" +
"<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
"\n" +
"<head>\n" +
"\n" +
"    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" +
"\n" +
"    <title>Forgot Password</title>\n" +
"\n" +
"    <style>\n" +
"\n" +
"        body {\n" +
"\n" +
"            background-color: #FFFFFF; padding: 0; margin: 0;\n" +
"\n" +
"        }\n" +
"\n" +
"    </style>\n" +
"\n" +
"</head>\n" +
"\n" +
"<body style=\"background-color: #FFFFFF; padding: 0; margin: 0;\">\n" +
"\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"10\" height=\"100%\" bgcolor=\"#FFFFFF\" width=\"100%\" style=\"max-width: 650px;\" id=\"bodyTable\">\n" +
"\n" +
"    <tr>\n" +
"\n" +
"        <td align=\"center\" valign=\"top\">\n" +
"\n" +
"            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" id=\"emailContainer\" style=\"font-family:Arial; color: #333333;\">\n" +
"\n" +
"                <!-- Logo -->\n" +
"\n" +
"                <tr>\n" +
"\n" +
"                    <td align=\"left\" valign=\"top\" colspan=\"2\" style=\"border-bottom: 1px solid #CCCCCC; padding-bottom: 10px;\">\n" +
"\n" +
"<h3>DNTShop</h3>"+
                          "\n" +
"                    </td>\n" +
"\n" +
"                </tr>\n" +
"\n" +
"                <!-- Title -->\n" +
"\n" +
"                <tr>\n" +
"\n" +
"                    <td align=\"left\" valign=\"top\" colspan=\"2\" style=\"border-bottom: 1px solid #CCCCCC; padding: 20px 0 10px 0;\">\n" +
"\n" +
"                        <span style=\"font-size: 18px; font-weight: normal;\">FORGOT PASSWORD</span>\n" +
"\n" +
"                    </td>\n" +
"\n" +
"                </tr>\n" +
"\n" +
"                <!-- Messages -->\n" +
"\n" +
"                <tr>\n" +
"\n" +
"                    <td align=\"left\" valign=\"top\" colspan=\"2\" style=\"padding-top: 10px;\">\n" +
"\n" +
"                        <span style=\"font-size: 12px; line-height: 1.5; color: #333333;\">\n" +
"\n" +
"                            We have sent you this email in response to your request to reset your password on DNTShop." +
"\n" +
"                            <br/><br/>\n" +
"\n" +
"                            To reset your password for yout account, please follow the link below:\n" +
"\n" +
"                            <a href=\"http://localhost:8080/dntShop_war/getLinkresetPasswordServlet?resetCode="+number+"\"\">http://localhost:8080/dntShop_war/getLinkresetPasswordServlet?resetCode="+number+"</a>\n" +
"\n" +
"                            <br/><br/>\n" +
"\n" +
"                            We recommend that you keep your password secure and not share it with anyone.If you feel your password has been compromised, you can change it by going to your ${site-name} My Account Page and clicking on the \"Change Email Address or Password\" link.\n" +
"\n" +
"                            <br/><br/>\n" +
"\n" +
"                            If you need help, or you have any other questions, feel free to email DNTShop@gmail.com, or call 0987184873 customer service toll-free at 0987184873.\n" +
"\n" +
"                            <br/><br/>\n" +
"\n" +
"\n" +
"                        </span>\n" +
"\n" +
"                    </td>\n" +
"\n" +
"                </tr>\n" +
"\n" +
"            </table>\n" +
"\n" +
"        </td>\n" +
"\n" +
"    </tr>\n" +
"\n" +
"</table>\n" +
"\n" +
"</body>\n" +
"\n" +
"</html>";
                SendMail sm=new SendMail();
                /*sm.sendMail(email, " Change your password", 
                        "Hello "+cusFacade.findByMail(email).get(0).getFirstName()+"!!!"+"\n"+"Somebody recently asked to reset your password."+"\n"
                                +"Click http://localhost:8080/dntShop_war/getLinkresetPasswordServlet?resetCode="+number+" to change your password");*/
                sm.sendMail(email,"Reset your password", content);
                request.getRequestDispatcher("messageMail.jsp").forward(request, response);
        } else {
            session.setAttribute("findUser_message", "<p class=\"login-box-msg\" style=\"color:red\">email incorrect</p>");
            request.getRequestDispatcher("findUser.jsp").forward(request, response);
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
