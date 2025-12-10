package com.example.biblo.application.usecases.libros;

import com.example.biblo.domain.pojos.Book;

import java.util.List;

public interface GetBook {
    List<Book> getBooksByName(String name);
}
