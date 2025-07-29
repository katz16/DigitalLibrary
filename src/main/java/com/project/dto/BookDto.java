package com.project.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.entity.Author;
import com.project.entity.Genre;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private int bookId;
    private String bookName;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate publishedDate;
    private float cost;
    private int stock;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @ManyToOne
    @JoinColumn(name="auth_id")
    private int authorId;
}
