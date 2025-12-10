package com.example.biblo.application.services;

import com.example.biblo.application.ports.BookRepository;
import com.example.biblo.application.usecases.libros.GetBook;
import com.example.biblo.domain.pojos.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService implements GetBook {

    private final BookRepository repository;

    @Override
    public List<Book> getBooksByName(String name) {
        return repository.getBooksByName(name);
    }
}
