/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AdminController;

import bean.OrdersDetailsFacadeLocal;
import bean.OrdersFacadeLocal;
import entity.Orders;
import entity.OrdersDetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tools.SendMail;

/**
 *
 * @author Duy
 */
@WebServlet(name = "adminUpdateSaleProcessStatus", urlPatterns = {"/adminUpdateSaleProcessStatus"})
public class adminUpdateSaleProcessStatus extends HttpServlet {

    @EJB OrdersFacadeLocal orderFacade;
    @EJB OrdersDetailsFacadeLocal detailsFacade;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String orderid=request.getParameter("orderid");
        String pstatus=request.getParameter("pstatus");
        Orders or=orderFacade.find(orderid);
        or.setProcessStatus(pstatus);
        Date date = new Date();
        or.setShipDate(date);
        orderFacade.edit(or);
        SendMail sm=new SendMail();
        String htmlMini="";
        for (OrdersDetails o : detailsFacade.findByOrderId(orderid)) {
            htmlMini+="<tr style=\"border-collapse:collapse;\"> \n" +
"               <table cellspacing=\"0\" cellpadding=\"0\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
"                 <tr style=\"border-collapse:collapse;\"> \n" +
"                  <td width=\"362\" align=\"left\" style=\"padding:0;Margin:0;\"> \n" +
"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
"                     <tr style=\"border-collapse:collapse;\"> \n" +
"                      <td align=\"left\" style=\"padding:0;Margin:0;\"> <p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:14px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:150%;color:#333333;\"><br></p> \n" +
"                       <table style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;width:100%;\" class=\"cke_show_border\" cellspacing=\"1\" cellpadding=\"1\" border=\"0\"> \n" +
"                         <tr style=\"border-collapse:collapse;\"> \n" +
"                          <td style=\"padding:0;Margin:0;\">"+o.getProductID().getProductName()+"</td> \n" +
"                          <td style=\"padding:0;Margin:0;text-align:center;\" width=\"60\">"+o.getQuantity()+"</td> \n" +
"                          <td style=\"padding:0;Margin:0;text-align:center;\" width=\"100\">$"+o.getSellingPrice()+"</td> \n" +
"                         </tr> \n" +
"                       </table> <p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:14px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:150%;color:#333333;\"><br></p> </td> \n" +
"                     </tr> \n" +
"                   </table> </td> \n" +
"                 </tr> \n" +
"               </table> \n" +
"               <!--[if mso]></td></tr></table><![endif]--> </td> \n" +
"             </tr> ";
        }
        if(pstatus.equals("Completed")){
            sm.sendMail(or.getCustomerID().getEmail(), "Order confirmation", "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
"<html style=\"width:100%;font-family:arial, 'helvetica neue', helvetica, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0;\">\n" +
" <head> \n" +
"  <meta charset=\"UTF-8\"> \n" +
"  <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\"> \n" +
"  <meta name=\"x-apple-disable-message-reformatting\"> \n" +
"  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"> \n" +
"  <meta content=\"telephone=no\" name=\"format-detection\"> \n" +
"  <title>nguyenhoangnam3397@gmail.com</title> \n" +
"  <!--[if (mso 16)]>\n" +
"    <style type=\"text/css\">\n" +
"    a {text-decoration: none;}\n" +
"    </style>\n" +
"    <![endif]--> \n" +
"  <!--[if gte mso 9]><style>sup { font-size: 100% !important; }</style><![endif]--> \n" +
"  <style type=\"text/css\">\n" +
"@media only screen and (max-width:600px) {p, ul li, ol li, a { font-size:16px!important } h1 { font-size:30px!important; text-align:center } h2 { font-size:26px!important; text-align:center } h3 { font-size:20px!important; text-align:center } h1 a { font-size:30px!important } h2 a { font-size:26px!important } h3 a { font-size:20px!important } .es-header-body p, .es-header-body ul li, .es-header-body ol li, .es-header-body a { font-size:16px!important } .es-footer-body p, .es-footer-body ul li, .es-footer-body ol li, .es-footer-body a { font-size:16px!important } .es-infoblock p, .es-infoblock ul li, .es-infoblock ol li, .es-infoblock a { font-size:12px!important } *[class=\"gmail-fix\"] { display:none!important } .es-m-txt-c, .es-m-txt-c h1, .es-m-txt-c h2, .es-m-txt-c h3 { text-align:center!important } .es-m-txt-r, .es-m-txt-r h1, .es-m-txt-r h2, .es-m-txt-r h3 { text-align:right!important } .es-m-txt-l, .es-m-txt-l h1, .es-m-txt-l h2, .es-m-txt-l h3 { text-align:left!important } .es-m-txt-r img, .es-m-txt-c img, .es-m-txt-l img { display:inline!important } .es-button-border { display:block!important } .es-button { font-size:20px!important; display:block!important; border-left-width:0px!important; border-right-width:0px!important } .es-btn-fw { border-width:10px 0px!important; text-align:center!important } .es-adaptive table, .es-btn-fw, .es-btn-fw-brdr, .es-left, .es-right { width:100%!important } .es-content table, .es-header table, .es-footer table, .es-content, .es-footer, .es-header { width:100%!important; max-width:600px!important } .es-adapt-td { display:block!important; width:100%!important } .adapt-img { width:100%!important; height:auto!important } .es-m-p0 { padding:0px!important } .es-m-p0r { padding-right:0px!important } .es-m-p0l { padding-left:0px!important } .es-m-p0t { padding-top:0px!important } .es-m-p0b { padding-bottom:0!important } .es-m-p20b { padding-bottom:20px!important } .es-mobile-hidden, .es-hidden { display:none!important } .es-desk-hidden { display:table-row!important; width:auto!important; overflow:visible!important; float:none!important; max-height:inherit!important; line-height:inherit!important } .es-desk-menu-hidden { display:table-cell!important } table.es-table-not-adapt, .esd-block-html table { width:auto!important } table.es-social { display:inline-block!important } table.es-social td { display:inline-block!important } .es-menu td a { font-size:16px!important } }\n" +
"#outlook a {\n" +
"	padding:0;\n" +
"}\n" +
".ExternalClass {\n" +
"	width:100%;\n" +
"}\n" +
".ExternalClass,\n" +
".ExternalClass p,\n" +
".ExternalClass span,\n" +
".ExternalClass font,\n" +
".ExternalClass td,\n" +
".ExternalClass div {\n" +
"	line-height:100%;\n" +
"}\n" +
".es-button {\n" +
"	mso-style-priority:100!important;\n" +
"	text-decoration:none!important;\n" +
"}\n" +
"a[x-apple-data-detectors] {\n" +
"	color:inherit!important;\n" +
"	text-decoration:none!important;\n" +
"	font-size:inherit!important;\n" +
"	font-family:inherit!important;\n" +
"	font-weight:inherit!important;\n" +
"	line-height:inherit!important;\n" +
"}\n" +
".es-desk-hidden {\n" +
"	display:none;\n" +
"	float:left;\n" +
"	overflow:hidden;\n" +
"	width:0;\n" +
"	max-height:0;\n" +
"	line-height:0;\n" +
"	mso-hide:all;\n" +
"}\n" +
"</style> \n" +
" </head> \n" +
" <body style=\"width:100%;font-family:arial, 'helvetica neue', helvetica, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0;\"> \n" +
"  <div class=\"es-wrapper-color\" style=\"background-color:#EFEFEF;\"> \n" +
"   <!--[if gte mso 9]>\n" +
"			<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\n" +
"				<v:fill type=\"tile\" color=\"#efefef\"></v:fill>\n" +
"			</v:background>\n" +
"		<![endif]--> \n" +
"   <table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;padding:0;Margin:0;width:100%;height:100%;background-repeat:repeat;background-position:center top;\"> \n" +
"     <tr style=\"border-collapse:collapse;\"> \n" +
"      <td valign=\"top\" style=\"padding:0;Margin:0;\"> \n" +
"       <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;\"> \n" +
"         <tr style=\"border-collapse:collapse;\"> \n" +
"          <td class=\"es-adaptive\" align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
"           <table class=\"es-content-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#EFEFEF;\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\"> \n" +
"             <tr style=\"border-collapse:collapse;\"> \n" +
"              <td align=\"left\" style=\"Margin:0;padding-top:5px;padding-bottom:5px;padding-left:20px;padding-right:20px;\"> \n" +
"               <!--[if mso]><table width=\"560\" cellpadding=\"0\" cellspacing=\"0\"><tr><td width=\"270\" valign=\"top\"><![endif]--> \n" +
"               <table class=\"es-left\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left;\"> \n" +
"                 <tr style=\"border-collapse:collapse;\"> \n" +
"                  <td width=\"270\" align=\"left\" style=\"padding:0;Margin:0;\"> \n" +
"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
"                     <tr style=\"border-collapse:collapse;\"> \n" +
"                      <td class=\"es-infoblock es-m-txt-c\" align=\"left\" style=\"padding:0;Margin:0;line-height:120%;font-size:12px;color:#CCCCCC;\"> <p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:12px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:120%;color:#CCCCCC;\">Put your preheader text here</p> </td> \n" +
"                     </tr> \n" +
"                   </table> </td> \n" +
"                 </tr> \n" +
"               </table> \n" +
"               <!--[if mso]></td><td width=\"20\"></td><td width=\"270\" valign=\"top\"><![endif]--> \n" +
"               <table class=\"es-right\" cellspacing=\"0\" cellpadding=\"0\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right;\"> \n" +
"                 <tr style=\"border-collapse:collapse;\"> \n" +
"                  <td width=\"270\" align=\"left\" style=\"padding:0;Margin:0;\"> \n" +
"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
"                     <tr style=\"border-collapse:collapse;\"> \n" +
"                      <td class=\"es-infoblock es-m-txt-c\" align=\"right\" style=\"padding:0;Margin:0;line-height:120%;font-size:12px;color:#CCCCCC;\"> <p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:12px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:120%;color:#CCCCCC;\"><a href=\"http://#\" target=\"_blank\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:12px;text-decoration:underline;color:#CCCCCC;\">View in browser</a></p> </td> \n" +
"                     </tr> \n" +
"                   </table> </td> \n" +
"                 </tr> \n" +
"               </table> \n" +
"               <!--[if mso]></td></tr></table><![endif]--> </td> \n" +
"             </tr> \n" +
"           </table> </td> \n" +
"         </tr> \n" +
"       </table> \n" +
"       <table class=\"es-header\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top;\"> \n" +
"         <tr style=\"border-collapse:collapse;\"> \n" +
"          <td align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
"           <table class=\"es-header-body\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FEF5E4;\"> \n" +
"             <tr style=\"border-collapse:collapse;\"> \n" +
"              <td align=\"left\" style=\"Margin:0;padding-top:5px;padding-bottom:5px;padding-left:15px;padding-right:15px;\"> \n" +
"               <!--[if mso]><table width=\"570\" cellpadding=\"0\" cellspacing=\"0\"><tr><td width=\"180\" valign=\"top\"><![endif]--> \n" +
"               <table class=\"es-left\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left;\"> \n" +
"                 <tr style=\"border-collapse:collapse;\"> \n" +
"                  <td class=\"es-m-p0r\" width=\"180\" valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
"                     <tr style=\"border-collapse:collapse;\"> \n" +
"                      <td class=\"es-m-p0l es-m-txt-c\" align=\"left\" style=\"padding:0;Margin:0;padding-left:15px;\"> <a href=\"#\" target=\"_blank\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:14px;text-decoration:underline;color:#999999;\"><h2>DNTShop</h2></a> </td> \n" +
"                     </tr> \n" +
"                   </table> </td> \n" +
"                 </tr> \n" +
"               </table> \n" +
"               <!--[if mso]></td><td width=\"20\"></td><td width=\"370\" valign=\"top\"><![endif]--> \n" +
"               <table cellspacing=\"0\" cellpadding=\"0\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
"                 <tr style=\"border-collapse:collapse;\"> \n" +
"                  <td width=\"370\" align=\"left\" style=\"padding:0;Margin:0;\"> \n" +
"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
"                     <tr style=\"border-collapse:collapse;\"> \n" +
"                      <td align=\"center\" style=\"padding:0;Margin:0;display:none;\"></td> \n" +
"                     </tr> \n" +
"                   </table> </td> \n" +
"                 </tr> \n" +
"               </table> \n" +
"               <!--[if mso]></td></tr></table><![endif]--> </td> \n" +
"             </tr> \n" +
"           </table> </td> \n" +
"         </tr> \n" +
"       </table> \n" +
"       <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;\"> \n" +
"         <tr style=\"border-collapse:collapse;\"> \n" +
"          <td align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
"           <table class=\"es-content-body\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;\"> \n" +
"             <tr style=\"border-collapse:collapse;\"> \n" +
"              <td align=\"left\" style=\"Margin:0;padding-top:10px;padding-bottom:10px;padding-left:20px;padding-right:20px;\"> \n" +
"               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
"                 <tr style=\"border-collapse:collapse;\"> \n" +
"                  <td width=\"560\" valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
"                   <table style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:separate;border-spacing:0px;border-radius:0px;\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"> \n" +
"                     <tr style=\"border-collapse:collapse;\"> \n" +
"                      <td align=\"center\" style=\"padding:0;Margin:0;padding-top:10px;padding-bottom:15px;\"> <h1 style=\"Margin:0;line-height:120%;mso-line-height-rule:exactly;font-family:'trebuchet ms', helvetica, sans-serif;font-size:30px;font-style:normal;font-weight:normal;color:#333333;\">Thanks for your order<br></h1> </td> \n" +
"                     </tr> \n" +
"                     <tr style=\"border-collapse:collapse;\"> \n" +
"                      <td align=\"center\" style=\"Margin:0;padding-top:5px;padding-bottom:5px;padding-left:40px;padding-right:40px;\"> <p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:14px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:150%;color:#333333;\">You'll receive an email when your items are shipped. If you have any questions, Call us 0987184873.</p> </td> \n" +
"                     </tr> \n" +
"                   </table> </td> \n" +
"                 </tr> \n" +
"               </table> </td> \n" +
"             </tr> \n" +
"           </table> </td> \n" +
"         </tr> \n" +
"       </table> \n" +
"       <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;\"> \n" +
"         <tr style=\"border-collapse:collapse;\"> \n" +
"          <td align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
"           <table class=\"es-content-body\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;\"> \n" +
"             <tr style=\"border-collapse:collapse;\"> \n" +
"              <td align=\"left\" style=\"Margin:0;padding-top:20px;padding-left:20px;padding-right:20px;padding-bottom:30px;\"> \n" +
"               <!--[if mso]><table width=\"560\" cellpadding=\"0\" cellspacing=\"0\"><tr><td width=\"280\" valign=\"top\"><![endif]--> \n" +
"               <table class=\"es-left\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left;\"> \n" +
"                 <tr style=\"border-collapse:collapse;\"> \n" +
"                  <td class=\"es-m-p20b\" width=\"280\" align=\"left\" style=\"padding:0;Margin:0;\"> \n" +
"                   <table style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:separate;border-spacing:0px;background-color:#FEF9EF;border-color:#EFEFEF;border-width:1px 0px 1px 1px;border-style:solid;\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#fef9ef\"> \n" +
"                     <tr style=\"border-collapse:collapse;\"> \n" +
"                      <td align=\"left\" style=\"Margin:0;padding-bottom:10px;padding-top:20px;padding-left:20px;padding-right:20px;\"> <h4 style=\"Margin:0;line-height:120%;mso-line-height-rule:exactly;font-family:'trebuchet ms', helvetica, sans-serif;\">SUMMARY:</h4> </td> \n" +
"                     </tr> \n" +
"                     <tr style=\"border-collapse:collapse;\"> \n" +
"                      <td align=\"left\" style=\"padding:0;Margin:0;padding-bottom:20px;padding-left:20px;padding-right:20px;\"> \n" +
"                       <table style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;width:100%;\" class=\"cke_show_border\" cellspacing=\"1\" cellpadding=\"1\" border=\"0\" align=\"left\"> \n" +
"                         <tr style=\"border-collapse:collapse;\"> \n" +
"                          <td style=\"padding:0;Margin:0;\"><span style=\"font-size:14px;line-height:150%;\">Order #:</span></td> \n" +
"                          <td style=\"padding:0;Margin:0;\"><span style=\"font-size:14px;line-height:150%;\">"+or.getOrderID()+"</span></td> \n" +
"                         </tr> \n" +
"                         <tr style=\"border-collapse:collapse;\"> \n" +
"                          <td style=\"padding:0;Margin:0;\"><span style=\"font-size:14px;line-height:150%;\">Order Date:</span></td> \n" +
"                          <td style=\"padding:0;Margin:0;\"><span style=\"font-size:14px;line-height:150%;\">"+or.getOrderDate()+"</span></td> \n" +
"                         </tr> \n" +
"                         <tr style=\"border-collapse:collapse;\"> \n" +
"                          <td style=\"padding:0;Margin:0;\"><span style=\"font-size:14px;line-height:150%;\">Order Total:</span></td> \n" +
"                          <td style=\"padding:0;Margin:0;\"><span style=\"font-size:14px;line-height:150%;\">$"+or.getTotal()+"</span></td> \n" +
"                         </tr> \n" +
"                       </table> <p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:14px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:150%;color:#333333;\"><br></p> </td> \n" +
"                     </tr> \n" +
"                   </table> </td> \n" +
"                 </tr> \n" +
"               </table> \n" +
"               <!--[if mso]></td><td width=\"0\"></td><td width=\"280\" valign=\"top\"><![endif]--> \n" +
"               <table class=\"es-right\" cellspacing=\"0\" cellpadding=\"0\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right;\"> \n" +
"                 <tr style=\"border-collapse:collapse;\"> \n" +
"                  <td width=\"280\" align=\"left\" style=\"padding:0;Margin:0;\"> \n" +
"                   <table style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:separate;border-spacing:0px;background-color:#FEF9EF;border-width:1px;border-style:solid;border-color:#EFEFEF;\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#fef9ef\"> \n" +
"                     <tr style=\"border-collapse:collapse;\"> \n" +
"                      <td align=\"left\" style=\"Margin:0;padding-bottom:10px;padding-top:20px;padding-left:20px;padding-right:20px;\"> <h4 style=\"Margin:0;line-height:120%;mso-line-height-rule:exactly;font-family:'trebuchet ms', helvetica, sans-serif;\">SHIPPING ADDRESS:<br></h4> </td> \n" +
"                     </tr> \n" +
                    "<tr style=\"border-collapse:collapse;\"> \n" +
"                      <td align=\"left\" style=\"padding:0;Margin:0;padding-bottom:20px;padding-left:20px;padding-right:20px;\"> <p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:14px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:150%;color:#333333;\">"+or.getShipAddress()+"</p> <p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:14px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:150%;color:#333333;\"></p> <p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:14px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:150%;color:#333333;\"></p> </td> \n" +
"                     </tr> "+
"                   </table> </td> \n" +
"                 </tr> \n" +
"               </table> \n" +
"               <!--[if mso]></td></tr></table><![endif]--> </td> \n" +
"             </tr> \n" +
"           </table> </td> \n" +
"         </tr> \n" +
"       </table> \n" +
"       <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;\"> \n" +
"         <tr style=\"border-collapse:collapse;\"> \n" +
"          <td align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
"           <table class=\"es-content-body\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;\"> \n" +
"             <tr style=\"border-collapse:collapse;\"> \n" +
"              <td align=\"left\" style=\"Margin:0;padding-top:10px;padding-bottom:10px;padding-left:20px;padding-right:20px;\"> \n" +
"               <!--[if mso]><table width=\"560\" cellpadding=\"0\" cellspacing=\"0\"><tr><td width=\"270\" valign=\"top\"><![endif]--> \n" +
"               <table class=\"es-left\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left;\"> \n" +
"                 <tr style=\"border-collapse:collapse;\"> \n" +
"                  <td class=\"es-m-p0r es-m-p20b\" width=\"270\" valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
"                 </tr> \n" +
"               </table> \n" +
"               <!--[if mso]></td><td width=\"20\"></td><td width=\"270\" valign=\"top\"><![endif]--> \n" +
"               <table cellspacing=\"0\" cellpadding=\"0\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
"                 <tr style=\"border-collapse:collapse;\"> \n" +
"                  <td width=\"270\" align=\"left\" style=\"padding:0;Margin:0;\"> \n" +
"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
"                     <tr style=\"border-collapse:collapse;\"> \n" +
"                      <td align=\"left\" style=\"padding:0;Margin:0;\"> \n" +
"                       <table style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;width:100%;\" class=\"cke_show_border\" cellspacing=\"1\" cellpadding=\"1\" border=\"0\"> \n" +
"                         <tr style=\"border-collapse:collapse;\"> \n" +
"                          <td style=\"padding:0;Margin:0;\"><span style=\"font-size:13px;\">NAME</span></td> \n" +
"                          <td style=\"padding:0;Margin:0;text-align:center;\" width=\"60\"><span style=\"font-size:13px;\"><span style=\"line-height:100%;\">QTY</span></span> </td> \n" +
"                          <td style=\"padding:0;Margin:0;text-align:center;\" width=\"100\"><span style=\"font-size:13px;\"><span style=\"line-height:100%;\">PRICE</span></span> </td> \n" +
"                         </tr> \n" +
"                       </table> </td> \n" +
"                     </tr> \n" +
"                   </table> </td> \n" +
"                 </tr> \n" +
"               </table> \n" +
"               <!--[if mso]></td></tr></table><![endif]--> </td> \n" +
"             </tr> \n" +
"             <tr style=\"border-collapse:collapse;\"> \n" +
"              <td align=\"left\" style=\"padding:0;Margin:0;padding-left:20px;padding-right:20px;\"> \n" +
"               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
"                 <tr style=\"border-collapse:collapse;\"> \n" +
"                  <td width=\"560\" valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
"                     <tr style=\"border-collapse:collapse;\"> \n" +
"                      <td align=\"center\" style=\"padding:0;Margin:0;padding-bottom:10px;\"> \n" +
"                       <table width=\"100%\" height=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
"                         <tr style=\"border-collapse:collapse;\"> \n" +
"                          <td style=\"padding:0;Margin:0px;border-bottom:1px solid #EFEFEF;background:rgba(0, 0, 0, 0) none repeat scroll 0% 0%;height:1px;width:100%;margin:0px;\"></td> \n" +
"                         </tr> \n" +
"                       </table> </td> \n" +
"                     </tr> \n" +
"                   </table> </td> \n" +
"                 </tr> \n" +
"               </table> </td> \n" +
"             </tr> \n" +htmlMini+          
"             <tr style=\"border-collapse:collapse;\"> \n" +
"              <td align=\"left\" style=\"padding:0;Margin:0;padding-left:20px;padding-right:20px;\"> \n" +
"               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
"                 <tr style=\"border-collapse:collapse;\"> \n" +
"                  <td width=\"560\" valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
"                     <tr style=\"border-collapse:collapse;\"> \n" +
"                      <td align=\"center\" style=\"padding:0;Margin:0;padding-bottom:10px;\"> \n" +
"                       <table width=\"100%\" height=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
"                         <tr style=\"border-collapse:collapse;\"> \n" +
"                          <td style=\"padding:0;Margin:0px;border-bottom:1px solid #EFEFEF;background:rgba(0, 0, 0, 0) none repeat scroll 0% 0%;height:1px;width:100%;margin:0px;\"></td> \n" +
"                         </tr> \n" +
"                       </table> </td> \n" +
"                     </tr> \n" +
"                   </table> </td> \n" +
"                 </tr> \n" +
"               </table> </td> \n" +
"             </tr> \n" +
"             <tr style=\"border-collapse:collapse;\"> \n" +
"              <td align=\"left\" style=\"Margin:0;padding-top:5px;padding-left:20px;padding-bottom:30px;padding-right:40px;\"> \n" +
"               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
"                 <tr style=\"border-collapse:collapse;\"> \n" +
"                  <td width=\"540\" valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
"                     <tr style=\"border-collapse:collapse;\"> \n" +
"                      <td align=\"right\" style=\"padding:0;Margin:0;\"> \n" +
"                       <table style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;width:500px;\" class=\"cke_show_border\" cellspacing=\"1\" cellpadding=\"1\" border=\"0\" align=\"right\"> \n" +
"                         <tr style=\"border-collapse:collapse;\"> \n" +
"                          <td style=\"padding:0;Margin:0;text-align:right;font-size:18px;line-height:150%;\">Subtotal ("+detailsFacade.findByOrderId(orderid).size()+" items):</td> \n" +
"                          <td style=\"padding:0;Margin:0;text-align:right;font-size:18px;line-height:150%;\">$"+or.getTotal()+"</td> \n" +
"                         </tr> \n" +
"                         <tr style=\"border-collapse:collapse;\"> \n" +
"                         <tr style=\"border-collapse:collapse;\"> \n" +
"                          <td style=\"padding:0;Margin:0;text-align:right;font-size:18px;line-height:150%;\"><strong>Order Total:</strong></td> \n" +
"                          <td style=\"padding:0;Margin:0;text-align:right;font-size:18px;line-height:150%;color:#D48344;\"><strong>$"+or.getTotal()+"</strong></td> \n" +
"                         </tr> \n" +
"                       </table> <p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:14px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:150%;color:#333333;\"><br></p> </td> \n" +
"                     </tr> \n" +
"                   </table> </td> \n" +
"                 </tr> \n" +
"               </table> </td> \n" +
"             </tr> \n" +
"           </table> </td> \n" +
"         </tr> \n" +
"       </table> \n" +
"       <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;\"> \n" +
"         <tr style=\"border-collapse:collapse;\"> \n" +
"         </tr> \n" +
"         <tr style=\"border-collapse:collapse;\"> \n" +
"          <td align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
"           <table class=\"es-footer-body\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FEF5E4;\"> \n" +
"             <tr style=\"border-collapse:collapse;\"> \n" +
"              <td align=\"left\" style=\"padding:20px;Margin:0;\"> \n" +
"               <!--[if mso]><table width=\"560\" cellpadding=\"0\" cellspacing=\"0\"><tr><td width=\"178\" valign=\"top\"><![endif]--> \n" +
"               <table class=\"es-left\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left;\"> \n" +
"                 <tr style=\"border-collapse:collapse;\"> \n" +
"                  <td class=\"es-m-p0r es-m-p20b\" width=\"178\" valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
"       </table> \n" +
"  </div>  \n" +
" </body>\n" +
"</html>");
        }else if(pstatus.equals("Canceled")){
            sm.sendMail(or.getCustomerID().getEmail(), "Order confirmation", "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
"<html style=\"width:100%;font-family:arial, 'helvetica neue', helvetica, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0;\">\n" +
" <head> \n" +
"  <meta charset=\"UTF-8\"> \n" +
"  <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\"> \n" +
"  <meta name=\"x-apple-disable-message-reformatting\"> \n" +
"  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"> \n" +
"  <meta content=\"telephone=no\" name=\"format-detection\"> \n" +
"  <title>nguyenhoangnam3397@gmail.com</title> \n" +
"  <!--[if (mso 16)]>\n" +
"    <style type=\"text/css\">\n" +
"    a {text-decoration: none;}\n" +
"    </style>\n" +
"    <![endif]--> \n" +
"  <!--[if gte mso 9]><style>sup { font-size: 100% !important; }</style><![endif]--> \n" +
"  <style type=\"text/css\">\n" +
"@media only screen and (max-width:600px) {p, ul li, ol li, a { font-size:16px!important } h1 { font-size:30px!important; text-align:center } h2 { font-size:26px!important; text-align:center } h3 { font-size:20px!important; text-align:center } h1 a { font-size:30px!important } h2 a { font-size:26px!important } h3 a { font-size:20px!important } .es-header-body p, .es-header-body ul li, .es-header-body ol li, .es-header-body a { font-size:16px!important } .es-footer-body p, .es-footer-body ul li, .es-footer-body ol li, .es-footer-body a { font-size:16px!important } .es-infoblock p, .es-infoblock ul li, .es-infoblock ol li, .es-infoblock a { font-size:12px!important } *[class=\"gmail-fix\"] { display:none!important } .es-m-txt-c, .es-m-txt-c h1, .es-m-txt-c h2, .es-m-txt-c h3 { text-align:center!important } .es-m-txt-r, .es-m-txt-r h1, .es-m-txt-r h2, .es-m-txt-r h3 { text-align:right!important } .es-m-txt-l, .es-m-txt-l h1, .es-m-txt-l h2, .es-m-txt-l h3 { text-align:left!important } .es-m-txt-r img, .es-m-txt-c img, .es-m-txt-l img { display:inline!important } .es-button-border { display:block!important } .es-button { font-size:20px!important; display:block!important; border-left-width:0px!important; border-right-width:0px!important } .es-btn-fw { border-width:10px 0px!important; text-align:center!important } .es-adaptive table, .es-btn-fw, .es-btn-fw-brdr, .es-left, .es-right { width:100%!important } .es-content table, .es-header table, .es-footer table, .es-content, .es-footer, .es-header { width:100%!important; max-width:600px!important } .es-adapt-td { display:block!important; width:100%!important } .adapt-img { width:100%!important; height:auto!important } .es-m-p0 { padding:0px!important } .es-m-p0r { padding-right:0px!important } .es-m-p0l { padding-left:0px!important } .es-m-p0t { padding-top:0px!important } .es-m-p0b { padding-bottom:0!important } .es-m-p20b { padding-bottom:20px!important } .es-mobile-hidden, .es-hidden { display:none!important } .es-desk-hidden { display:table-row!important; width:auto!important; overflow:visible!important; float:none!important; max-height:inherit!important; line-height:inherit!important } .es-desk-menu-hidden { display:table-cell!important } table.es-table-not-adapt, .esd-block-html table { width:auto!important } table.es-social { display:inline-block!important } table.es-social td { display:inline-block!important } .es-menu td a { font-size:16px!important } }\n" +
"#outlook a {\n" +
"	padding:0;\n" +
"}\n" +
".ExternalClass {\n" +
"	width:100%;\n" +
"}\n" +
".ExternalClass,\n" +
".ExternalClass p,\n" +
".ExternalClass span,\n" +
".ExternalClass font,\n" +
".ExternalClass td,\n" +
".ExternalClass div {\n" +
"	line-height:100%;\n" +
"}\n" +
".es-button {\n" +
"	mso-style-priority:100!important;\n" +
"	text-decoration:none!important;\n" +
"}\n" +
"a[x-apple-data-detectors] {\n" +
"	color:inherit!important;\n" +
"	text-decoration:none!important;\n" +
"	font-size:inherit!important;\n" +
"	font-family:inherit!important;\n" +
"	font-weight:inherit!important;\n" +
"	line-height:inherit!important;\n" +
"}\n" +
".es-desk-hidden {\n" +
"	display:none;\n" +
"	float:left;\n" +
"	overflow:hidden;\n" +
"	width:0;\n" +
"	max-height:0;\n" +
"	line-height:0;\n" +
"	mso-hide:all;\n" +
"}\n" +
"</style> \n" +
" </head> \n" +
" <body style=\"width:100%;font-family:arial, 'helvetica neue', helvetica, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0;\"> \n" +
"  <div class=\"es-wrapper-color\" style=\"background-color:#EFEFEF;\"> \n" +
"   <!--[if gte mso 9]>\n" +
"			<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\n" +
"				<v:fill type=\"tile\" color=\"#efefef\"></v:fill>\n" +
"			</v:background>\n" +
"		<![endif]--> \n" +
"   <table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;padding:0;Margin:0;width:100%;height:100%;background-repeat:repeat;background-position:center top;\"> \n" +
"     <tr style=\"border-collapse:collapse;\"> \n" +
"      <td valign=\"top\" style=\"padding:0;Margin:0;\"> \n" +
"       <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;\"> \n" +
"         <tr style=\"border-collapse:collapse;\"> \n" +
"          <td class=\"es-adaptive\" align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
"           <table class=\"es-content-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#EFEFEF;\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\"> \n" +
"             <tr style=\"border-collapse:collapse;\"> \n" +
"              <td align=\"left\" style=\"Margin:0;padding-top:5px;padding-bottom:5px;padding-left:20px;padding-right:20px;\"> \n" +
"               <!--[if mso]><table width=\"560\" cellpadding=\"0\" cellspacing=\"0\"><tr><td width=\"270\" valign=\"top\"><![endif]--> \n" +
"               <table class=\"es-left\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left;\"> \n" +
"                 <tr style=\"border-collapse:collapse;\"> \n" +
"                  <td width=\"270\" align=\"left\" style=\"padding:0;Margin:0;\"> \n" +
"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
"                     <tr style=\"border-collapse:collapse;\"> \n" +
"                      <td class=\"es-infoblock es-m-txt-c\" align=\"left\" style=\"padding:0;Margin:0;line-height:120%;font-size:12px;color:#CCCCCC;\"> <p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:12px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:120%;color:#CCCCCC;\">Put your preheader text here</p> </td> \n" +
"                     </tr> \n" +
"                   </table> </td> \n" +
"                 </tr> \n" +
"               </table> \n" +
"               <!--[if mso]></td><td width=\"20\"></td><td width=\"270\" valign=\"top\"><![endif]--> \n" +
"               <table class=\"es-right\" cellspacing=\"0\" cellpadding=\"0\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right;\"> \n" +
"                 <tr style=\"border-collapse:collapse;\"> \n" +
"                  <td width=\"270\" align=\"left\" style=\"padding:0;Margin:0;\"> \n" +
"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
"                     <tr style=\"border-collapse:collapse;\"> \n" +
"                      <td class=\"es-infoblock es-m-txt-c\" align=\"right\" style=\"padding:0;Margin:0;line-height:120%;font-size:12px;color:#CCCCCC;\"> <p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:12px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:120%;color:#CCCCCC;\"><a href=\"http://#\" target=\"_blank\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:12px;text-decoration:underline;color:#CCCCCC;\">View in browser</a></p> </td> \n" +
"                     </tr> \n" +
"                   </table> </td> \n" +
"                 </tr> \n" +
"               </table> \n" +
"               <!--[if mso]></td></tr></table><![endif]--> </td> \n" +
"             </tr> \n" +
"           </table> </td> \n" +
"         </tr> \n" +
"       </table> \n" +
"       <table class=\"es-header\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top;\"> \n" +
"         <tr style=\"border-collapse:collapse;\"> \n" +
"          <td align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
"           <table class=\"es-header-body\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FEF5E4;\"> \n" +
"             <tr style=\"border-collapse:collapse;\"> \n" +
"              <td align=\"left\" style=\"Margin:0;padding-top:5px;padding-bottom:5px;padding-left:15px;padding-right:15px;\"> \n" +
"               <!--[if mso]><table width=\"570\" cellpadding=\"0\" cellspacing=\"0\"><tr><td width=\"180\" valign=\"top\"><![endif]--> \n" +
"               <table class=\"es-left\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left;\"> \n" +
"                 <tr style=\"border-collapse:collapse;\"> \n" +
"                  <td class=\"es-m-p0r\" width=\"180\" valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
"                     <tr style=\"border-collapse:collapse;\"> \n" +
"                      <td align=\"center\" style=\"padding:35px;Margin:0;\"> <p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:14px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:150%;color:#110E0E;\">DNTShop</p></td> \n" +
"                     </tr> \n" +
"                   </table> </td> \n" +
"                 </tr> \n" +
"               </table> \n" +
"               <!--[if mso]></td><td width=\"20\"></td><td width=\"370\" valign=\"top\"><![endif]--> \n" +
"               <table cellspacing=\"0\" cellpadding=\"0\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
"                 <tr style=\"border-collapse:collapse;\"> \n" +
"                  <td width=\"370\" align=\"left\" style=\"padding:0;Margin:0;\"> \n" +
"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
"                     <tr style=\"border-collapse:collapse;\"> \n" +
"                      <td align=\"center\" style=\"padding:0;Margin:0;display:none;\"></td> \n" +
"                     </tr> \n" +
"                   </table> </td> \n" +
"                 </tr> \n" +
"               </table> \n" +
"               <!--[if mso]></td></tr></table><![endif]--> </td> \n" +
"             </tr> \n" +
"           </table> </td> \n" +
"         </tr> \n" +
"       </table> \n" +
"       <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;\"> \n" +
"         <tr style=\"border-collapse:collapse;\"> \n" +
"          <td align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
"           <table class=\"es-content-body\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;\"> \n" +
"             <tr style=\"border-collapse:collapse;\"> \n" +
"              <td align=\"left\" style=\"Margin:0;padding-top:10px;padding-bottom:10px;padding-left:20px;padding-right:20px;\"> \n" +
"               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
"                 <tr style=\"border-collapse:collapse;\"> \n" +
"                  <td width=\"560\" valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
"                   <table style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:separate;border-spacing:0px;border-radius:0px;\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"> \n" +
"                     <tr style=\"border-collapse:collapse;\"> \n" +
"                      <td align=\"center\" style=\"padding:0;Margin:0;padding-top:10px;padding-bottom:15px;\"> <h1 style=\"Margin:0;line-height:120%;mso-line-height-rule:exactly;font-family:'trebuchet ms', helvetica, sans-serif;font-size:30px;font-style:normal;font-weight:normal;color:#333333;\"> Your order has been canceled</h1> </td> \n" +
"                     </tr> \n" +
"                     <tr style=\"border-collapse:collapse;\"> \n" +
"                      <td align=\"center\" style=\"Margin:0;padding-top:5px;padding-bottom:5px;padding-left:40px;padding-right:40px;\"> <p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:14px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:150%;color:#333333;\">Your order has been canceled for some reason. We apologize for the inconvenience.</p> </td> \n" +
"                     </tr> \n" +
"                   </table> </td> \n" +
"                 </tr> \n" +
"               </table> </td> \n" +
"             </tr> \n" +
"           </table> </td> \n" +
"         </tr> \n" +
"       </table> \n" +
"       <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;\"> \n" +
"         <tr style=\"border-collapse:collapse;\"> \n" +
"          <td align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
"           <table class=\"es-content-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\"> \n" +
"             <tr style=\"border-collapse:collapse;\"> \n" +
"              <td align=\"left\" style=\"Margin:0;padding-left:20px;padding-right:20px;padding-top:30px;padding-bottom:30px;\"> \n" +
"               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
"                 <tr style=\"border-collapse:collapse;\"> \n" +
"                  <td width=\"560\" valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
"                     <tr style=\"border-collapse:collapse;\"> \n" +
"                      <td align=\"center\" style=\"padding:0;Margin:0;display:none;\"></td> \n" +
"                     </tr> \n" +
"                   </table> </td> \n" +
"                 </tr> \n" +
"               </table> </td> \n" +
"             </tr> \n" +
"           </table> </td> \n" +
"         </tr> \n" +
"       </table> </td> \n" +
"     </tr> \n" +
"   </table> \n" +
"  </div>  \n" +
" </body>\n" +
"</html>");
        }
        request.getRequestDispatcher("adminViewSale").forward(request, response);
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
