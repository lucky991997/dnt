/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Duy
 */
@Entity
@Table(name = "Report", catalog = "dntShop", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Report.findAll", query = "SELECT r FROM Report r"),
    @NamedQuery(name = "Report.findByRowid", query = "SELECT r FROM Report r WHERE r.rowid = :rowid"),
    @NamedQuery(name = "Report.findByOrderID", query = "SELECT r FROM Report r WHERE r.orderID = :orderID"),
    @NamedQuery(name = "Report.findByProductID", query = "SELECT r FROM Report r WHERE r.productID = :productID"),
    @NamedQuery(name = "Report.findByProductName", query = "SELECT r FROM Report r WHERE r.productName = :productName"),
    @NamedQuery(name = "Report.findByOrderDate", query = "SELECT r FROM Report r WHERE r.orderDate = :orderDate"),
    @NamedQuery(name = "Report.findByShipDate", query = "SELECT r FROM Report r WHERE r.shipDate = :shipDate"),
    @NamedQuery(name = "Report.findBySellingPrice", query = "SELECT r FROM Report r WHERE r.sellingPrice = :sellingPrice"),
    @NamedQuery(name = "Report.findByQuantity", query = "SELECT r FROM Report r WHERE r.quantity = :quantity"),
    @NamedQuery(name = "Report.findByCustomerID", query = "SELECT r FROM Report r WHERE r.customerID = :customerID"),
    @NamedQuery(name = "Report.findByFirstName", query = "SELECT r FROM Report r WHERE r.firstName = :firstName"),
    @NamedQuery(name = "Report.findByLastName", query = "SELECT r FROM Report r WHERE r.lastName = :lastName"),
    @NamedQuery(name = "Report.findByShipName", query = "SELECT r FROM Report r WHERE r.shipName = :shipName"),
    @NamedQuery(name = "Report.findByProcessStatus", query = "SELECT r FROM Report r WHERE r.processStatus = :processStatus"),
    @NamedQuery(name = "Report.findByTotal", query = "SELECT r FROM Report r WHERE r.total = :total")})
public class Report implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "rowid")
    @Id
    private BigInteger rowid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "OrderID", nullable = false, length = 10)
    private String orderID;
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
    @Column(name = "OrderDate")
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ShipDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date shipDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SellingPrice", nullable = false)
    private int sellingPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Quantity", nullable = false)
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CustomerID", nullable = false, length = 10)
    private String customerID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FirstName", nullable = false, length = 50)
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LastName", nullable = false, length = 50)
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ShipName", nullable = false, length = 100)
    private String shipName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ProcessStatus", nullable = false, length = 50)
    private String processStatus;
    @Column(name = "Total")
    private Integer total;

    public Report() {
    }

    public BigInteger getRowid() {
        return rowid;
    }

    public void setRowid(BigInteger rowid) {
        this.rowid = rowid;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
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

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
    
}
