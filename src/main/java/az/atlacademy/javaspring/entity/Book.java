package az.atlacademy.javaspring.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import lombok.Getter;

import lombok.Setter;

@Entity
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Book name is required")
    private String name;

    @Min(value = 1, message = "Book count must be at least 1")
    private int count;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;


}

