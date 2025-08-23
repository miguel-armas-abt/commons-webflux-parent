package com.demo.poc.commons.core.errors.exceptions;

import com.demo.poc.commons.core.constants.Symbol;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

public class JsonReadException extends GenericException {

  private static final String EXCEPTION_CODE = "00.00.03";

  public JsonReadException(String message) {
    super(
        EXCEPTION_CODE,
        "Json is not readable" + Symbol.COLON_WITH_SPACE + message,
        INTERNAL_SERVER_ERROR
    );
  }
}
