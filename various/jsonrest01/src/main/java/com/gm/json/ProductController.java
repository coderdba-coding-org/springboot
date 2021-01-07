package com.gm.json;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController	
@RequestMapping("/products")
public class ProductController {
	
	@GetMapping("/example")
	public Product getExampleProduct() {
		
		return new Product(0, "Example Product", 100.1);
	}
	
	// Create new product
	// Input JSON - marshalled by @RequetBody annotation
	// Output JSON - @ResponseBody annotation tells a controller that the object returned is automatically serialized into JSON and passed back into the HttpResponse object
	@PostMapping("/create")
	@ResponseBody  
	public Product createProduct(@RequestBody Product product) {

		// For simplicty, return the input product itself
		// (Ideally, this product should be placed in a database or other data store
		return product;
	}
	
	// Create new product - with a discount 
	@PostMapping("/creatediscounted")
	@ResponseBody  
	public Product createProductWithDiscount(@RequestBody Product product) {

		// For simplicty, return the input product itself - after applying discount
		// (Ideally, this product should be placed in a database or other data store
		
		product.setPrice(product.getPrice() * 0.5);
		return product;
	}

}
