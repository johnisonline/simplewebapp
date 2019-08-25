package com.ja.springboot.simplewebapp.repositories;

import com.ja.springboot.simplewebapp.model.Book;
import org.springframework.data.repository.CrudRepository;


public interface BookRepository extends CrudRepository<Book, Long>{
}
