package com.bms.springpaginationsorting.controller;

import com.bms.springpaginationsorting.dto.BookDto;
import com.bms.springpaginationsorting.dto.BookModel;
import com.bms.springpaginationsorting.service.BookService;
import com.bms.springpaginationsorting.service.request.CreateBookRequest;
import com.bms.springpaginationsorting.service.request.UpdateBookRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> createBook(@RequestBody CreateBookRequest request) {
        service.createBook(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBook(@PathVariable int id, @RequestBody UpdateBookRequest request) {
        service.updateBook(id, request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable int id) {
        return ResponseEntity.ok(service.getBookById(id));
    }

    @GetMapping
    public ResponseEntity<BookModel> getAllBooks(@RequestParam(value = "page", defaultValue = "0") int page,
                                                 @RequestParam(value = "size", defaultValue = "10") int size,
                                                 @RequestParam(value = "sort", defaultValue = "id") String sortBy,
                                                 @RequestParam(value = "direction", defaultValue = "asc") String sortDirection) {
        return ResponseEntity.ok(service.getAllBooks(page, size, sortBy, sortDirection));
    }
}
