package com.example.cityapi.Exception;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ValidationExceptionDetails extends ExceptionDetails {
    private final String fields;
    private final String fieldsMessage;
}