/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AdminController;

import bean.CustomersFacadeLocal;
import entity.Customers;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Duy
 */
@WebServlet(name = "adminUpdateCustomer", urlPatterns = {"/adminUpdateCustomer"})
public class adminUpdateCustomer extends HttpServlet {
    String bra_id="";
    @EJB
    CustomersFacadeLocal cusFacade;

    private static final long serialVersionUID = 1L;

    // location to store file uploaded
    private static final String UPLOAD_DIRECTORY = "images/Avatars";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        bra_id = request.getParameter("cus_id");
        request.setAttribute("cus", cusFacade.find(bra_id));
        request.getRequestDispatcher("adminUpdateCustomer.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        // configures upload settings
        DiskFileItemFactory factory = new DiskFileItemFactory();

        ServletFileUpload upload = new ServletFileUpload(factory);

        String uploadPath = getServletContext().getRealPath("")
                + File.separator + UPLOAD_DIRECTORY;

        // creates the directory if it does not exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        try {
            // parses the request's content to extract file data
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);

            Customers bra = cusFacade.find(bra_id);
            
            if (formItems != null && formItems.size() > 0) {
                // iterates over form's fields
                for (FileItem item : formItems) {
                    // processes only fields that are not form fields
                    if (item.isFormField()) {
                        // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
                        switch (item.getFieldName()) {
                            case "fName":
                                bra.setFirstName(item.getString());
                                continue;
                            case "lName":
                                bra.setLastName(item.getString());
                                continue;
                            case "email":
                                bra.setEmail(item.getString());
                                continue;
                            case "password":
                                bra.setPassword(item.getString());
                                continue;
                            case "gender":
                                if (item.getString().equals("Male")) {
                                    bra.setGender(Boolean.TRUE);
                                } else {
                                    bra.setGender(Boolean.FALSE);
                                }
                                continue;
                            case "phone":
                                bra.setPhone(item.getString());
                                continue;
                            case "address":
                                bra.setAddress(item.getString());
                                continue;

                        }
                    } else {
                        String fileName = new File(item.getName()).getName();

                        if (fileName.isEmpty()) {
                            // do not thing
                        } else {
                            String newfileName = fileName.substring(fileName.lastIndexOf('.'));
                            String filePath = uploadPath + File.separator + bra_id + newfileName;
                            File storeFile = new File(filePath);
                            // saves the file on disk
                            item.write(storeFile);
                            String brandImage = (UPLOAD_DIRECTORY + "/" + bra_id + newfileName);
                            bra.setAvatar(brandImage);
                        }
                    }
                }
            }
            cusFacade.edit(bra);
        } catch (Exception ex) {
            ex.getStackTrace();
        }
        // redirects client to message page      
        getServletContext().getRequestDispatcher("/adminViewCustomer").forward(request, response);
    }

    
}
