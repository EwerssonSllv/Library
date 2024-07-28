package com.ewersson.Library.Service;


import com.ewersson.Library.Model.Book.Books;
import com.ewersson.Library.Repository.BookRepository;
import com.ewersson.Library.Service.Exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Books save(Books book){
        return bookRepository.save(book);
    }

    public Optional<Books> getBook(Integer id){
        return bookRepository.findById(id);
    }

    public void deleteBook(Integer id){
        bookRepository.deleteById(id);
    }

    public Books updateBook(Integer id, Books updateBook){
        Books book = bookRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Book Not Found!"));
        book.setTitle(updateBook.getTitle());
        book.setAuthor(updateBook.getAuthor());
        book.setReleaseYear(updateBook.getReleaseYear());
    return bookRepository.save(book);
    }

}
