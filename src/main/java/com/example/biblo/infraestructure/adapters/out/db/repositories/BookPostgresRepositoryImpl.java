package com.example.biblo.infraestructure.adapters.out.db.repositories;

import com.example.biblo.application.ports.BookRepository;
import com.example.biblo.domain.pojos.Book;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class BookPostgresRepositoryImpl implements BookRepository {

    private static Map<String, Book> books = Map.of(
            "Si", Book.builder()
                    .id(1L)
                    .titulo("Si")
                    .build()
    );

    @Override
    public List<Book> getBooksByName(String name) {
        return Collections.singletonList(books.get(name));
    }
}
