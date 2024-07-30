package com.ewersson.Library.Repository;

import com.ewersson.Library.Model.Books;
import com.ewersson.Library.Model.Projection.BookProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Books, Integer> {
    List<BookProjection> findByUser_Id(Long id);
}
