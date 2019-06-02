/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nam_Nguyen
 */
public class ComparedDetailProduct implements Serializable {
     List<ProductsDetails> detailsProducts;

    public ComparedDetailProduct() {
        this.detailsProducts = new ArrayList<>();
    }
    

    public List<ProductsDetails> getDetailsProducts() {
        return detailsProducts;
    }

    public void setDetailsProducts(List<ProductsDetails> detailsProducts) {
        this.detailsProducts = detailsProducts;
    }
    
    
    public void addToDetailsList(ProductsDetails prod) {
        if (!detailsProducts.contains(prod)) {
            detailsProducts.add(prod);
        }
    }
   /* public void addDetailList(ProductsDetails prodetail) {
            detailsProducts.add(prodetail);
    }*/
    public void removeFromDetailList(ProductsDetails prod) {
        if (detailsProducts.contains(prod)) {
            detailsProducts.remove(prod);
        }
    }
    
    public void clearList() {
        detailsProducts.clear();
    }
}
