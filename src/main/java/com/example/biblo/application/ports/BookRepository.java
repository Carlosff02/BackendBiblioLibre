package com.example.biblo.application.ports;

import com.example.biblo.domain.pojos.Book;

import java.util.List;

public interface BookRepository {
    List<Book> getBooksByName(String name);
}
