package jpa;

import lombok.Getter;
import lombok.Setter;

public class Order {
	
    @Getter
    @Setter
	private String orderKey;
    
    @Getter
    @Setter
	private String orderNumber;
    
    @Getter
    @Setter
	private String orderType;
    
    @Getter
    @Setter
	private double totalPrice;

}
