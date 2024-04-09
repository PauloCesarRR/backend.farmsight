package org.farmsight.app.infra.exceptions;

import java.util.HashMap;
import java.util.Map;

public abstract class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }

}