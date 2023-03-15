package com.bms.springpaginationsorting.service.rules;

import com.bms.springpaginationsorting.core.exceptions.BusinessException;
import com.bms.springpaginationsorting.core.exceptions.NotFoundException;
import com.bms.springpaginationsorting.model.Book;
import com.bms.springpaginationsorting.repository.BookRepository;
import com.bms.springpaginationsorting.service.contains.BusinessMessages;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookBusinessRules {
    private final BookRepository bookRepository;

    public BookBusinessRules(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void checkIfBookExistsByName(final String name) {
        if (bookRepository.existsByNameIgnoreCase(name)) {
            throw new BusinessException(BusinessMessages.BOOK_ALREADY_EXISTS);
        }
    }

    public Book checkIfBookExists(final int id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(BusinessMessages.BOOK_NOT_FOUND));
    }

    public void checkIfBookListIsEmpty(final List<Book> books){
        if(books.isEmpty()){
            throw new NotFoundException(BusinessMessages.BOOK_LIST_IS_EMPTY);
        }
    }
}
