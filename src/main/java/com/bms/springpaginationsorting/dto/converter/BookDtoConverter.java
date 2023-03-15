package com.bms.springpaginationsorting.dto.converter;

import com.bms.springpaginationsorting.core.dto.Converter;
import com.bms.springpaginationsorting.dto.BookDto;
import com.bms.springpaginationsorting.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookDtoConverter implements Converter<Book, BookDto> {
    @Override
    public BookDto convert(Book from) {
        return new BookDto(
                from.getId(),
                from.getName(),
                from.getAuthor()
        );
    }
}
