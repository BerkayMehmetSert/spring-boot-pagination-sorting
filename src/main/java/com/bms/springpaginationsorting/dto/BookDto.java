package com.bms.springpaginationsorting.dto;

import com.bms.springpaginationsorting.core.dto.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto implements Dto {
    private int id;
    private String name;
    private String author;
}
