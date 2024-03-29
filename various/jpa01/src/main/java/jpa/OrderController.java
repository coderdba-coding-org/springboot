package jpa;

import jpa.OrderRepository;
import jpa.OrderEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.google.common.base.Stopwatch;
import java.util.concurrent.TimeUnit;

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
	public ResponseEntity<List<OrderEntity>> getOrders(@RequestParam(required = false) String orderKey) {
				
		try {
			
			List<OrderEntity> orders = new ArrayList<OrderEntity>();	
			
			//final Stopwatch stopwatch = Stopwatch.createUnstarted().start();
			//Thread.sleep(500);
			//System.out.println(String.format("Stopwatch Ran for: %s ms", stopwatch.stop().elapsed(TimeUnit.MILLISECONDS)));

			if (orderKey == null)
				orderRepository.findAll().forEach(orders::add);
			else
				//orderRepository.findByTitleContaining(title).forEach(tutorials::add);
				orderRepository.findAll().forEach(orders::add); // for now do a findAll itself
	
			//System.out.println(String.format("Stopwatch Ran for: %s ms", stopwatch.stop().elapsed(TimeUnit.MILLISECONDS)));

			if (orders.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(orders, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/orders")
	public ResponseEntity<String> deleteOrders(@RequestParam(required = false) String orderKey) {
				
		try {
			
			//List<OrderEntity> orders = new ArrayList<OrderEntity>();	
			
			//final Stopwatch stopwatch = Stopwatch.createUnstarted().start();
			//Thread.sleep(500);
			//System.out.println(String.format("Stopwatch Ran for: %s ms", stopwatch.stop().elapsed(TimeUnit.MILLISECONDS)));

			if (orderKey == null)
				orderRepository.deleteAllInBatch();
			else
				//orderRepository.findByTitleContaining(title).forEach(tutorials::add);
				orderRepository.deleteAllInBatch(); // for now do a deleteAll itself
	
			//System.out.println(String.format("Stopwatch Ran for: %s ms", stopwatch.stop().elapsed(TimeUnit.MILLISECONDS)));

			return new ResponseEntity<>("Order(s) deleted", HttpStatus.OK);

			
		} catch (Exception e) {
			return new ResponseEntity<>("Order(s) could not be deleted", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
    @GetMapping("/orderslist")
    public List <OrderEntity> getAllOrdersList() {
        return orderRepository.findAll();
    }
    
    
	@PostMapping("/orders")
	public ResponseEntity<String> createOrder(@RequestBody OrderEntity orderEntity) {
		try {
			final Stopwatch stopwatch = Stopwatch.createUnstarted().start();
			
			orderRepository.save(new OrderEntity(orderEntity.getOrderKey(), orderEntity.getOrderNumber(), orderEntity.getOrderType(), orderEntity.getTotalPrice()));
			
			//System.out.println(String.format("Stopwatch Ran for: %s ms", stopwatch.stop().elapsed(TimeUnit.MILLISECONDS)));
			System.out.println(String.format("Stopwatch Ran for: %s nanoseconds", stopwatch.stop().elapsed(TimeUnit.NANOSECONDS)));

			return new ResponseEntity<>("Order Created", HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>("Order Creation Failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/orderspopulate")
	public ResponseEntity<String> populateOrders() {
		
		boolean orderError = false;
		final Stopwatch stopwatch = Stopwatch.createUnstarted().start();
		
		for (int i=0; i<100; i++) {
			   OrderEntity o = new OrderEntity();
			   o.setOrderKey(i + "Key");
			   o.setOrderNumber(i + "Number");
			   o.setOrderType("Sale");
			   o.setTotalPrice(i * 10);
			   
			   try {
				   orderRepository.save(o);
			   } catch (Exception e) {
				   orderError = true;
			   }
			}

		System.out.println(String.format("populateOrders(): Stopwatch Ran for: %s nanoseconds", stopwatch.stop().elapsed(TimeUnit.NANOSECONDS)));

		if (orderError == true) {
			return new ResponseEntity<>("Error in order creation of one or more orders", HttpStatus.CREATED);
		}
		

		return new ResponseEntity<>("Orders Created", HttpStatus.CREATED);
	}
	
	@PostMapping("/ordersrepopulate")
	public ResponseEntity<String> rePopulateOrders() {
		
		boolean orderCreateError = false;
		boolean orderDeleteError = false;
		
		// first delete all
		try {
			orderRepository.deleteAllInBatch();

		} catch (Exception e) {
			orderDeleteError = true;

		}
		
		// then populate
		final Stopwatch stopwatch = Stopwatch.createUnstarted().start();
		
		for (int i=0; i<100; i++) {
			   OrderEntity o = new OrderEntity();
			   o.setOrderKey(i + "Key");
			   o.setOrderNumber(i + "Number");
			   o.setOrderType("Sale");
			   o.setTotalPrice(i * 10);
			   
			   try {
				   orderRepository.save(o);
			   } catch (Exception e) {
				   orderCreateError = true;
			   }
		}

		System.out.println(String.format("populateOrders(): Stopwatch Ran for: %s nanoseconds", stopwatch.stop().elapsed(TimeUnit.NANOSECONDS)));

		if (orderDeleteError == true) {
			return new ResponseEntity<>("Error in deleting orders", HttpStatus.CREATED);
		}
			
		if (orderCreateError == true) {
			return new ResponseEntity<>("Error in creating one or more orders", HttpStatus.CREATED);
		}

		return new ResponseEntity<>("Orders Created", HttpStatus.CREATED);
	}
	
	
	@GetMapping("/stopwatch")
	public String stopwatchRun() {
		final Stopwatch stopwatch = Stopwatch.createUnstarted().start();
        //log.info("STOPWATCH", "TEST RUN",  String.format("Stopwatch Ran for: %s ms", stopwatch.stop().elapsed(TimeUnit.MILLISECONDS)));
		//return String.format("Stopwatch Ran for: %s ms", stopwatch.stop().elapsed(TimeUnit.MILLISECONDS));
		//return String.format("Stopwatch Ran for: %s microseconds", stopwatch.stop().elapsed(TimeUnit.MICROSECONDS));
		return String.format("Stopwatch Ran for: %s ns", stopwatch.stop().elapsed(TimeUnit.NANOSECONDS));
	}

}
