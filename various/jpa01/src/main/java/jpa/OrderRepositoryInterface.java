package jpa;

import java.util.List;

import jpa.OrderEntity;

public interface OrderRepositoryInterface {
	
    //public void save(Order order);

    //public void saveAndFlush(Order order);
    
    // OmsOrderEntity getOrderKeyByOrderNumber(String orderNo);
	
	
    public void save(OrderEntity orderEntity);

    public void saveAndFlush(OrderEntity orderEntity);
    
    public List<OrderEntity> findAll();

}
