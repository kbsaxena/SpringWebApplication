package demo.spring.springWebApplication.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import demo.spring.springWebApplication.model.Author;
import demo.spring.springWebApplication.model.Book;
import demo.spring.springWebApplication.model.Publisher;
import demo.spring.springWebApplication.repository.AuthorRepository;
import demo.spring.springWebApplication.repository.BookRepository;
import demo.spring.springWebApplication.repository.PublisherRepository;

@Component
public class BootStrapingData implements  ApplicationListener<ContextRefreshedEvent>{

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	public BootStrapingData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
	}

	private void initData() {
		Publisher p1 = new Publisher();
		p1.setName("KB Publications");
		p1.setAddress("Kondapur");
		
		publisherRepository.save(p1);
		
		Author a1 = new Author();
		a1.setFirstName("A.P.J");
		a1.setLastName("Abdul Kalam");
		Book b1 = new Book();
		b1.setTitle("Wings of Fire");
		Book b2 = new Book();
		b2.setTitle("Ignited Minds");
		a1.getBooks().add(b1);
		a1.getBooks().add(b2);
		b1.getAuthors().add(a1);
		b2.getAuthors().add(a1);
		b1.setPublisher(p1);
		b2.setPublisher(p1);
		
		authorRepository.save(a1);
		bookRepository.save(b1);
		bookRepository.save(b2);
		
		
		Author a2 = new Author();
		a2.setFirstName("Rabindranath");
		a2.setLastName("Tagore");
		Book b3 = new Book();
		b3.setTitle("Geethanjali");
		a2.getBooks().add(b3);
		b3.getAuthors().add(a2);
		b3.setPublisher(p1);
		
		authorRepository.save(a2);
		bookRepository.save(b3);
	}

}
