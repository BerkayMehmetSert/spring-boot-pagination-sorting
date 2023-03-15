package com.bms.springpaginationsorting.service;

import com.bms.springpaginationsorting.dto.BookDto;
import com.bms.springpaginationsorting.dto.BookModel;
import com.bms.springpaginationsorting.dto.converter.BookDtoConverter;
import com.bms.springpaginationsorting.model.Book;
import com.bms.springpaginationsorting.repository.BookRepository;
import com.bms.springpaginationsorting.service.request.CreateBookRequest;
import com.bms.springpaginationsorting.service.request.UpdateBookRequest;
import com.bms.springpaginationsorting.service.rules.BookBusinessRules;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookDtoConverter converter;
    private final BookBusinessRules rules;

    public BookService(BookRepository bookRepository, BookDtoConverter converter, BookBusinessRules rules) {
        this.bookRepository = bookRepository;
        this.converter = converter;
        this.rules = rules;
    }

    public void createBook(final CreateBookRequest request) {
        rules.checkIfBookExistsByName(request.name());

        var book = new Book();
        book.setId(request.id());
        book.setName(request.name());
        book.setAuthor(request.author());

        bookRepository.save(book);
    }

    public void updateBook(final int id, final UpdateBookRequest request) {
        var book = getBook(id);
        book.setName(request.name());
        book.setAuthor(request.author());

        bookRepository.save(book);
    }

    public void deleteBook(final int id) {
        bookRepository.delete(getBook(id));
    }

    public BookDto getBookById(final int id) {
        var book = getBook(id);

        return converter.convert(book);
    }

    public BookModel getAllBooks(final int page, final int size, final String sortBy, final String sortDirection) {
        var sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        var pageable = PageRequest.of(page, size, sort);
        var books = bookRepository.findAll(pageable);

        var response = new BookModel();
        response.setItems(converter.convert(books.getContent()));
        response.setPage(books.getNumber());
        response.setSize(books.getSize());
        response.setTotalItems((int) books.getTotalElements());
        response.setTotalPages(books.getTotalPages());
        response.setHasNext(books.hasNext());
        response.setHasPrevious(books.hasPrevious());

        return response;
    }

    private Book getBook(final int id) {
        return rules.checkIfBookExists(id);
    }
}
