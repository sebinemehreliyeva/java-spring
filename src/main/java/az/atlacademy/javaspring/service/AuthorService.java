package az.atlacademy.javaspring.service;

import az.atlacademy.javaspring.entity.Author;
import az.atlacademy.javaspring.exception.ResourceNotFoundException;
import az.atlacademy.javaspring.repository.AuthorRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Slf4j
@Data
public abstract class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author createAuthor(Author author) {
        log.info("Creating author: {}", author);
        return authorRepository.save(author);
    }

    public abstract List<Author> getAllAuthors();

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + id));
    }

    public abstract Author updateAuthor(Long authorId, Author author);

    public abstract void deleteAuthor(Long authorId);
}

