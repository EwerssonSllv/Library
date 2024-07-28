package com.ewersson.Library.Model.Book;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = Books.TABLE_NAME)
public class Books {

    public static final String TABLE_NAME = "books";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id", unique = true)
    private Integer id;

    @Column(name = "title", nullable = false, unique = true)
    @NotBlank
    private String title;

    @Column(name = "author", nullable = false)
    @NotBlank
    private String author;

    @Column(name = "releaseYear", nullable = false)
    @NotBlank
    private String releaseYear;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank String getTitle() {
        return title;
    }

    public void setTitle(@NotBlank String title) {
        this.title = title;
    }

    public @NotBlank String getAuthor() {
        return author;
    }

    public void setAuthor(@NotBlank String author) {
        this.author = author;
    }

    public @NotBlank String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(@NotBlank String releaseYear) {
        this.releaseYear = releaseYear;
    }
}
