package org.farmsight.app.infra.exceptions;


public abstract class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}