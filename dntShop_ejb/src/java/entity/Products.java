/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Duy
 */
@Entity
@Table(name = "Products", catalog = "dntShop", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p"),
    @NamedQuery(name = "Products.findByProductID", query = "SELECT p FROM Products p WHERE p.productID = :productID"),
    @NamedQuery(name = "Products.findByProductName", query = "SELECT p FROM Products p WHERE p.productName = :productName"),
    @NamedQuery(name = "Products.findByPrice", query = "SELECT p FROM Products p WHERE p.price = :price"),
    @NamedQuery(name = "Products.findByDiscountProduct", query = "SELECT p FROM Products p WHERE p.discountProduct = :discountProduct"),
    @NamedQuery(name = "Products.findByDescriptions", query = "SELECT p FROM Products p WHERE p.descriptions = :descriptions"),
    @NamedQuery(name = "Products.findByFeature", query = "SELECT p FROM Products p WHERE p.feature = :feature"),
    @NamedQuery(name = "Products.findByImage1", query = "SELECT p FROM Products p WHERE p.image1 = :image1"),
    @NamedQuery(name = "Products.findByImage2", query = "SELECT p FROM Products p WHERE p.image2 = :image2"),
    @NamedQuery(name = "Products.findByImage3", query = "SELECT p FROM Products p WHERE p.image3 = :image3"),
    @NamedQuery(name = "Products.findByImage4", query = "SELECT p FROM Products p WHERE p.image4 = :image4"),
    @NamedQuery(name = "Products.findByIsStatus", query = "SELECT p FROM Products p WHERE p.isStatus = :isStatus")})
public class Products implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productID")
    private Collection<ProductsDetails> productsDetailsCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ProductID", nullable = false, length = 10)
    private String productID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ProductName", nullable = false, length = 100)
    private String productName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price", nullable = false)
    private int price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DiscountProduct", nullable = false)
    private int discountProduct;
    @Size(max = 2147483647)
    @Column(name = "Descriptions", length = 2147483647)
    private String descriptions;
    @Size(max = 100)
    @Column(name = "Feature", length = 100)
    private String feature;
    @Size(max = 2147483647)
    @Column(name = "Image1", length = 2147483647)
    private String image1;
    @Size(max = 2147483647)
    @Column(name = "Image2", length = 2147483647)
    private String image2;
    @Size(max = 2147483647)
    @Column(name = "Image3", length = 2147483647)
    private String image3;
    @Size(max = 2147483647)
    @Column(name = "Image4", length = 2147483647)
    private String image4;
    @Column(name = "IsStatus")
    private Boolean isStatus;
    @JoinColumn(name = "CategoryID", referencedColumnName = "CategoryID", nullable = false)
    @ManyToOne(optional = false)
    private Categories categoryID;
    @JoinColumn(name = "BrandID", referencedColumnName = "BrandID", nullable = false)
    @ManyToOne(optional = false)
    private Brands brandID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productID")
    private Collection<Wishlist> wishlistCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productID")
    private Collection<Ratings> ratingsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productID")
    private Collection<OrdersDetails> ordersDetailsCollection;

    public Products() {
    }

    public Products(String productID) {
        this.productID = productID;
    }

    public Products(String productID, String productName, int price, int discountProduct) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.discountProduct = discountProduct;
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

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public Boolean getIsStatus() {
        return isStatus;
    }

    public void setIsStatus(Boolean isStatus) {
        this.isStatus = isStatus;
    }

    public Categories getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Categories categoryID) {
        this.categoryID = categoryID;
    }

    public Brands getBrandID() {
        return brandID;
    }

    public void setBrandID(Brands brandID) {
        this.brandID = brandID;
    }

    @XmlTransient
    public Collection<Wishlist> getWishlistCollection() {
        return wishlistCollection;
    }

    public void setWishlistCollection(Collection<Wishlist> wishlistCollection) {
        this.wishlistCollection = wishlistCollection;
    }

    @XmlTransient
    public Collection<Ratings> getRatingsCollection() {
        return ratingsCollection;
    }

    public void setRatingsCollection(Collection<Ratings> ratingsCollection) {
        this.ratingsCollection = ratingsCollection;
    }

    @XmlTransient
    public Collection<OrdersDetails> getOrdersDetailsCollection() {
        return ordersDetailsCollection;
    }

    public void setOrdersDetailsCollection(Collection<OrdersDetails> ordersDetailsCollection) {
        this.ordersDetailsCollection = ordersDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productID != null ? productID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.productID == null && other.productID != null) || (this.productID != null && !this.productID.equals(other.productID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Products[ productID=" + productID + " ]";
    }

    @XmlTransient
    public Collection<ProductsDetails> getProductsDetailsCollection() {
        return productsDetailsCollection;
    }

    public void setProductsDetailsCollection(Collection<ProductsDetails> productsDetailsCollection) {
        this.productsDetailsCollection = productsDetailsCollection;
    }
    
}
