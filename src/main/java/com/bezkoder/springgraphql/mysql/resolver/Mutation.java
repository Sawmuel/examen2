package com.bezkoder.springgraphql.mysql.resolver;

import java.util.Optional;

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
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import javassist.NotFoundException;

@Component
public class Mutation implements GraphQLMutationResolver {
	private AuthorRepository authorRepository;
	private TutorialRepository tutorialRepository;
	private LibroRepository libroRepository;
	private EditorialRepository editorialRepository;

	@Autowired
	public Mutation(AuthorRepository authorRepository, TutorialRepository tutorialRepository, LibroRepository libroRepository, EditorialRepository editorialRepository) {
		this.authorRepository = authorRepository;
		this.tutorialRepository = tutorialRepository;
		this.libroRepository = libroRepository;
		this.editorialRepository = editorialRepository;
	}

	public Author createAuthor(String nombres, String apeliidos, String pais) {
		Author author = new Author();
		author.setNombres(nombres);
		author.setApellidos(apeliidos);
		author.setPais(pais);

		authorRepository.save(author);

		return author;
	}

	public Tutorial createTutorial(String title, String description, Long authorId) {
		Tutorial book = new Tutorial();
		book.setAuthor(new Author(authorId));
		book.setTitle(title);
		book.setDescription(description);

		tutorialRepository.save(book);

		return book;
	}

	public Libro createLibro(String titulo, String descripcion,Integer paginas, String edicion, Long authorId, Long editorialID) {
		Libro libro = new Libro();
		libro.setDescripcion(descripcion);
		libro.setPaginas(paginas);
		libro.setEdicion(edicion);
		libro.setAuthor(new Author(authorId));
		libro.setEditorial(new Editorial(editorialID));

		libroRepository.save(libro);

		return libro;
	}
	public Editorial createEditorial(String nombre, String pais) {
		Editorial editorial = new Editorial();
		editorial.setNombre(nombre);
		editorial.setPais(pais);

		editorialRepository.save(editorial);

		return editorial;
	}

	public boolean deleteTutorial(Long id) {
		tutorialRepository.deleteById(id);
		return true;
	}

	public boolean deleteLibro(Long id) {
		libroRepository.deleteById(id);
		return true;
	}
	

	public Tutorial updateTutorial(Long id, String title, String description) throws NotFoundException {
		Optional<Tutorial> optTutorial = tutorialRepository.findById(id);

		if (optTutorial.isPresent()) {
			Tutorial tutorial = optTutorial.get();

			if (title != null)
				tutorial.setTitle(title);
			if (description != null)
				tutorial.setDescription(description);

			tutorialRepository.save(tutorial);
			return tutorial;
		}

		throw new NotFoundException("Not found Tutorial to update!");
	}

	public Libro updateLibro(Long id, String titulo, String descripcion,Integer paginas, String edicion) throws NotFoundException {
		Optional<Libro> optLibro = libroRepository.findById(id);

		if (optLibro.isPresent()) {
			Libro libro = optLibro.get();

			if (titulo != null)
			libro.setTitulo(titulo);
			if (descripcion != null)
			libro.setDescripcion(descripcion);
			if (paginas !=null)
			libro.setPaginas(paginas);
			if(edicion !=null)
			libro.setEdicion(edicion);

			libroRepository.save(libro);
			return libro;
		}

		throw new NotFoundException("Not found Libro to update!");
	}
	
}
