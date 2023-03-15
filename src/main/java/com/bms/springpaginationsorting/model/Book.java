package com.bms.springpaginationsorting.model;

import com.bms.springpaginationsorting.core.entities.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements BaseEntity {
    @Id
    private int id;
    private String name;
    private String author;
}
