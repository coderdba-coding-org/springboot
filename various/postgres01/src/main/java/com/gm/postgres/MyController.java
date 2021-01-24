package com.gm.postgres;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Reference: https://zetcode.com/springboot/postgresql/

import com.gm.postgres.models.Book;
import com.gm.postgres.services.BookService;
import com.gm.postgres.repositories.BookRepository;

@RestController
public class MyController {

	@Autowired
	private BookService bookService;
	
    @GetMapping("/")
    public String showHome() {
    	    	
    	return ("Try the following endpoints:" + System.lineSeparator() +  "/showBooks");

    }
    
    @GetMapping("/showBooks")
    public List showBooks() {

    	// If using html output with model and such. Refer to zetcode tutorial
        //var books = (List<Book>) bookService.list();
        //model.addAttribute("cities", cities);
        //return "showCities";
    	
    	return bookService.list();
    }
	
}
