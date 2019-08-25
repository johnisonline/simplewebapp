package com.ja.springboot.simplewebapp.repositories;

import com.ja.springboot.simplewebapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
