package org.farmsight.app.infra.exceptions;

public class FarmNotFoundException extends NotFoundException {
    public FarmNotFoundException(String message) {
        super(message);
    }
}