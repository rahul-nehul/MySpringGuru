package com.rnehul.spring5artifact.bootstrap;

import com.rnehul.spring5artifact.model.Author;
import com.rnehul.spring5artifact.model.Book;
import com.rnehul.spring5artifact.repositories.AuthorRepository;
import com.rnehul.spring5artifact.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootrap implements ApplicationListener<ContextRefreshedEvent>{

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadData();
    }
    private void loadData(){

        Author eric = new Author("eric","Evans");
        Book ddd = new Book("Domain Driven Design","12345","Top Publishers");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("rod","johnson");
        Book noEjb = new Book("J2EE Development without EJB","2345","Wrox");
        rod.getBooks().add(noEjb);
        authorRepository.save(rod);
        bookRepository.save(noEjb);
    }
}
