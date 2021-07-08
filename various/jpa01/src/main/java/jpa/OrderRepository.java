package jpa;

import jpa.OrderJPARepository;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class OrderRepository implements OrderRepositoryInterface {
	
    @Autowired
    OrderJPARepository orderJPARepository;
	
    @Override
    public void save(Order order) {
        OmsOrderEntity orderEntity = mapper.mapOrder(order);
        orderRepository.save(orderEntity);
    }
    
    @Override
    public void saveAndFlush(Order order) {
        OmsOrderEntity orderEntity = mapper.mapOrder(order);
        orderRepository.saveAndFlush(orderEntity);
    }
    
}