package com.bms.springpaginationsorting.service.request;

public record UpdateBookRequest(
        int id,
        String name,
        String author
) {
}
