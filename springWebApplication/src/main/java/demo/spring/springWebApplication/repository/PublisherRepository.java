package demo.spring.springWebApplication.repository;

import org.springframework.data.repository.CrudRepository;

import demo.spring.springWebApplication.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long>{

}
