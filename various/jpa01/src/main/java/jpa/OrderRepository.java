package jpa;

import jpa.OrderEntity;
import jpa.OrderJPARepository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class OrderRepository implements OrderRepositoryInterface {
	
    @Autowired
    OrderJPARepository orderJPARepository;

    
    @Override
    public void save(OrderEntity orderEntity) {
        orderJPARepository.save(orderEntity);
    }
    
    @Override
    public void saveAndFlush(OrderEntity orderEntity) {
        orderJPARepository.saveAndFlush(orderEntity);
    }
    
    @Override
    public List<OrderEntity> findAll() {
        return orderJPARepository.findAll();
    }
    
    @Override
    public void deleteAllInBatch() {
        orderJPARepository.deleteAllInBatch();
    }
    
    /*
    @Override
    public void save(Order order) {
        OrderEntity orderEntity = mapper.mapOrder(order);
        orderJPARepository.save(orderEntity);
    }
    
    @Override
    public void saveAndFlush(Order order) {
        OrderEntity orderEntity = mapper.mapOrder(order);
        orderJPARepository.saveAndFlush(orderEntity);
    }
    */
    
}