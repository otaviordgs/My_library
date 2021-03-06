package com.api.my_library.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 100)
    private String autor;

    @Column(nullable = false)
    private Integer paginas;

    @Column(length = 300)
    private String comentario;

    @Column(precision = 3, scale = 1)
    private Double nota;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(id, livro.id) && Objects.equals(nome, livro.nome) && Objects.equals(autor, livro.autor) && Objects.equals(paginas, livro.paginas) && Objects.equals(comentario, livro.comentario) && Objects.equals(nota, livro.nota);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, autor, paginas, comentario, nota);
    }
}
