package com.bms.springpaginationsorting.service.request;

public record CreateBookRequest(
        int id,
        String name,
        String author
) {
}
