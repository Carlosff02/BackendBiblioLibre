package com.example.biblo.application.controller;


import com.example.biblo.application.services.LibroService;
import com.example.biblo.domain.models.Libro;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ByteArrayResource;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/mis-libros")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UsuarioLibroController {

    private final LibroService libroService;

    @PostMapping("/subir")
    public ResponseEntity<?> subirLibro(
            @RequestParam("file") MultipartFile file,
            @RequestParam("titulo") String titulo,
            Principal principal
    ) throws IOException {

        Libro libro = libroService.guardarLibroSubido(file, titulo, principal.getName());
        return ResponseEntity.ok(libro);
    }

    @GetMapping
    public List<Libro> listarMisLibros(Principal principal) {
        return libroService.listarLibrosDeUsuario(principal.getName());
    }

    @GetMapping("/archivo/{id}")
    public ResponseEntity<Resource> obtenerArchivo(@PathVariable Long id) throws IOException {

        Libro libro = libroService.obtenerLibroPorId(id);

        Path path = Paths.get(libro.getEpubLocalPath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + libro.getTitulo() + ".epub")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}
