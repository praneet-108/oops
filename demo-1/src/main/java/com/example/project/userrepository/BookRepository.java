package com.example.project.userrepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.project.userdomain.Book;
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

}