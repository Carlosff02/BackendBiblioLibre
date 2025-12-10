package com.example.biblo.infraestructure.adapters.in.controllers.mapper;

import com.example.biblo.domain.pojos.Book;
import com.example.biblo.infraestructure.adapters.in.controllers.dto.BookDto;

import java.util.ArrayList;
import java.util.List;

public class BookMapper {

    public static List<BookDto> toBooksDto(List<Book> books){
        List<BookDto> booksDto = new ArrayList<>();
        for(Book book : books){
            booksDto.add(BookDto.builder()
                    .title(book.getTitulo())
                    .id(book.getId())
                    .build());
        }
                return booksDto;
    }

}
