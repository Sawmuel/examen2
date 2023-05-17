package com.bezkoder.springgraphql.mysql.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bezkoder.springgraphql.mysql.model.Author;
import com.bezkoder.springgraphql.mysql.model.Editorial;
import com.bezkoder.springgraphql.mysql.model.Libro;
import com.bezkoder.springgraphql.mysql.repository.AuthorRepository;
import com.bezkoder.springgraphql.mysql.repository.EditorialRepository;

import com.coxautodev.graphql.tools.GraphQLResolver;

@Component
public class LibroResolver implements GraphQLResolver<Libro> {
	@Autowired
	private AuthorRepository authorRepository;
	private EditorialRepository editorialRepository;

	public LibroResolver(AuthorRepository authorRepository, EditorialRepository editorialRepository) {
		this.authorRepository = authorRepository;
		this.editorialRepository = editorialRepository;
	}

	public Author getAuthor(Libro libro) {
		return authorRepository.findById(libro.getAuthor().getId()).orElseThrow(null);
	}

	public Editorial getEditorial(Libro libro) {
		return editorialRepository.findById(libro.getEditorial().getId()).orElseThrow(null);
	}

}
