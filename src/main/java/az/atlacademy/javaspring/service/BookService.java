package az.atlacademy.javaspring.service;

import az.atlacademy.javaspring.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    List<Book> getBooksByAuthorId(Long authorId);
    Book createBookForAuthor(Long authorId, Book bookRequestDto);
    Book updateBook(Long bookId,Long authorId, Book bookRequestDto);
    Book deleteBook(Long bookId);
}