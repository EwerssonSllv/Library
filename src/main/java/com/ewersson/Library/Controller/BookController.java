package com.ewersson.Library.Controller;


import com.ewersson.Library.Model.Book.Books;
import com.ewersson.Library.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    private BookService bookService;

    // Create new book
    @PostMapping
    public Books create(@RequestBody Books book){
        return bookService.save(book);
    }

    // Get Book
    @GetMapping("/{id}")
    public ResponseEntity<Books> getBook(@PathVariable Integer id){
        return bookService.getBook(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<Books>> getAllBooks() {
        List<Books> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    // Update information about the book
    @PutMapping("/{id}")
    public ResponseEntity<Books> updateBook(@PathVariable Integer id, @RequestBody Books updatedBook){
        Books book = bookService.updateBook(id, updatedBook);
        return ResponseEntity.ok(book);
    }

    // Delete book
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }


}
