package az.atlacademy.javaspring.mapper;

import az.atlacademy.javaspring.dto.AuthorRequest;
import az.atlacademy.javaspring.dto.AuthorResponse;
import az.atlacademy.javaspring.entity.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorResponse toDto(Author author);

    Author toEntity(AuthorRequest authorRequest);
}

