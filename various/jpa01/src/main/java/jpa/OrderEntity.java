package jpa;

import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;


import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.Version;

import java.io.Serializable;

//import java.math.BigDecimal;
//import java.sql.Timestamp;

//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;

/**
 * The persistence class for the ORDER database table.
 */

@Entity(name = "ORDERS")
//@Table(name = "ORDERS")
public class OrderEntity implements Serializable {
	
	// this Version-UID is necessary for Serializable
    //private static final long serialVersionUID = 1L;
    public static final long serialVersionUID = 1L;
	
    // Class variables for entity properties
    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ORDER_KEY", nullable = false)
    private String orderKey;
    
    @Column(name = "ORDER_NUMBER", nullable = false)
    private String orderNumber;
    
    @Column(name = "ORDER_TYPE", nullable = false)
    private String orderType;
    
    @Column(name = "TOTAL_PRICE", nullable = false)
    private double totalPrice;  
    
    
    // Getters and Setters
    public String getOrderKey() {
    	return orderKey;
    }
    public void setOrderKey(String orderKey) {
    	this.orderKey = orderKey;
    }
    
    public String getOrderNumber() {
    	return orderNumber;
    }
    public void setOrderNumber(String orderNumber) {
    	this.orderNumber = orderNumber;
    }
    
    public String getOrderType() {
    	return orderType;
    }
    public void setOrderType(String orderType) {
    	this.orderType = orderType;
    }
    
    public double getTotalPrice() {
    	return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
    	this.totalPrice = totalPrice;
    }
    
    // Constructors
    public OrderEntity() {
    }
    
    public OrderEntity(String orderKey, String orderNumber, String orderType, double totalPrice) {
    	this.orderKey = orderKey;
    	this.orderNumber = orderNumber;
    	this.orderType = orderType;
    	this.totalPrice = totalPrice;
    }
    
}
