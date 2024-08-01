package com.ewersson.Library.Repository;

import com.ewersson.Library.Model.Book.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Books, Integer> {
}
