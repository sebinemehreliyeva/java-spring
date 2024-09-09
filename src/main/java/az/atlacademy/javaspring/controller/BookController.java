package az.atlacademy.javaspring.controller;

import az.atlacademy.javaspring.entity.Book;
import az.atlacademy.javaspring.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
@Validated
public class BookController {
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{authorId}")
    public ResponseEntity<List<Book>> getBooksByAuthorId(@PathVariable Long authorId) {
        List<Book> books = bookService.getBooksByAuthorId(authorId);
        return ResponseEntity.ok(books);
    }

    @PostMapping("/{authorId}")
    public ResponseEntity<Book> createBook(@PathVariable Long authorId, @Valid @RequestBody Book bookRequestDto) {
        Book createdBook = bookService.createBookForAuthor(authorId, bookRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

    @PutMapping("/{bookId}/{authorId}")
    public ResponseEntity<Book> updateBook(@PathVariable Long bookId, @PathVariable Long authorId,
                                           @Valid @RequestBody Book bookRequestDto) {
        Book updatedBook = bookService.updateBook(bookId, authorId, bookRequestDto);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.noContent().build();
    }
}
