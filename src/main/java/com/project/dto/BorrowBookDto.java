package com.project.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data

public class BorrowBookDto {
    @NotNull(message="bookId cannot be null")
    private int bookId;
    @NotNull(message="userId cannot be null")

    private int userId;

}
