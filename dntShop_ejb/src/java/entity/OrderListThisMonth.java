/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "OrderListThisMonth", catalog = "dntShop", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderListThisMonth.findAll", query = "SELECT o FROM OrderListThisMonth o"),
    @NamedQuery(name = "OrderListThisMonth.findByOrderID", query = "SELECT o FROM OrderListThisMonth o WHERE o.orderID = :orderID"),
    @NamedQuery(name = "OrderListThisMonth.findByTotal", query = "SELECT o FROM OrderListThisMonth o WHERE o.total = :total"),
    @NamedQuery(name = "OrderListThisMonth.findByShipName", query = "SELECT o FROM OrderListThisMonth o WHERE o.shipName = :shipName"),
    @NamedQuery(name = "OrderListThisMonth.findByShipPhone", query = "SELECT o FROM OrderListThisMonth o WHERE o.shipPhone = :shipPhone"),
    @NamedQuery(name = "OrderListThisMonth.findByShipAddress", query = "SELECT o FROM OrderListThisMonth o WHERE o.shipAddress = :shipAddress"),
    @NamedQuery(name = "OrderListThisMonth.findByShipDate", query = "SELECT o FROM OrderListThisMonth o WHERE o.shipDate = :shipDate"),
    @NamedQuery(name = "OrderListThisMonth.findByShipNote", query = "SELECT o FROM OrderListThisMonth o WHERE o.shipNote = :shipNote"),
    @NamedQuery(name = "OrderListThisMonth.findByOrderDate", query = "SELECT o FROM OrderListThisMonth o WHERE o.orderDate = :orderDate"),
    @NamedQuery(name = "OrderListThisMonth.findByPaymentMethod", query = "SELECT o FROM OrderListThisMonth o WHERE o.paymentMethod = :paymentMethod"),
    @NamedQuery(name = "OrderListThisMonth.findByProcessStatus", query = "SELECT o FROM OrderListThisMonth o WHERE o.processStatus = :processStatus"),
    @NamedQuery(name = "OrderListThisMonth.findByIsStatus", query = "SELECT o FROM OrderListThisMonth o WHERE o.isStatus = :isStatus")})
public class OrderListThisMonth implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "OrderID", nullable = false, length = 10)
    private String orderID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Total", nullable = false)
    private int total;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ShipName", nullable = false, length = 100)
    private String shipName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ShipPhone", nullable = false, length = 20)
    private String shipPhone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ShipAddress", nullable = false, length = 200)
    private String shipAddress;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ShipDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date shipDate;
    @Size(max = 2147483647)
    @Column(name = "ShipNote", length = 2147483647)
    private String shipNote;
    @Column(name = "OrderDate")
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PaymentMethod", nullable = false, length = 100)
    private String paymentMethod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ProcessStatus", nullable = false, length = 50)
    private String processStatus;
    @Column(name = "IsStatus")
    private Boolean isStatus;
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID", nullable = false)
    @ManyToOne(optional = false)
    private Customers customerID;

    public OrderListThisMonth() {
    }

    public OrderListThisMonth(String orderID) {
        this.orderID = orderID;
    }

    public OrderListThisMonth(String orderID, int total, String shipName, String shipPhone, String shipAddress, Date shipDate, String paymentMethod, String processStatus) {
        this.orderID = orderID;
        this.total = total;
        this.shipName = shipName;
        this.shipPhone = shipPhone;
        this.shipAddress = shipAddress;
        this.shipDate = shipDate;
        this.paymentMethod = paymentMethod;
        this.processStatus = processStatus;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipPhone() {
        return shipPhone;
    }

    public void setShipPhone(String shipPhone) {
        this.shipPhone = shipPhone;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public String getShipNote() {
        return shipNote;
    }

    public void setShipNote(String shipNote) {
        this.shipNote = shipNote;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }

    public Boolean getIsStatus() {
        return isStatus;
    }

    public void setIsStatus(Boolean isStatus) {
        this.isStatus = isStatus;
    }

    public Customers getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customers customerID) {
        this.customerID = customerID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderID != null ? orderID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderListThisMonth)) {
            return false;
        }
        OrderListThisMonth other = (OrderListThisMonth) object;
        if ((this.orderID == null && other.orderID != null) || (this.orderID != null && !this.orderID.equals(other.orderID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OrderListThisMonth[ orderID=" + orderID + " ]";
    }
    
}
