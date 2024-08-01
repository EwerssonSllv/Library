package com.ewersson.Library.Model.Book;

public record BookResponseDTO(Integer id, String title, String author, String image,
                              String description, String gender, String releaseYear) {
    public BookResponseDTO(Books book){
        this(book.getId(), book.getTitle(), book.getImage(), book.getAuthor(),
                book.getGender(), book.getReleaseYear(), book.getDescription());
    }
}
