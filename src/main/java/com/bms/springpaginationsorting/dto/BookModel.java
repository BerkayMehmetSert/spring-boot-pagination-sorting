package com.bms.springpaginationsorting.dto;

import com.bms.springpaginationsorting.core.dto.BasePageableModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookModel extends BasePageableModel {
    private List<BookDto> items;
}
