package jpa;

import lombok.Getter;
import lombok.Setter;

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
@Entity(name = "ORDER")
//@Table(name = "ORDER")
public class OrderEntity implements Serializable {
	
	// this Version-UID is necessary for Serializable
    private static final long serialVersionUID = 1L;
	
    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ORDER_KEY", nullable = false)
    private String orderKey;
    
    @Column(name = "ORDER_NUMBER", nullable = false)
    private String orderNumber;
    
    @Column(name = "ORDER_TYPE", nullable = false)
    private String orderType;
    
    @Column(name = "TOTAL_PRICE", nullable = false)
    private String totalPrice;   
    
 
    public OrderEntity() {
    }
}
