package az.atlacademy.javaspring.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequest {
    @NotNull(message = "Title cannot be null")

    @NotBlank(message = "Book name is required")

    @Size(min = 1, max = 100, message = "Title must be between 1 and 100 characters")
    private String title;

    @Min(value = 1, message = "Count must be greater than zero")
    private int count;

    @NotNull(message = "Author ID is required")
    private Long authorId;


}
