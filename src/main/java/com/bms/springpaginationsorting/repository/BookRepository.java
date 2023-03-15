package com.bms.springpaginationsorting.repository;

import com.bms.springpaginationsorting.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
    boolean existsByNameIgnoreCase(String name);
}