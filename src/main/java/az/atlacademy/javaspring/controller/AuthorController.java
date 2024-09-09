package az.atlacademy.javaspring.controller;

import az.atlacademy.javaspring.dto.AuthorRequest;
import az.atlacademy.javaspring.dto.AuthorResponse;
import az.atlacademy.javaspring.entity.Author;
import az.atlacademy.javaspring.mapper.AuthorMapper;
import az.atlacademy.javaspring.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;
    private final AuthorMapper authorMapper;

    public AuthorController(AuthorService authorService, AuthorMapper authorMapper) {
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }

    @PostMapping
    public ResponseEntity<AuthorResponse> createAuthor(@Valid @RequestBody AuthorRequest authorRequest) {
        Author author = authorMapper.toEntity(authorRequest);
        Author savedAuthor = authorService.createAuthor(author);
        AuthorResponse response = authorMapper.toDto(savedAuthor);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponse> getAuthor(@PathVariable Long id) {
        Author author = authorService.getAuthorById(id);
        return ResponseEntity.ok(authorMapper.toDto(author));
    }
}

