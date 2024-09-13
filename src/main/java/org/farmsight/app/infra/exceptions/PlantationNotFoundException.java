package org.farmsight.app.infra.exceptions;

public class PlantationNotFoundException extends NotFoundException {
    public PlantationNotFoundException(String message) {
        super(message);
    }
}