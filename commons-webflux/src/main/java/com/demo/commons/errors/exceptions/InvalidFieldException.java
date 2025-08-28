package com.demo.commons.errors.exceptions;

import com.demo.commons.constants.Symbol;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class InvalidFieldException extends GenericException {

    public static final String INVALID_FIELD_CODE = "00.00.01";

    public InvalidFieldException(String message) {
        super(
            INVALID_FIELD_CODE,
            "Invalid field" + Symbol.COLON_WITH_SPACE + message,
            BAD_REQUEST
        );
    }
}
