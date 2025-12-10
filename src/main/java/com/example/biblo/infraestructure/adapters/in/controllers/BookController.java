package com.example.biblo.infraestructure.adapters.in.controllers;

import com.example.biblo.application.services.BookService;
import com.example.biblo.domain.pojos.Book;
import com.example.biblo.infraestructure.adapters.in.controllers.dto.BookDto;
import com.example.biblo.infraestructure.adapters.in.controllers.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/{name}")
    public ResponseEntity<List<BookDto>> getBooksByName(
            @PathVariable String name
    ){
        List<Book> books = bookService.getBooksByName(name);
        List<BookDto> booksDto = BookMapper.toBooksDto(books);
        return ResponseEntity.ok(booksDto);

    }

}
