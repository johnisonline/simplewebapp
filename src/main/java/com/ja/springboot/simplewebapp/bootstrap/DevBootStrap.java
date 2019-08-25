package com.ja.springboot.simplewebapp.bootstrap;

import com.ja.springboot.simplewebapp.model.Author;
import com.ja.springboot.simplewebapp.model.Book;
import com.ja.springboot.simplewebapp.model.Publisher;
import com.ja.springboot.simplewebapp.repositories.AuthorRepository;
import com.ja.springboot.simplewebapp.repositories.BookRepository;
import com.ja.springboot.simplewebapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent>{

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;


    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    private void initData(){
        Publisher Harper = new Publisher( "17950 cobblestone wy eden prairie mn", "Harper Collins");

        Author author = new Author("Eric", "Evans");
        Book book = new Book("DDD", "1234", Harper);

       // book.setPublisher(Harper);
        author.getBooks().add(book);
        book.getAuthors().add(author);

        publisherRepository.save(Harper);
        authorRepository.save(author);
        bookRepository.save(book);

        Publisher bookStore = new Publisher("BookStore", "Edina MN");
        Author rob = new Author("Rob", "williamson");
        Book j2ee = new Book("J2EE", "5678", bookStore);


        j2ee.setPublisher(bookStore);
        rob.getBooks().add(j2ee);
        j2ee.getAuthors().add(rob);

        publisherRepository.save(bookStore);
        authorRepository.save(rob);
        bookRepository.save(j2ee);


    }
}
