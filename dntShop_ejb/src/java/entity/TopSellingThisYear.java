/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Duy
 */
@Entity
@Table(name = "TopSellingThisYear", catalog = "dntShop", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TopSellingThisYear.findAll", query = "SELECT t FROM TopSellingThisYear t"),
    @NamedQuery(name = "TopSellingThisYear.findByProductID", query = "SELECT t FROM TopSellingThisYear t WHERE t.productID = :productID"),
    @NamedQuery(name = "TopSellingThisYear.findByProductName", query = "SELECT t FROM TopSellingThisYear t WHERE t.productName = :productName"),
    @NamedQuery(name = "TopSellingThisYear.findByImage1", query = "SELECT t FROM TopSellingThisYear t WHERE t.image1 = :image1"),
    @NamedQuery(name = "TopSellingThisYear.findByPrice", query = "SELECT t FROM TopSellingThisYear t WHERE t.price = :price"),
    @NamedQuery(name = "TopSellingThisYear.findByDiscountProduct", query = "SELECT t FROM TopSellingThisYear t WHERE t.discountProduct = :discountProduct"),
    @NamedQuery(name = "TopSellingThisYear.findByCategoryName", query = "SELECT t FROM TopSellingThisYear t WHERE t.categoryName = :categoryName"),
    @NamedQuery(name = "TopSellingThisYear.findByTopSelling", query = "SELECT t FROM TopSellingThisYear t WHERE t.topSelling = :topSelling")})
public class TopSellingThisYear implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ProductID", nullable = false, length = 10)
    @Id
    private String productID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ProductName", nullable = false, length = 100)
    private String productName;
    @Size(max = 2147483647)
    @Column(name = "Image1", length = 2147483647)
    private String image1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price", nullable = false)
    private int price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DiscountProduct", nullable = false)
    private int discountProduct;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CategoryName", nullable = false, length = 100)
    private String categoryName;
    @Column(name = "TopSelling")
    private BigInteger topSelling;

    public TopSellingThisYear() {
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscountProduct() {
        return discountProduct;
    }

    public void setDiscountProduct(int discountProduct) {
        this.discountProduct = discountProduct;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public BigInteger getTopSelling() {
        return topSelling;
    }

    public void setTopSelling(BigInteger topSelling) {
        this.topSelling = topSelling;
    }
    
}
