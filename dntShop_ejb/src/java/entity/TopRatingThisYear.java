/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "TopRatingThisYear", catalog = "dntShop", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TopRatingThisYear.findAll", query = "SELECT t FROM TopRatingThisYear t"),
    @NamedQuery(name = "TopRatingThisYear.findByProductID", query = "SELECT t FROM TopRatingThisYear t WHERE t.productID = :productID"),
    @NamedQuery(name = "TopRatingThisYear.findByProductName", query = "SELECT t FROM TopRatingThisYear t WHERE t.productName = :productName"),
    @NamedQuery(name = "TopRatingThisYear.findByImage1", query = "SELECT t FROM TopRatingThisYear t WHERE t.image1 = :image1"),
    @NamedQuery(name = "TopRatingThisYear.findByPrice", query = "SELECT t FROM TopRatingThisYear t WHERE t.price = :price"),
    @NamedQuery(name = "TopRatingThisYear.findByDiscountProduct", query = "SELECT t FROM TopRatingThisYear t WHERE t.discountProduct = :discountProduct"),
    @NamedQuery(name = "TopRatingThisYear.findByCategoryName", query = "SELECT t FROM TopRatingThisYear t WHERE t.categoryName = :categoryName"),
    @NamedQuery(name = "TopRatingThisYear.findByAverageRating", query = "SELECT t FROM TopRatingThisYear t WHERE t.averageRating = :averageRating"),
    @NamedQuery(name = "TopRatingThisYear.findByCountRating", query = "SELECT t FROM TopRatingThisYear t WHERE t.countRating = :countRating")})
public class TopRatingThisYear implements Serializable {
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "averageRating", precision = 38, scale = 6)
    private BigDecimal averageRating;
    @Column(name = "countRating")
    private Integer countRating;

    public TopRatingThisYear() {
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

    public BigDecimal getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(BigDecimal averageRating) {
        this.averageRating = averageRating;
    }

    public Integer getCountRating() {
        return countRating;
    }

    public void setCountRating(Integer countRating) {
        this.countRating = countRating;
    }
    
}
