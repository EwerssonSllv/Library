package com.ewersson.Library.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = Books.TABLE_NAME)
public class Books {

    public static final String TABLE_NAME = "books";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id", unique = true)
    private Integer id;

    @Column(name = "image")
    private String image;

    @Column(name = "title", nullable = false, unique = true)
    @NotBlank
    private String title;

    @Column(name = "author", nullable = false)
    @NotBlank
    private String author;

    @Column(name = "releaseYear", nullable = false)
    @NotBlank
    private String releaseYear;

    @Lob
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "gender", nullable = false)
    private String gender;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
