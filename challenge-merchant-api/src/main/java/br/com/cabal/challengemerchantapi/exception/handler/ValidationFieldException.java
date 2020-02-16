package br.com.cabal.challengemerchantapi.exception.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidationFieldException extends RuntimeException {


    private Map<String, String> mapFieldErrors;
    private Object objectError;

    public ValidationFieldException(String field, String message) {
        this.mapFieldErrors = new HashMap<>();
        this.mapFieldErrors.put(field, message);
    }

    public ValidationFieldException(String field, String message, Object objectError) {
        this.mapFieldErrors = new HashMap<>();
        this.mapFieldErrors.put(field, message);
        this.objectError = objectError;
    }

    public ValidationFieldException(Map<String, String> mapFieldErrors) {
        this.mapFieldErrors = mapFieldErrors;
    }

    public ValidationFieldException(Map<String, String> mapFieldErrors, Object objectError) {
        this.mapFieldErrors = mapFieldErrors;
        this.objectError = objectError;
    }

    public List<String> getFields(){
        return new ArrayList<>(mapFieldErrors.keySet());
    }

    public String getMessageField(String field) {
        return mapFieldErrors.get(field);
    }

    public Map<String, String> getMapFieldErrors() {
        return mapFieldErrors;
    }

    public Object getObjectError() {
        return objectError;
    }
}
