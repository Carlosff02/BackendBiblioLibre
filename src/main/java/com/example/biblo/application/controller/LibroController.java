package com.example.biblo.application.controller;

import com.example.biblo.domain.models.Libro;
import com.example.biblo.application.services.LibroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/libros")
@RequiredArgsConstructor
@CrossOrigin("*")
public class LibroController {

    private final LibroService libroService;

    @GetMapping("/buscar-por-nombre")
    @Operation(
            summary = "Search books by name",
            description = "this endpoint is used to search for books by name",
            tags = {"search", "public endpoint", "books"})
    public Libro buscarPorNombre(@RequestParam String nombreLibro) throws IOException, InterruptedException {
        return libroService.buscarLibro(nombreLibro);
    }

    @GetMapping("/populares")
    public List<Libro> buscarLibrosPopulares(){
        return libroService.buscarLibrosMasPopulares();
    }


    @GetMapping("/buscar")
    @Operation(
            summary = "Search books",
            description = "this endpoint is used to search for books",
            tags = {"search", "public endpoint", "books"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Search results"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    public Page<Libro> buscarLibros(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String autor,
            @RequestParam(required = false) String idioma,
            @RequestParam(defaultValue = "1") int page) throws IOException, InterruptedException {

        return libroService.buscarLibros(titulo, autor, idioma, page);
    }



}
