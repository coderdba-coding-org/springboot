package jpa;

import jpa.OrderEntity;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, String>{

    public OrderEntity findByOrderNumber(String orderNumber);
    
    public long findOrderCount(String orderType);
    
    @Query(value = " select * from OMS_ORDER where UPPER(ORDER_TYPE) = UPPER( ?1 )", nativeQuery = true)
    public List<OrderEntity> findOrdersByOrderType(String orderType, Pageable pageable);
    
    @Query(value = " select * from OMS_ORDER where UPPER(ORDER_TYPE) IN UPPER( :orderTypes )", nativeQuery = true)
    public List<OrderEntity> findOrdersByOrderTypes(@Param("orderTypes") List<String> orderTypes);

}
