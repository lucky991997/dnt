
package AdminController;

import bean.CategoriesFacadeLocal;
import entity.Categories;
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
@WebServlet(name = "adminAddCategory", urlPatterns = {"/adminAddCategory"})
public class adminAddCategories extends HttpServlet {

    @EJB CategoriesFacadeLocal cateFacade;
    
    private static final long serialVersionUID = 1L;

    // location to store file uploaded
    private static final String UPLOAD_DIRECTORY = "images/Categories";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
        
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

            Categories bra = new Categories();
            //auto create brand_id 
            int num = cateFacade.count() + 1;
            String id = num + "";
            int lenNum = 3;
            int lenZero = lenNum - id.length();
            for (int i = 0; i < lenZero; i++) {
                id = "0" + id;
            }
            String bra_id = "CA" + id;           
            bra.setCategoryID(bra_id);
            bra.setIsStatus(Boolean.TRUE);
            if (formItems != null && formItems.size() > 0) {
                // iterates over form's fields
                for (FileItem item : formItems) {
                    // processes only fields that are not form fields
                    if (item.isFormField()) {
                        // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
                        switch (item.getFieldName()) {
                            case "cateName":
                                //System.out.println("cateName: " + item.getString());
                                bra.setCategoryName(item.getString());
                                continue;                        
                           
                        }
                    } else {                       
                        String fileName = new File(item.getName()).getName();                       
                        if (fileName.isEmpty()) {
                            String brandImage = null;
                            bra.setCategoryImage(brandImage);
                        } else {
                            String newfileName= fileName.substring(fileName.lastIndexOf('.'));
                            String filePath = uploadPath + File.separator + bra_id + newfileName;
                            File storeFile = new File(filePath);
                            // saves the file on disk
                            item.write(storeFile);
                            String brandImage = (UPLOAD_DIRECTORY + "/" + bra_id + newfileName);                           
                            bra.setCategoryImage(brandImage);                            
                        }
                    }
                }
            }
            cateFacade.create(bra);
        } catch (Exception ex) {
            ex.getStackTrace();
        }
        
        getServletContext().getRequestDispatcher("/adminViewCategories").forward(request, response);
    }

}
