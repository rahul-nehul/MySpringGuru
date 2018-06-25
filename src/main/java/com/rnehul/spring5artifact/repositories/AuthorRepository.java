package com.rnehul.spring5artifact.repositories;

import com.rnehul.spring5artifact.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {

}
