package com.vk.jodl7.exceptions;

import lombok.Getter;

@Getter
public class NotFoundException extends Exception {
    private String message;

    public NotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
