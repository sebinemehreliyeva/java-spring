package az.atlacademy.javaspring.mapper;

import az.atlacademy.javaspring.dto.BookRequest;
import az.atlacademy.javaspring.dto.BookResponse;
import az.atlacademy.javaspring.entity.Author;
import az.atlacademy.javaspring.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {


    BookResponse toResponse(Book book);


    @Mapping(source = "author", target = "author")
    Book toEntity(BookRequest bookRequest, Author author);
}

