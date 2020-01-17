package demo.spring.springWebApplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import demo.spring.springWebApplication.repository.BookRepository;

@Controller
public class BooksController {
	
	private BookRepository bookRepository;

	public BooksController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	@RequestMapping("/books")
	public String getBooks(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		
		return "booksPage";
	}

}
