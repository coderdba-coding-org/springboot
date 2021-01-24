package com.gm.postgres.services;

import com.gm.postgres.models.Book;
import com.gm.postgres.repositories.BookRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// usually a service is defined as an interface and then a class extends that
// for such example see https://zetcode.com/springboot/postgresql/

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> list() {
        return bookRepository.findAll();
    }
}