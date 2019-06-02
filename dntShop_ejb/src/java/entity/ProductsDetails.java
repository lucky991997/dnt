/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ProductsDetails", catalog = "dntShop", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductsDetails.findAll", query = "SELECT p FROM ProductsDetails p"),
    @NamedQuery(name = "ProductsDetails.findByProductDetailsID", query = "SELECT p FROM ProductsDetails p WHERE p.productDetailsID = :productDetailsID"),
    @NamedQuery(name = "ProductsDetails.findByCpu", query = "SELECT p FROM ProductsDetails p WHERE p.cpu = :cpu"),
    @NamedQuery(name = "ProductsDetails.findByMemory", query = "SELECT p FROM ProductsDetails p WHERE p.memory = :memory"),
    @NamedQuery(name = "ProductsDetails.findByVga", query = "SELECT p FROM ProductsDetails p WHERE p.vga = :vga"),
    @NamedQuery(name = "ProductsDetails.findByHdd", query = "SELECT p FROM ProductsDetails p WHERE p.hdd = :hdd"),
    @NamedQuery(name = "ProductsDetails.findByCamera", query = "SELECT p FROM ProductsDetails p WHERE p.camera = :camera"),
    @NamedQuery(name = "ProductsDetails.findByDisplay", query = "SELECT p FROM ProductsDetails p WHERE p.display = :display"),
    @NamedQuery(name = "ProductsDetails.findByBattery", query = "SELECT p FROM ProductsDetails p WHERE p.battery = :battery"),
    @NamedQuery(name = "ProductsDetails.findByWeights", query = "SELECT p FROM ProductsDetails p WHERE p.weights = :weights")})
public class ProductsDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductDetailsID", nullable = false)
    private Integer productDetailsID;
    @Size(max = 200)
    @Column(name = "CPU", length = 200)
    private String cpu;
    @Size(max = 200)
    @Column(name = "Memory", length = 200)
    private String memory;
    @Size(max = 200)
    @Column(name = "VGA", length = 200)
    private String vga;
    @Size(max = 200)
    @Column(name = "HDD", length = 200)
    private String hdd;
    @Size(max = 200)
    @Column(name = "Camera", length = 200)
    private String camera;
    @Size(max = 300)
    @Column(name = "Display", length = 300)
    private String display;
    @Size(max = 100)
    @Column(name = "Battery", length = 100)
    private String battery;
    @Size(max = 20)
    @Column(name = "Weights", length = 20)
    private String weights;
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID", nullable = false)
    @ManyToOne(optional = false)
    private Products productID;

    public ProductsDetails() {
    }

    public ProductsDetails(Integer productDetailsID) {
        this.productDetailsID = productDetailsID;
    }

    public Integer getProductDetailsID() {
        return productDetailsID;
    }

    public void setProductDetailsID(Integer productDetailsID) {
        this.productDetailsID = productDetailsID;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getVga() {
        return vga;
    }

    public void setVga(String vga) {
        this.vga = vga;
    }

    public String getHdd() {
        return hdd;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getWeights() {
        return weights;
    }

    public void setWeights(String weights) {
        this.weights = weights;
    }

    public Products getProductID() {
        return productID;
    }

    public void setProductID(Products productID) {
        this.productID = productID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productDetailsID != null ? productDetailsID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductsDetails)) {
            return false;
        }
        ProductsDetails other = (ProductsDetails) object;
        if ((this.productDetailsID == null && other.productDetailsID != null) || (this.productDetailsID != null && !this.productDetailsID.equals(other.productDetailsID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ProductsDetails[ productDetailsID=" + productDetailsID + " ]";
    }
    
}
