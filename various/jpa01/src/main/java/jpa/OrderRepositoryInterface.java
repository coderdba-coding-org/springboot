package jpa;

public interface OrderRepositoryInterface {
	
    public void save(Order order);

    public void saveAndFlush(Order order);
    
    // OmsOrderEntity getOrderKeyByOrderNumber(String orderNo);

}
