package jpa;

import jpa.OrderRepository;
import jpa.OrderEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//@CrossOrigin(origins = "http://localhost:8081")
@RestController
//@RequestMapping("/api")
public class OrderController {
	
	@Autowired
	OrderRepository orderRepository;

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot JPA application!";
	}
	
	@GetMapping("/endpoints")
	public String endpoints() {
		return "Endpoints available:  orders get";
	}
	
	@GetMapping("/orders")
	public ResponseEntity<List<OrderEntity>> getAllOrders(@RequestParam(required = false) String orderKey) {
				
		try {
			
			List<OrderEntity> orders = new ArrayList<OrderEntity>();	
			
			if (orderKey == null)
				orderRepository.findAll().forEach(orders::add);
			else
				//orderRepository.findByTitleContaining(title).forEach(tutorials::add);
				orderRepository.findAll().forEach(orders::add); // for now do a findAll itself
	
			if (orders.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(orders, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
    @GetMapping("/orderslist")
    public List < OrderEntity > getAllOrdersList() {
        return orderRepository.findAll();
    }
    
    /*
	@PostMapping("/orders")
	public ResponseEntity<String> createOrder(@RequestBody OrderEntity orderEntity) {
		try {
			orderRepository.save(new OrderEntity(orderEntity.getOrderKey(), orderEntity.getOrderNumber(), orderEntity.getOrderType(), orderEntity.getTotalPrice()));
			return new ResponseEntity<>("Order Created", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Order Creation Failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	*/

}
