package com.ja.springboot.simplewebapp.repositories;

import com.ja.springboot.simplewebapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;


public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
