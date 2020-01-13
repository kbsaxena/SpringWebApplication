package demo.spring.springWebApplication.repository;

import org.springframework.data.repository.CrudRepository;

import demo.spring.springWebApplication.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
