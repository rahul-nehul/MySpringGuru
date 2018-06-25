package com.rnehul.spring5artifact.repositories;

import com.rnehul.spring5artifact.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
