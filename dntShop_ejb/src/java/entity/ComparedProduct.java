package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ComparedProduct implements Serializable {
    List<Products> comparedProducts;

    public List<Products> getComparedProducts() {
        return comparedProducts;
    }

    public ComparedProduct() {
        this.comparedProducts = new ArrayList<>();
    }
    
    public void setComparedProducts(List<Products> comparedProducts) {
        this.comparedProducts = comparedProducts;
    }
    public void addToComparedList(Products prod) {
        if (!comparedProducts.contains(prod)) {
            comparedProducts.add(prod);
        }
    }
    public void removeFromComparedList(Products prod) {
        if (comparedProducts.contains(prod)) {
            comparedProducts.remove(prod);
        }
    }
    
    public void clearList() {
        comparedProducts.clear();
    }
    
    
}
