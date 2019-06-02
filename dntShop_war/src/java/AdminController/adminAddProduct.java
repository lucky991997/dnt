/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminController;

import bean.BrandsFacadeLocal;
import bean.CategoriesFacadeLocal;
import bean.ProductsDetailsFacadeLocal;
import bean.ProductsFacadeLocal;
import entity.Products;
import entity.ProductsDetails;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "adminAddProduct", urlPatterns = {"/adminAddProduct"})
public class adminAddProduct extends HttpServlet {

    @EJB
    BrandsFacadeLocal brandFacade;
    @EJB
    CategoriesFacadeLocal cateFacade;
    @EJB
    ProductsFacadeLocal proFacade;
    @EJB
    ProductsDetailsFacadeLocal prodetailFacade;
    
    private static final long serialVersionUID = 1L;

    // location to store file uploaded
    private static final String UPLOAD_DIRECTORY = "images/Products";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        request.setAttribute("listBrand", brandFacade.findAll());
        request.setAttribute("listCate", cateFacade.findAll());
        request.getRequestDispatcher("adminAddProduct.jsp").forward(request, response);
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

            Products bra = new Products();
            ProductsDetails pde = new ProductsDetails();
            //auto create pro_id 
            int num = proFacade.count() + 1;
            String id = num + "";
            int lenNum = 3;
            int lenZero = lenNum - id.length();
            for (int i = 0; i < lenZero; i++) {
                id = "0" + id;
            }
            String bra_id = "PR" + id;
            //setProID
            bra.setProductID(bra_id);
            pde.setProductID(bra);
            //setStatus
            bra.setIsStatus(Boolean.TRUE);

            if (formItems != null && formItems.size() > 0) {
                // iterates over form's fields
                for (FileItem item : formItems) {
                    // processes only fields that are not form fields
                    if (item.isFormField()) {
                        // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
                        switch (item.getFieldName()) {
                            case "productName":
                                //System.out.println("BraName: " + item.getString());
                                bra.setProductName(item.getString());
                                continue;
                            case "price":
                                //System.out.println("price: " + item.getString());
                                bra.setPrice(Integer.parseInt(item.getString()));
                                continue;
                            case "discount":
                                //System.out.println("price: " + item.getString());
                                bra.setDiscountProduct(Integer.parseInt(item.getString()));
                                continue;
                            case "descrip":
                                //System.out.println("price: " + item.getString());
                                bra.setDescriptions(item.getString());
                                continue;
                            case "brandID":
                                //System.out.println("Description: " + item.getString());
                                bra.setBrandID(brandFacade.find(item.getString()));
                                continue;
                            case "cateID":
                                //System.out.println("Description: " + item.getString());
                                bra.setCategoryID(cateFacade.find(item.getString()));
                                continue;
                            case "feature":
                                //System.out.println("Description: " + item.getString());
                                bra.setFeature(item.getString());
                                continue;
                            case "CPU":
                                pde.setCpu(item.getString());
                                continue;
                            case "Memory":
                                pde.setMemory(item.getString());
                                continue;
                            case "VGA":
                                pde.setVga(item.getString());
                                continue;
                            case "HDD":
                                pde.setHdd(item.getString());
                                continue;
                            case "Camera":
                                pde.setCamera(item.getString());
                                continue;
                            case "Display":
                                pde.setDisplay(item.getString());
                                continue;
                            case "Battery":
                                pde.setBattery(item.getString());
                                continue;
                            case "Weight":
                                pde.setWeights(item.getString());
                                continue;
                            
                        }
                    } else {
                        switch (item.getFieldName()) {
                            case "inputImage1":
                                String fileName1 = new File(item.getName()).getName();
                                if (fileName1.isEmpty()) {
                                    String brandImage = null;
                                    bra.setImage1(brandImage);
                                } else {
                                    String newfileName = fileName1.substring(fileName1.lastIndexOf('.'));
                                    String filePath1 = uploadPath + File.separator + bra_id + "-1" + newfileName;
                                    File storeFile1 = new File(filePath1);
                                    // saves the file on disk
                                    item.write(storeFile1);
                                    String brandImage1 = (bra_id + "-1" + newfileName);
                                    bra.setImage1(brandImage1);
                                }
                                continue;
                            case "inputImage2":
                                String fileName2 = new File(item.getName()).getName();
                                if (fileName2.isEmpty()) {
                                    String brandImage2 = null;
                                    bra.setImage2(brandImage2);
                                } else {
                                    String newfileName = fileName2.substring(fileName2.lastIndexOf('.'));
                                    String filePath2 = uploadPath + File.separator + bra_id + "-2" + newfileName;
                                    File storeFile2 = new File(filePath2);
                                    // saves the file on disk
                                    item.write(storeFile2);
                                    String brandImage2 = (bra_id + "-2" + newfileName);
                                    bra.setImage2(brandImage2);
                                }
                                continue;
                            case "inputImage3":
                                String fileName3 = new File(item.getName()).getName();
                                if (fileName3.isEmpty()) {
                                    String brandImage3 = null;
                                    bra.setImage3(brandImage3);
                                } else {
                                    String newfileName = fileName3.substring(fileName3.lastIndexOf('.'));
                                    String filePath3 = uploadPath + File.separator + bra_id + "-3" + newfileName;
                                    File storeFile3 = new File(filePath3);
                                    // saves the file on disk
                                    item.write(storeFile3);
                                    String brandImage3 = (bra_id + "-3" + newfileName);
                                    bra.setImage3(brandImage3);
                                }
                                continue;
                            case "inputImage4":
                                String fileName4 = new File(item.getName()).getName();
                                if (fileName4.isEmpty()) {
                                    String brandImage4 = null;
                                    bra.setImage4(brandImage4);
                                } else {
                                    String newfileName = fileName4.substring(fileName4.lastIndexOf('.'));
                                    String filePath4 = uploadPath + File.separator + bra_id + "-4" + newfileName;
                                    File storeFile4 = new File(filePath4);
                                    // saves the file on disk
                                    item.write(storeFile4);
                                    String brandImage4 = (bra_id + "-4" + newfileName);
                                    bra.setImage4(brandImage4);
                                }
                        }
                    }
                }
            }
            proFacade.create(bra);
            prodetailFacade.create(pde);
        } catch (Exception ex) {
            ex.getStackTrace();
        }
        // redirects client to message page      
        getServletContext().getRequestDispatcher("/adminViewProduct").forward(request, response);
    }

}
