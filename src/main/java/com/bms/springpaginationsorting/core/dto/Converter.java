package com.bms.springpaginationsorting.core.dto;

import com.bms.springpaginationsorting.core.entities.BaseEntity;

import java.util.List;

public interface Converter<E extends BaseEntity, D extends Dto> {
    D convert(E from);

    default List<D> convert(List<E> from) {
        return from.stream().map(this::convert).toList();
    }
}
