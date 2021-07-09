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

@Getter
@Setter
@Entity(name = "ORDERS-X")
//@Table(name = "ORDERS-X")
public class OrderEntityV0GetterSetterConfusing implements Serializable {
	
	// this Version-UID is necessary for Serializable
    //private static final long serialVersionUID = 1L;
    public static final long serialVersionUID = 1L;
	
    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ORDER_KEY", nullable = false)
    //@Getter(AccessLevel.PUBLIC)
    //@Setter(AccessLevel.PUBLIC)
    private String orderKey;
    //public String orderKey;
    public String getOrderKey() {
    	return orderKey;
    }
    public void setOrderKey(String orderKey) {
    	this.orderKey = orderKey;
    }
    
    @Column(name = "ORDER_NUMBER", nullable = false)
    //private String orderNumber;
    public String orderNumber;
    
    @Column(name = "ORDER_TYPE", nullable = false)
    //private String orderType;
    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PUBLIC)
    public String orderType;
    
    @Column(name = "TOTAL_PRICE", nullable = false)
    //private double totalPrice;  
    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PUBLIC)
    public double totalPrice;
    
    
    public OrderEntityV0GetterSetterConfusing() {
    }
}
