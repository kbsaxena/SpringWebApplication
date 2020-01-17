package demo.spring.springWebApplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import demo.spring.springWebApplication.repository.AuthorRepository;

@Controller
public class AuthorsController {

	AuthorRepository authorRepository;

	public AuthorsController(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
	
	@RequestMapping("/authors")
	public String getAuthors(Model model) {
		model.addAttribute("authors" , authorRepository.findAll());
		return "authorsPage";
	}
	
}
