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


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class OrderController {
	
	@Autowired
	OrderRepository orderRepository;

	@GetMapping("/tutorials")
	public ResponseEntity<List<OrderEntity>> getAllOrders(@RequestParam(required = false) String title) {
		try {
			
			List<OrderEntity> orders = new ArrayList<OrderEntity>();		
			if (orders.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(orders, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
