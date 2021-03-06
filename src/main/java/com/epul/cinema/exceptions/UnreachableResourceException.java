package com.epul.cinema.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UnreachableResourceException extends RuntimeException {
    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public UnreachableResourceException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("Impossible d'obtenir la ressource %s qui a pour %s la valeur '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}