/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "AverageRatings", catalog = "dntShop", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AverageRatings.findAll", query = "SELECT a FROM AverageRatings a"),
    @NamedQuery(name = "AverageRatings.findById", query = "SELECT a FROM AverageRatings a WHERE a.id = :id"),
    @NamedQuery(name = "AverageRatings.findByProductID", query = "SELECT a FROM AverageRatings a WHERE a.productID = :productID"),
    @NamedQuery(name = "AverageRatings.findByProductName", query = "SELECT a FROM AverageRatings a WHERE a.productName = :productName"),
    @NamedQuery(name = "AverageRatings.findByAverageRating", query = "SELECT a FROM AverageRatings a WHERE a.averageRating = :averageRating")})
public class AverageRatings implements Serializable {
    @Column(name = "star")
    private Integer star;
    private static final long serialVersionUID = 1L;
    @Column(name = "id")
    @Id
    private BigInteger id;
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "averageRating", precision = 38, scale = 6)
    private BigDecimal averageRating;

    public AverageRatings() {
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
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

    public BigDecimal getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(BigDecimal averageRating) {
        this.averageRating = averageRating;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }
    
}
