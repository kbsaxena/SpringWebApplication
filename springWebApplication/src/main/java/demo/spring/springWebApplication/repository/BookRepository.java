package demo.spring.springWebApplication.repository;

import org.springframework.data.repository.CrudRepository;

import demo.spring.springWebApplication.model.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
