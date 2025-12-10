package com.example.biblo.infraestructure.adapters.in.controllers.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookDto{
    private Long id;
    private String title;
}
