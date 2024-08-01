package com.ewersson.Library.Model.Book;

import jakarta.validation.constraints.NotBlank;

public record BookRequestDTO(

        @NotBlank
        String title,

        @NotBlank
        String author,

        @NotBlank
        String image,

        @NotBlank
        String gender,

        @NotBlank
        String releaseYear,

        @NotBlank
        String description

) {
}
