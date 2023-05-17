package com.bezkoder.springgraphql.mysql.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bezkoder.springgraphql.mysql.model.Author;
import com.bezkoder.springgraphql.mysql.model.Editorial;
import com.bezkoder.springgraphql.mysql.model.Libro;
import com.bezkoder.springgraphql.mysql.model.Tutorial;
import com.bezkoder.springgraphql.mysql.repository.AuthorRepository;
import com.bezkoder.springgraphql.mysql.repository.EditorialRepository;
import com.bezkoder.springgraphql.mysql.repository.LibroRepository;
import com.bezkoder.springgraphql.mysql.repository.TutorialRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class Query implements GraphQLQueryResolver {
	private AuthorRepository authorRepository;
	private TutorialRepository tutorialRepository;
	private EditorialRepository editorialRepository;
	private LibroRepository libroRepository;

	@Autowired
	public Query(AuthorRepository authorRepository, TutorialRepository tutorialRepository,EditorialRepository editorialRepository,LibroRepository libroRepository ) {
		this.authorRepository = authorRepository;
		this.tutorialRepository = tutorialRepository;
		this.editorialRepository = editorialRepository;
		this.libroRepository = libroRepository;
	}

	public Iterable<Author> findAllAuthors() {
		return authorRepository.findAll();
	}

	public Iterable<Tutorial> findAllTutorials() {
		return tutorialRepository.findAll();
	}

	public Iterable<Editorial> findAllEditorials() {
		return editorialRepository.findAll();
	}
	public Iterable<Libro> findAllLibros() {
		return libroRepository.findAll();
	}

	public long countAuthors() {
		return authorRepository.count();
	}

	public long countTutorials() {
		return tutorialRepository.count();
	}
	public long countEditorials() {
		return editorialRepository.count();
	}
	public long countLibros() {
		return libroRepository.count();
	}
}
