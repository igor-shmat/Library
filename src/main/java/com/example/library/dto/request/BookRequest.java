package com.example.library.dto.request;

import com.example.library.entity.BookStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {
    private String name;
    private BookStatus bookStatus;

}
