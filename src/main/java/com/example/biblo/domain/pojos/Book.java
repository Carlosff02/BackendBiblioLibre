package com.example.biblo.domain.pojos;

import com.example.biblo.domain.models.Autor;
import com.example.biblo.domain.models.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Long id;
    private String titulo;
    private Autor autor;
    private String descripcion;
    private String idioma;
    private Integer descargas;
    private String imgSrc;
    private String textHtml;
    private String epub;
    private Long idgutendex;
    private List<String> categorias;
    private String epubLocalPath;
    private Usuario usuario;

}
