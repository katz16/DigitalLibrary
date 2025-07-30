package com.project.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.entity.Author;
import com.project.entity.Genre;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    @NotNull(message="Book id cannot be null")
    private int bookId;
    @NotNull(message="Book name cannot be null")
    @NotBlank(message="Book name cannot be blank")
    private String bookName;
    @JsonFormat(pattern="dd-MM-yyyy")
    @PastOrPresent(message="Published date cannot be in future")
    @NotNull(message="Published date cannot be null")
    @Past(message="Published date cannot be in future")
    private LocalDate publishedDate;
    @PositiveOrZero(message="Cost cannot be negative")
    private float cost;
    @PositiveOrZero(message="Stock cannot be negative")
    private int stock;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private int authorId;
}
